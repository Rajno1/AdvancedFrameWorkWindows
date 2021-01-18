package com.issi.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.issi.constants.FrameWorkConstants;
import com.issi.enums.CategoryType;
import com.issi.exceptions.FrameWorkExceptions;
import net.bytebuddy.implementation.bytecode.Throw;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {
    private static ExtentReports extent;
    private static ExtentSparkReporter spark;

    private  ExtentReport() {
    }

    public static void initReport(){
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            spark = new ExtentSparkReporter(FrameWorkConstants.getExtentReportFilePath()).viewConfigurer()
                    .viewOrder()
                    .as(new ViewName[]{
                            ViewName.TEST,
                            ViewName.LOG,
                            ViewName.EXCEPTION,
                            ViewName.DEVICE,
                            ViewName.AUTHOR,
                            ViewName.DASHBOARD
                    })
                    .apply();
            try {
                spark.loadXMLConfig(new File(FrameWorkConstants.getSparkConfigFilePath())); // configured 'spark-config.xml' file
            } catch (IOException e) {
                e.printStackTrace();
            }
            extent.setSystemInfo("os", "Window10");
            extent.attachReporter(spark);
        }
    }

    public static void flushReports(){
        if (Objects.nonNull(extent)) {
            try {
                extent.flush();
                ExtentManager.unload();
                Desktop.getDesktop().browse(new File(FrameWorkConstants.getExtentReportFilePath()).toURI());
                //  SendEmailWithAttachment.mailTheReport();
            } catch (IOException e) {
                throw new FrameWorkExceptions("Some IO Exception happen while launching extent report on default browser");
              //  e.printStackTrace();
            }
        }
    }

    public static void createExtentTest(String testcasename){
       ExtentTest test = extent.createTest(testcasename);
       ExtentManager.setExtentTest(test);
    }

    public static void addAuthors(String [] authors){
        for (String temp: authors){
            ExtentManager.getExtentTest().assignAuthor(temp);
        }
    }

    public static void addCategories(CategoryType[] categories){
        for (CategoryType temp: categories){
            ExtentManager.getExtentTest().assignCategory(temp.toString());
        }
    }

    public static void addDevice(String[] devices){
        for (String temp: devices){
            ExtentManager.getExtentTest().assignDevice(temp);
        }
    }
}
