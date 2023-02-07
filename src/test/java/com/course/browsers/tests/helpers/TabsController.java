/*
 * Copyright (c) 2023.
 * @oakhlystov
 */

package com.course.browsers.tests.helpers;

import com.course.browsers.tests.driversetup.DriverSetupTemp;
import com.course.browsers.tests.driversetup.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TabsController {
    private final WebDriver driver;

    public TabsController() {
        this.driver = DriverSingleton.getDriver();
    }

    public void changeToTheLastTab() {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
    }

    public void openNewTabWithLink(String url) {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(url);
    }

    public void closeAllTabs() {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
            DriverSetupTemp.closeDriver();
        }
    }

    public void checkTargetTabUrl(String expectedUrl, String regex) {
        if (expectedUrl.contains(driver.getCurrentUrl().split(regex)[0])) {
            System.out.println("Test for matching URLs is PASSED.\nExpected: " + expectedUrl + "\nActual: " + driver.getCurrentUrl().split(regex)[0]);
        } else {
            System.out.println("Error. Test for matching URLs is NOT PASSED.\nExpected: " + expectedUrl + "\nActual: " + driver.getCurrentUrl());
        }
    }

    public void checkTargetTabUrl(String expectedUrl) {
        if (expectedUrl.contains(driver.getCurrentUrl())) {
            System.out.println("Test for matching URLs is PASSED.\nExpected: " + expectedUrl + "\nActual: " + driver.getCurrentUrl());
        } else {
            System.out.println("Error. Test for matching URLs is NOT PASSED.\nExpected: " + expectedUrl + "\nActual: " + driver.getCurrentUrl());
        }
    }
}
