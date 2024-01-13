package org.foden.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.foden.driver.DriverManager;
import org.foden.enums.ConfigProperties;
import org.foden.utils.PropertyUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ExtentLogger {

    private ExtentLogger(){}
    public static void pass(String message){
        ExtentManager.getExtentTest().pass(message);
    }
    public static void fail(String message){
        ExtentManager.getExtentTest().fail(message);
    }
    public static void skip(String message){
        ExtentManager.getExtentTest().skip(message);
    }
    public static void pass(String message, boolean isScreeshotNeeded) throws Exception {
        if (PropertyUtils.get(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
                && isScreeshotNeeded){
            ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        } else pass(message);
    }
    public static void fail(String message, boolean isScreeshotNeeded) throws Exception {
        if (PropertyUtils.get(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
                && isScreeshotNeeded){
            ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        } else fail(message);
    }
    public static void skip(String message, boolean isScreeshotNeeded) throws Exception {
        if (PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
                && isScreeshotNeeded){
            ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        } else skip(message);
    }
    public static String getBase64Image(){
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
