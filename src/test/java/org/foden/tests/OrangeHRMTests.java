package org.foden.tests;

import org.assertj.core.api.Assertions;
import org.foden.pages.OrangeHRMLoginPage;
import org.foden.reports.ExtentReport;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;

public class OrangeHRMTests extends BaseTest{
    private OrangeHRMTests(){}

    @Test(dataProvider="LoginTestDataProvider")
    public void loginLogoutTest(String username, String password){
        String title = new OrangeHRMLoginPage()
                .enterUserName(username).enterPassword(password).clickLogin()
                .clickUserProfile().clickLogout().getPageTitle();
        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }

    @DataProvider(name = "LoginTestDataProvider",parallel = true)
    public Object[][] getData() {
        return new Object[][]{
                {"Admin","admin123"},
                {"Admin123","admin1234"}
        };
    }
}
