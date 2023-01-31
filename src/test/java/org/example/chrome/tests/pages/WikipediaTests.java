package org.example.chrome.tests.pages;

import org.example.chrome.tests.helpers.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaTests {
    private final WebDriver driver;
    Links link = new Links();

    public WikipediaTests() {
        this.driver = DriverSetup.getDriver();
    }

    public void wikiTest() {
        driver.get(link.getUrlWikipedia());

        for (Languages lang : Languages.values()) {
            WebElement toClick = driver.findElement(By.id("js-link-box-" + lang));
            toClick.click();
            driver.navigate().back();
        }
        driver.findElement(By.id("searchInput")).sendKeys("Selenium (software)");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
