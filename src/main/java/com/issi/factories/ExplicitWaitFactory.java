package com.issi.factories;

import com.issi.constants.FrameWorkConstants;
import com.issi.driver.DriverManager;
import com.issi.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitFactory {
    public static WebElement performExplicitWait( By by,WaitStrategy waitstrategy) {

        WebElement element = null;
        if (waitstrategy == WaitStrategy.CLICKABLE) {
            element =  new WebDriverWait(DriverManager.getDriver(), FrameWorkConstants.getEXPLICITWAIT())
                    .until(ExpectedConditions.elementToBeClickable(by));
        } else if (waitstrategy == WaitStrategy.PRESENCE) {
            element = new WebDriverWait(DriverManager.getDriver(), FrameWorkConstants.getEXPLICITWAIT())
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } else if(waitstrategy == WaitStrategy.VISIBLE){
            element =  new WebDriverWait(DriverManager.getDriver(), FrameWorkConstants.getEXPLICITWAIT())
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if(waitstrategy == WaitStrategy.NONE){
            element = DriverManager.getDriver().findElement(by);
        }
        return element;
    }
}
