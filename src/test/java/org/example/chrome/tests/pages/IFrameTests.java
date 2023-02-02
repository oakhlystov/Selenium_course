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

        try {
            WebElement iFrame = driver.findElement(By.xpath(iFrameXPath));
            w.wait5(iFrame);
            iFrame.click();
        } catch (Exception e) {
            System.out.println("Error in finding iFrame or clicking on it. See stack stace above.");
        }
    }
}
