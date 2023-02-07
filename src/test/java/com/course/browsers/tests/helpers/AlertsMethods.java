/*
 * Copyright (c) 2023.
 * @oakhlystov
 */

package com.course.browsers.tests.helpers;

import com.course.browsers.tests.driversetup.DriverSingleton;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsMethods {
    private final WebDriver driver;
    private final String alertBtnXPath1 = "//*[@id=\"content\"]/div/ul/li[";
    private final String alertBtnXPath2 = "]/button";
    private final String alertBtnXPath3 = "//div[@class='example']//li[";
    private final String alertBtnXPath4 = "]//button";

    public AlertsMethods() {
        this.driver = DriverSingleton.getDriver();
    }
    public void findAndClickAlertButton(int i) {
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait5.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(alertBtnXPath1 + i + alertBtnXPath2))));
            driver.findElement(By.xpath(alertBtnXPath3 + i + alertBtnXPath4)).click();
            wait5.until(ExpectedConditions.alertIsPresent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendKeysAndAcceptAlert(String str, Alert alert) {
        alert.sendKeys(str);
        alert.accept();
    }
}
