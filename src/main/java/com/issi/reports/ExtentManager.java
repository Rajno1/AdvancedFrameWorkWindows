package com.issi.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
    private ExtentManager() {
    }

    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

    static ExtentTest getExtentTest()  { //default --> it can be accessed with in the package
        return extTest.get();
    }

    static void setExtentTest(ExtentTest test) {
        extTest.set(test);
    }

    public static void unload() {
        extTest.remove();
    }

}
