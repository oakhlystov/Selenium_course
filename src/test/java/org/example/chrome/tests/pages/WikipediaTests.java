package org.example.chrome.tests.pages;

import org.example.chrome.tests.helpers.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaTests {
    private final WebDriver driver;
    Links link = new Links();
    Waits w = new Waits();

    public WikipediaTests() {
        this.driver = DriverSetup.getDriver();
    }

    public void wikiTest() {
        driver.get(link.getUrlWikipedia());

        for (Languages lang : Languages.values()) {
            try {
                WebElement langBtn = driver.findElement(By.id("js-link-box-" + lang));
                w.wait5(langBtn);
                langBtn.click();
                driver.navigate().back();
            } catch (Exception e) {
                System.out.println("Error in finding language, or clicking on it, or going to the previous page. See stack trace above.");
            }
        }
        try {
            driver.findElement(By.id("searchInput")).sendKeys("Selenium (software)");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
        } catch (Exception e) {
            System.out.println("Error. Can't find input bar, or sendKeys, or submit button. See stackTrace above. " + getClass());
        }
    }
}
