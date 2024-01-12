package org.foden.pages;

import org.foden.constants.FrameworkConstants;
import org.foden.driver.DriverManager;
import org.foden.enums.WaitStrategy;
import org.foden.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy){
        ExplicitWaitFactory.performExplicitWait(waitStrategy,by).click();
    }

    protected void sendKeys(By by,String value,WaitStrategy waitStrategy){
        ExplicitWaitFactory.performExplicitWait(waitStrategy,by).sendKeys(value);
    }

    public String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }

}
