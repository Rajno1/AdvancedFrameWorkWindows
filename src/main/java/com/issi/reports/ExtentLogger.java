package com.issi.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.issi.enums.ConfigProperties;
import com.issi.utils.PropertyUtils;
import com.issi.utils.ScreenshotUtils;

public final class ExtentLogger {
    private ExtentLogger() {
    }


    public static void pass(String message){
        ExtentManager.getExtentTest().pass(message);
    }
    public static void fail(String message){
        ExtentManager.getExtentTest().fail(message);
    }
    public static void skip(String message){
        ExtentManager.getExtentTest().skip(message);
    }



    public static void pass(String message, boolean isScreenshotneeded){
        if (PropertyUtils.getValue(ConfigProperties.PASSEDSTEPSCREENSHOT).equalsIgnoreCase("yes")
        && isScreenshotneeded){
            ExtentManager.getExtentTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }else {
            pass(message);
        }
    }
    public static void fail(String message,boolean isScreenshotneeded){
        if (PropertyUtils.getValue(ConfigProperties.FAILEDSTEPSCREENSHOT).equalsIgnoreCase("yes")
                && isScreenshotneeded){
            ExtentManager.getExtentTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }else {
            fail(message);
        }
    }
    public static void skip(String message,boolean isScreenshotneeded){
        if (PropertyUtils.getValue(ConfigProperties.SKIPPEDSTEPSCREENSHOT).equalsIgnoreCase("yes")
                && isScreenshotneeded){
            ExtentManager.getExtentTest().skip(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }else {
            skip(message);
        }
    }

}
