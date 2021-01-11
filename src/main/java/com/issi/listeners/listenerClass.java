package com.issi.listeners;

import com.issi.annotations.FrameWorkAnnotation;
import com.issi.reports.ExtentLogger;
import com.issi.reports.ExtentReport;
import org.testng.*;

/**
 * this listeners class is defined to perform specific behaviour before and after the script execution
 */

public class listenerClass implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createExtentTest(result.getMethod().getMethodName());          //creating node for extenttest and with reflection it will get method name automatically
        ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameWorkAnnotation.class)
                .author());
        ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameWorkAnnotation.class)
                .category());
        ExtentReport.addDevice(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameWorkAnnotation.class)
                .device());

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentLogger.pass(result.getMethod().getMethodName() + " is passed ", false);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " was failed miserably ", true);
        // if true screenshot will be attached
        ExtentLogger.fail(result.getThrowable().toString());
        //  ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped ", false);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        /*

         */
    }

    @Override
    public void onStart(ITestContext context) {

        /*
         We haave only one test in suite
         */
    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
