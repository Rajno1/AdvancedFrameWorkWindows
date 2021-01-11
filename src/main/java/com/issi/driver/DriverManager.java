package com.issi.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
    private DriverManager() {
    }

    /**
     * Here we are creating ThreadLocal variable for WebDriver
     * and creating 3 methods like 'dr.get()', dr.set(driverref) and remove()
     * methods to make use of it.
     */

    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();
    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void setDriver(WebDriver driverref) {
        dr.set(driverref);
    }

    public static void unload(){
        dr.remove();
    }

}
