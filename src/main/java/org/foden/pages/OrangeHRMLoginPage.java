package org.foden.pages;

import org.foden.driver.DriverManager;
import org.foden.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class OrangeHRMLoginPage extends BasePage{

    private final By txtboxUsername = By.xpath("//input[@name='username']");
    private final By txtboxPassword = By.xpath("//input[@type='password']");
    private final By btnLogin = By.xpath("//button[@type='submit']");

    public OrangeHRMLoginPage enterUserName(String userName){
        sendKeys(txtboxUsername,userName,WaitStrategy.VISIBLE);
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password){
        sendKeys(txtboxPassword,password,WaitStrategy.NONE);
        return this;
    }

    public OrangeHRMHomePage clickLogin(){
        click(btnLogin, WaitStrategy.CLICKABLE);
        return new OrangeHRMHomePage();
    }

}
