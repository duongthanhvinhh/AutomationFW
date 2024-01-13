package org.foden.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.foden.constants.FrameworkConstants;
import org.foden.utils.PropertyUtils;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport(){}
    private static ExtentReports extent;
    private static String extentreportPath;

    static {
        try {
            extentreportPath = FrameworkConstants.getExtentreportpath();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void initReports() throws Exception {
        if (Objects.isNull(extent)){
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(extentreportPath);
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Foden Report");
            spark.config().setReportName("Foden AutomationFW");
        }
    }

    public static void flushReports(){
        if (Objects.nonNull(extent)){
            extent.flush();
        }
        ExtentManager.unload();
        try {
            Desktop.getDesktop().browse(new File(extentreportPath).toURI());
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void createTest(String tcname){
        ExtentManager.setExtentTest(extent.createTest(tcname));
    }
}
