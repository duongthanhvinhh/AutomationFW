package org.foden.tests;

import static org.assertj.core.api.Assertions.*;
import org.foden.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public final class HomePageTests extends BaseTest{

    private HomePageTests(){}

    /**
     * Validate whether the title is containing Google Search or google search
     * Validate whether the title is not null and the length of title is greater than 15 and less than 100
     * Check for the links in the pages --> Testing mini bytes - YouTube
     * Number of links displayed is exactly 10 or 15
     */

    @Test
    public void homeTest(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes - YouTube", Keys.ENTER);
        String title = DriverManager.getDriver().getTitle();

        assertThat(title)
                .as("Object is actually null").isNotNull()
                .as("It does not contains expected text").containsIgnoringCase("tìm trên google")
                .matches("\\w.*" + "Google")
                .hasSizeBetween(15,100);

        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//h3"));
        assertThat(elements)
                .hasSizeGreaterThan(0)
                .extracting(WebElement::getText)
                .contains("Testing Mini Bytes");
    }
}
