package com.issi.pages;

import com.issi.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class OrangeHRMHomePage extends BasePage {
    private final By linkWelcome = By.id("welcome");
    private final By linkLogout = By.xpath("//a[text()='Logout']");

    private final By adminModuleLink = By.id("menu_admin_viewAdminModule");
    private final By usemanagementLink = By.id("menu_admin_UserManagement");
    private final By searchUsernameText = By.id("searchSystemUser_userName");
    private final By serarchBtn = By.id("searchBtn");


    public OrangeHRMHomePage cickAdminModule(){
        clickOn(adminModuleLink,WaitStrategy.PRESENCE,"Admin module linke");
        return this;
    }
    public OrangeHRMHomePage cickUserManagementLink(){
        clickOn(usemanagementLink,WaitStrategy.PRESENCE,"User management link");
        return this;

    }
    public OrangeHRMHomePage enterUsernametoseach(){
        enterValue(searchUsernameText,"Raja",WaitStrategy.PRESENCE,"username to search");
        return this;

    }
    public OrangeHRMHomePage cickOnSearchBtn(){
        clickOn(serarchBtn,WaitStrategy.PRESENCE,"Search Button");
        return this;

    }




    public OrangeHRMHomePage clickWelcome() {
        clickOn(linkWelcome, WaitStrategy.PRESENCE,"Welcome link");
        return this;
    }

    public OrangeHRMLoginPage clickLogOut() {
        clickOn(linkLogout,WaitStrategy.CLICKABLE,"logout link");
        return new OrangeHRMLoginPage();
    }
}
