param([string]$worksp, [string]$selectedServers, [string]$deployThirdLib)

$svc
$exception=false

foreach($Server in $selectedServers.Split(","))
{
    echo $Server
    $uncServer="\\" + $Server
    $username="AutomationUser"
    $password="Automation123"

    $svc = Get-Service -Name "Automation Framework" -ComputerName $Server
    $destination = "\\" + $Server+ "\e$\HBCD_Automation\"
    $source=$worksp + "\target\"

    if($svc.Status -eq "Running")
    {
        echo "Stopping Automation Framework service"
        Stop-Service -InputObject $svc
        echo $svc.Status
        echo "Service Stopped"
    }

    net use $uncServer $password /USER:$username
    try
    {
        echo "Copying Jar files"
        $sourcefiles = get-childitem $source -Filter *.jar
        foreach($file in $sourcefiles)
        {
            echo $file.Name
            Copy-Item -Path $file.FullName -Destination $destination
        }

        echo "Copying resource files"
        $source=$worksp + "\target\classes\"
        $sourcefiles = get-childitem $source -Include *.csv,*.xlsx,*.properties -Recurse
        foreach($file in $sourcefiles)
        {
            echo $file.Name
            Copy-Item -Force -Path $file.FullName -Destination $destination
        }

        if($deployThirdLib -eq $true)
        {
            $source = $worksp + "\target\HBCDAutomationExecutionProcess_lib\"
            if(Test-Path $source)
            {
                Write-Host "Copying Third Party jar files"
                $directory = $destination + "HBCDAutomationExecutionProcess_lib"
                if(Test-Path $directory)
                {
                    Write-Host "Deleting HBCDAutomationExecutionProcess_lib and its contents"
                    Remove-Item -Recurse -Force $directory
                }
                Write-Host "Creating directory HBCDAutomationExecutionProcess_lib"
                New-Item $directory -ItemType directory
                $sourcefiles = Get-ChildItem $source -Filter *.jar
                foreach($file in $sourcefiles)
                {
                    Write-Host "Copying" $file.Name
                    Copy-Item -Force -Path $file.FullName -Destination $directory
                }
            }
        }
    }
    catch [Exception]
    {
        $exception=true
        echo $_.Exception.GetType().FullName, $_.Exception.Message
        echo "Error copying jar and/or resource files"
        net use $uncServer /delete
    }
    finally
    {
        echo "Starting Automation Framework service"
        Start-Service -InputObject $svc
        echo $svc.Status
        if($exception)
        {
            exit 1
        }
    }
}