package com.issi.pages;

import com.issi.enums.WaitStrategy;
import com.issi.utils.DynamicXpathUtils;
import org.openqa.selenium.By;

public class AmazonHambergurMenuPage extends BasePage{

    /** Dynamic locator VS pageFactory
     * We are trying to overcome this pageFactory issue, with the help of
     * String locator strategy let see ..
     *
     */


    private String linkMobilesAndComputers = "//div[text()='Mobiles, Computers']/parent::a";


    // String locator
    private String linkSubMenu = "//a[text()='%s']";  // adding wild cards
    public AmazonLaptopPage clickOnSubMenuItem(String menutext){
        String newxpath = DynamicXpathUtils.getXpath(linkSubMenu,menutext);
        clickOn(By.xpath(newxpath), WaitStrategy.CLICKABLE,menutext);
        if (menutext.contains("Laptops")){
            return new AmazonLaptopPage();
        }
        return null;
    }


    public AmazonHambergurMenuPage clickMobileAndComputers(){
        clickOn(By.xpath(linkMobilesAndComputers),WaitStrategy.CLICKABLE,"Mobiles and computers");
        return this;
    }


}
