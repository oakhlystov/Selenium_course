/*
 * Copyright (c) 2023.
 * @oakhlystov
 */

package com.course.browsers.tests.driversetup;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static DriverSingleton instance = null;
    private static WebDriver driver;

    public DriverSingleton(String driver) {
        initiate(driver);
    }

    public WebDriver initiate(String browser) {
        BrowserDriverSetup driverImplementer = DriverImplementer.chooseBrowser(browser);
        driver = driverImplementer.setStrategy();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static DriverSingleton getInstance(String driver) {
        if (instance == null) {
            instance = new DriverSingleton(driver);
        }
        return instance;
    }

    public static void closeInstance() {
        instance = null;
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
