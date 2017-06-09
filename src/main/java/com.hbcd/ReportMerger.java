package com.hbcd;

/**
 * Created by 461967 on 8/17/2016.
 */
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class ReportMerger {
    private static String reportFileName = "report.js";
    private static String reportImageExtension = "png";

    public static void main(String[] args) throws Throwable {
        File reportDirectory = new File(System.getProperty("param"));
        if (reportDirectory.exists()) {
            ReportMerger munger = new ReportMerger();
            munger.mergeReports(reportDirectory);
            munger.mergeJson(reportDirectory);
        }
    }

    /**
     * Merge all reports together into master report in given reportDirectory
     * @param reportDirectory
     * @throws Exception
     */
    public void mergeReports(File reportDirectory) throws Throwable {
        Collection<File> existingReports = FileUtils.listFiles(reportDirectory, new String[]{"js"}, true);

        File mergedReport = null;

        for (File report : existingReports) {
            //only address report files
            if (report.getName().equals(reportFileName)) {
                //rename all the image files (to give unique names) in report directory and update report
                renameEmbededImages(report);

                //if we are on the first pass, copy the directory of the file to use as basis for merge
                if (mergedReport == null) {
                    FileUtils.copyDirectory(report.getParentFile(), reportDirectory);
                    mergedReport = new File(reportDirectory, reportFileName);
                    //otherwise merge this report into existing master report
                } else {
                    mergeFiles(mergedReport, report);
                }
            }
        }
    }

    /**
     * merge source file into target
     *
     * @param target
     * @param source
     */
    public void mergeFiles(File target, File source) throws Throwable {
        //copy embeded images
        Collection<File> embeddedImages = FileUtils.listFiles(source.getParentFile(), new String[]{reportImageExtension}, true);
        for (File image : embeddedImages) {
            FileUtils.copyFileToDirectory(image, target.getParentFile());
        }

        //merge report files
        String targetReport = FileUtils.readFileToString(target);
        String sourceReport = FileUtils.readFileToString(source);

        FileUtils.writeStringToFile(target, targetReport + sourceReport);
    }

    /**
     * Give unique names to embedded images to ensure they aren't lost during merge
     * Update report file to reflect new image names
     *
     * @param reportFile
     */
    public void renameEmbededImages(File reportFile) throws Throwable {
        File reportDirectory = reportFile.getParentFile();
        Collection<File> embeddedImages = FileUtils.listFiles(reportDirectory, new String[]{reportImageExtension}, true);

        String fileAsString = FileUtils.readFileToString(reportFile);

        for (File image : embeddedImages) {
            String curImageName = image.getName();
            String uniqueImageName = UUID.randomUUID().toString() + "." + reportImageExtension;

            image.renameTo(new File(reportDirectory, uniqueImageName));
            fileAsString = fileAsString.replace(curImageName, uniqueImageName);
        }

        FileUtils.writeStringToFile(reportFile, fileAsString);
    }

    public void mergeJson(File reportDir) throws Exception {
        List<String> jsonStrings = readFile(reportDir);
        JSONArray jsonArray = new JSONArray();
        for(String jsonString:jsonStrings){
            JSONObject json = parseJson(jsonString);
            if(json != null){
                jsonArray.put(jsonArray.length(), json);
            }
        }
        reportWriter(reportDir.getAbsolutePath(), jsonArray);
    }

    public List<String> readFile(File reportDir) throws Exception {
        List<String> jsonStrings = new ArrayList<>();
        File[] files = reportDir.listFiles();
        for (File file :
                files) {
            if (file.getName().endsWith(".json")) {
                System.out.print(file.getAbsolutePath() + "\n");
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(file.getAbsolutePath())));
                String line, body = null;
                while ((line = br.readLine()) != null) {
                    if (body == null) {
                        body = line;
                    } else {
                        body = body + line;
                    }
                }
                jsonStrings.add(body);
            }
        }
        return jsonStrings;
    }

    public JSONObject parseJson(String jsonString) throws Exception {
        Object json = new JSONTokener(jsonString).nextValue();
        if (json instanceof JSONArray) {
            JSONArray temp = (JSONArray) json;
            return temp.getJSONObject(0);
        } else if (json instanceof JSONObject) {
            JSONObject temp = (JSONObject) json;
            return temp;
        } else {
            return null;
        }
    }

    public void reportWriter(String reportDir, JSONArray report) throws Exception {
        FileWriter file = new FileWriter(reportDir + "/output.json");
        file.write(report.toString());
        file.flush();
        file.close();
    }
}
