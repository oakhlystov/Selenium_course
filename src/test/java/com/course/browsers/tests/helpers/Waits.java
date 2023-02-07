/*
 * Copyright (c) 2023.
 * @oakhlystov
 */

package com.course.browsers.tests.helpers;

import com.course.browsers.tests.driversetup.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private final WebDriver driver;

    public Waits() {
        this.driver = DriverSingleton.getDriver();
    }

    public void wait5(WebElement we) {
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait5.until(ExpectedConditions.visibilityOf(we));
    }
}
