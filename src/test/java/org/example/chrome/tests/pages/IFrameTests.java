package org.example.chrome.tests.pages;

import org.example.chrome.tests.helpers.DriverSetup;
import org.example.chrome.tests.helpers.Links;
import org.example.chrome.tests.helpers.TabsController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IFrameTests {
    private final WebDriver driver;
    Links link = new Links();
    TabsController ct = new TabsController();

    public IFrameTests() {
        this.driver = DriverSetup.getDriver();
    }

    public void iframeTest() {
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
        ct.openNewTabWithLink(link.getUrlIFrame());
        ct.changeToTheLastTab();
        String iFrameXPath = "//iframe[@id='youtube-table-cypress']";
//        String playBtnXPath = "//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']";

        WebElement iFrame = driver.findElement(By.xpath(iFrameXPath));
        wait5.until(ExpectedConditions.visibilityOf(iFrame)).click();
        iFrame.click(); //double click, necessary time by time (random)
//        wait5.until(ExpectedConditions.visibilityOf(iFrame.findElement(By.xpath(playBtnXPath)))).click();
//        driver.switchTo().frame(iFrame).findElement(By.xpath(playBtnXPath)).click();
    }
}
