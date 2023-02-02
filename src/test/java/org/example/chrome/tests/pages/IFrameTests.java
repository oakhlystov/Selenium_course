package org.example.chrome.tests.pages;

import org.example.chrome.tests.helpers.DriverSetup;
import org.example.chrome.tests.helpers.Links;
import org.example.chrome.tests.helpers.TabsController;
import org.example.chrome.tests.helpers.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IFrameTests {
    private final WebDriver driver;
    Links link = new Links();
    TabsController tc = new TabsController();
    Waits w = new Waits();

    public IFrameTests() {
        this.driver = DriverSetup.getDriver();
    }

    public void iframeTest() {
        tc.openNewTabWithLink(link.getUrlIFrame());
        tc.changeToTheLastTab();
        String iFrameXPath = "//iframe[@id='youtube-table-cypress']";

        try {
            w.wait5(driver.findElement(By.xpath(iFrameXPath)));
            driver.findElement(By.xpath(iFrameXPath)).click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in finding iFrame or clicking on it. See stack stace above.\n" + e);
        }
    }
}
