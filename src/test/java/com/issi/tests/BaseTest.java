package com.issi.tests;

import com.issi.driver.Driver;
import com.issi.reports.ExtentReport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Map;

public class BaseTest {
    protected BaseTest() {
    }


    @BeforeMethod
    protected void setUp(Object[] data) {
        Map<String ,String> map =  (Map<String ,String>)data[0];
        Driver.initDriver(map.get("browser"));
    }

    @AfterMethod
    protected void tearDown() {
        Driver.quiteDriver();
    }



}
