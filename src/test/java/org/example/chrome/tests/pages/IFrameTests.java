package org.example.chrome.tests.pages;

import org.example.chrome.tests.helpers.DriverSetup;
import org.example.chrome.tests.helpers.Links;
import org.example.chrome.tests.helpers.TabsController;
import org.example.chrome.tests.helpers.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IFrameTests {
    private final WebDriver driver;
    Links link = new Links();
    TabsController ct = new TabsController();
    Waits w = new Waits();

    public IFrameTests() {
        this.driver = DriverSetup.getDriver();
    }

    public void iframeTest() {
        ct.openNewTabWithLink(link.getUrlIFrame());
        ct.changeToTheLastTab();
        String iFrameXPath = "//iframe[@id='youtube-table-cypress']";
//        String playBtnXPath = "//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"; // the second option

        try {
            WebElement iFrame = driver.findElement(By.xpath(iFrameXPath));
            w.wait5(iFrame);
            iFrame.click();
        } catch (Exception e) {
            System.out.println("Error in finding iFrame or clicking on it. See stack stace above.");
        }
//        wait5.until(ExpectedConditions.visibilityOf(iFrame)).click(); //without try-catch
//        iFrame.click(); //double click, necessary time by time (random)
        // the second option:
//        wait5.until(ExpectedConditions.visibilityOf(iFrame.findElement(By.xpath(playBtnXPath)))).click();
//        driver.switchTo().frame(iFrame).findElement(By.xpath(playBtnXPath)).click();
    }
}
