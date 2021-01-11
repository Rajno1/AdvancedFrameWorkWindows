package com.issi.pages;

import com.issi.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage extends BasePage{

    @FindBy(id = "nav-hamburger-menu")
    private WebElement linkHamburger;

    public AmazonHomePage() {
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public AmazonHambergurMenuPage clickHamburger(){
        linkHamburger.click();
        return new AmazonHambergurMenuPage();
    }
}
