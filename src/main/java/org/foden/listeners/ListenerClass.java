package org.foden.listeners;

import org.foden.reports.ExtentLogger;
import org.foden.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        try {
            ExtentReport.initReports();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " : PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            ExtentLogger.fail(result.getMethod().getMethodName() + " : FAILED",true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " : SKIPPED");
    }
}
