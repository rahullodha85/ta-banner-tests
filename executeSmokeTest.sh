#!/bin/bash
#
set +e
export JAVA_HOME=/home/go/jdk1.8.0_45
echo $JAVA_HOME

exitCode=0
browserType='REMOTE'
browserName='firefox'
slotNumber=$1
slotType=$2
remoteHub='http://10.32.150.47:4444/wd/hub'
objectRepo='SaksObjectRepository2.csv'
slot=$(echo $slotNumber| cut -d's' -f 2)
url=""

if [ "$slotType" == "qa" ] ; then
    url="http://qaslot"$slot".saksdirect.com"
fi

echo 'Executing tests on slot environment:' $url
mvn install
mvn clean test -DUrl="$url" -DBrowserType="$browserType" -DBrowserName="$browserName" -DRemoteHub="$remoteHub" -DObjectRepo="$objectRepo" -DskipTestExecution=false
if [ $? -gt 0 ] ; then
    exitCode=1
fi
mvn exec:java -Dexec.mainClass=com.hbcd.ReportMerger -Dparam=target/cucumber-parallel/
echo $exitCode
exit $exitCode
