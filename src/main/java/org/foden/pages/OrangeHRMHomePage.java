package org.foden.pages;

import org.foden.driver.DriverManager;
import org.foden.enums.WaitStrategy;
import org.foden.reports.ExtentLogger;
import org.foden.reports.ExtentManager;
import org.foden.reports.ExtentReport;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class OrangeHRMHomePage extends BasePage{

    private final By drpdwnProfile = By.className("oxd-userdropdown-tab");
    private final By linkLogout = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickUserProfile(){
//        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdown_profile)); --old fashioned way
//        wait.until(d->d.findElement(drpdwnProfile).isDisplayed());
        click(drpdwnProfile, WaitStrategy.CLICKABLE,"User profile dropdown");
        return this;
    }
    public OrangeHRMLoginPage clickLogout(){
        click(linkLogout,WaitStrategy.CLICKABLE,"Logout button");
        return new OrangeHRMLoginPage();
    }
}
