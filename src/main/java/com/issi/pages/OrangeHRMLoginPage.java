package com.issi.pages;

import com.issi.driver.DriverManager;
import com.issi.enums.WaitStrategy;
import com.issi.reports.ExtentLogger;
import com.issi.reports.ExtentManager;
import org.openqa.selenium.By;

public final class OrangeHRMLoginPage extends BasePage {

    private final By textboxUsername = By.id("txtUsername");
    private final By textboxPassword = By.xpath("//input[@id='txtPassword' and @type='password']");
    private final By buttonLogin = By.xpath("//input[@id='btnLogin' and @type='submit']");

    public OrangeHRMLoginPage enterUserName(String username) {
        enterValue(textboxUsername, username, WaitStrategy.PRESENCE,"username");
        return this; // this line is same as 'return new OrangeHRMLoginPage'
    }

    public OrangeHRMLoginPage enterPassword(String password) {
        enterValue(textboxPassword, password,WaitStrategy.PRESENCE,"password");
        return this;
    }

    public OrangeHRMHomePage clickLogin() {
        clickOn(buttonLogin,WaitStrategy.PRESENCE,"loign button");
        return new OrangeHRMHomePage();  // for method chaining
    }

    public String get_Title() {
        return getPageTitle();
    }
}
