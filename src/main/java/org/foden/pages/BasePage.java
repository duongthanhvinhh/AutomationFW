package org.foden.pages;

import org.foden.constants.FrameworkConstants;
import org.foden.driver.DriverManager;
import org.foden.enums.WaitStrategy;
import org.foden.factories.ExplicitWaitFactory;
import org.foden.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy, String eleName){
        ExplicitWaitFactory.performExplicitWait(waitStrategy,by).click();
            ExtentLogger.pass(eleName + " is clicked");
    }

    protected void sendKeys(By by,String value,WaitStrategy waitStrategy, String eleName){
        ExplicitWaitFactory.performExplicitWait(waitStrategy,by).sendKeys(value);
        ExtentLogger.pass(value + " is entered successfully in " + eleName);
    }

    public String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }

}
