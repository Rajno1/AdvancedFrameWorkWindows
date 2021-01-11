package com.issi.constants;

import com.issi.enums.ConfigProperties;
import com.issi.utils.PropertyUtils;

public final class FrameWorkConstants {
    /**
     * To avoid hardcoding we have created this class
     * and we declared it as 'final' to not extend this class
     * also created 'private constructor' to restrict not to create an object for this class
     *
     * This class contains constant values and its caller methods
     */

    private FrameWorkConstants() {
    }

    private static final String MAINRESOURCEPATH = System.getProperty("user.dir") + "/src/main/resources";
    private static final String TESTRESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CHROMEDRIVERPATH = TESTRESOURCESPATH + "/DriverExecutables/chromedriver.exe";
    private static final String GECKODRIVERPATH = TESTRESOURCESPATH + "/DriverExecutables/geckodriver.exe";
    private static final String IEDRIVERPATH = TESTRESOURCESPATH + "/DriverExecutables/IEDriverServer.exe";
    private static final String CONFIGFILEPATH = TESTRESOURCESPATH + "/config/config.properties";
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/Extent-test-output/";
    private static final String RUNMANAGERSHEET = "RunManager";

    public static String getGeckoDriverPath() {
        return GECKODRIVERPATH;
    }

    public static String getIEDriverPath() {
        return IEDRIVERPATH;
    }
    public static String getRunManagerSheet() {
        return RUNMANAGERSHEET;
    }

    public static String getIterationDataSheet() {
        return ITERATIONDATASHEET;
    }

    private static final String ITERATIONDATASHEET = "DATA";


    private static final String EXCELPATH = TESTRESOURCESPATH+"/TestData/testdata.xlsx";
    public static String getExtentReportFilePath() {
        if (extentReportFilePath.isEmpty()){
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }

    private static String createReportPath(){
        if (PropertyUtils.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")){
            return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/index.html";
        }else {
            return EXTENTREPORTFOLDERPATH+"index.html";
        }
    }

    private static String extentReportFilePath = "";
    private static final String TESTFAILUREREPORTPATH = System.getProperty("user.dir") + "/Extent-test-output/failure_index.html";
    private static final String SPARKCONFIGFILEPATH = MAINRESOURCEPATH + "/spark-config.xml";
    private static final String CONFIGJSONFILEPATH = TESTRESOURCESPATH + "/jsons/config.json";
    private static final String CONFIG2JSONFILEPATH = TESTRESOURCESPATH + "/jsons/config2.json";
    private static final int EXPLICITWAIT = 10;

    public static String getChromeDriverPath() {
        return CHROMEDRIVERPATH;
    }


//    public static String getExtentReportPath() {
//        if (PropertyUtils.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")){
//            return EXTENTREPORTPATH+"/"+ System.currentTimeMillis()+"index.html";
//        } else {
//            return EXTENTREPORTPATH+"/"+"index.html";
//        }
//    }


    public static String getCONFIG2JSONFILEPATH() {
        return CONFIG2JSONFILEPATH;
    }

    public static String getTestFailurePortPath() {
        return TESTFAILUREREPORTPATH;
    }

    public static String getSparkConfigFilePath() {
        return SPARKCONFIGFILEPATH;
    }


        public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }

    public static int getEXPLICITWAIT() {
        return EXPLICITWAIT;
    }

    public static String getConfigJsonFilePath() {
        return CONFIGJSONFILEPATH;
    }

    public static String getExcelPath() {
        return EXCELPATH;
    }

}
