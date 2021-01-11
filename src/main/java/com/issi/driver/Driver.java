package com.issi.driver;

import com.issi.constants.FrameWorkConstants;
import com.issi.enums.ConfigProperties;
import com.issi.reports.ExtentLogger;
import com.issi.utils.PropertyUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.util.Objects;

public final class Driver {
    private Driver() {
    }

    /**
     * since we are using Thread local variable for webdriver
     * we are declaring below static driver reference as 'private'
     */


    public static void initDriver(String browser) {
        if (Objects.isNull(DriverManager.getDriver())) {

            if (browser.equalsIgnoreCase("chrome")){
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                System.setProperty("webdriver.chrome.driver", FrameWorkConstants.getChromeDriverPath());
                 System.setProperty("webdriver.chrome.silentOutput","true");  // to suppress warnings in console while running.
                DriverManager.setDriver(new ChromeDriver(options)); // we can initiate chrome driver in this way as well
            } else if (browser.equalsIgnoreCase("firefox")){
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("-private");

                System.setProperty("webdriver.gecko.driver", FrameWorkConstants.getGeckoDriverPath());
                DriverManager.setDriver(new FirefoxDriver(options));
            } else if (browser.equalsIgnoreCase("ie")) {
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                ieOptions.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");

                System.setProperty("webdriver.ie.driver", FrameWorkConstants.getIEDriverPath());
                DriverManager.setDriver(new InternetExplorerDriver(ieOptions)); // we can initiate chrome driver in this wa

            }

            DriverManager.getDriver().manage().window().maximize(); //Maximize browser
            DriverManager.getDriver().manage().deleteAllCookies(); //Delete all cookies

            DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));
        }

    }

    /**
     * in this method to set driver value as null
     * we are using 'unload()' recomanded by 'SonarLint plugin'
     * this method will remove threadlocal variable (dr) value.
     */
    public static void quiteDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }

    }
}
