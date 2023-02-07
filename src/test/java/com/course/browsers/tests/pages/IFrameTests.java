/*
 * Copyright (c) 2023.
 * @oakhlystov
 */

package com.course.browsers.tests.pages;

import com.course.browsers.tests.driversetup.DriverSingleton;
import com.course.browsers.tests.helpers.Links;
import com.course.browsers.tests.helpers.TabsController;
import com.course.browsers.tests.helpers.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IFrameTests {
    private final WebDriver driver;
    private final String iFrameXPath = "//iframe[@id='youtube-table-cypress']";
    Links link = new Links();
    TabsController tc = new TabsController();
    Waits w = new Waits();

    public IFrameTests() {
        this.driver = DriverSingleton.getDriver();
    }

    public void iframeTest() {
        link.setExpectedUrl(link.getUrlIFrame());
        tc.openNewTabWithLink(link.getUrlIFrame());
        tc.changeToTheLastTab();
        tc.checkTargetTabUrl(link.getExpectedUrl());

        try {
            w.wait5(driver.findElement(By.xpath(iFrameXPath)));
            driver.findElement(By.xpath(iFrameXPath)).click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in finding iFrame or clicking on it. See stack stace above.\n" + e);
        }
    }
}
