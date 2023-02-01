package org.example.chrome.tests.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private final WebDriver driver;

    public Waits() {
        this.driver = DriverSetup.getDriver();
    }

    public void wait5(WebElement we) {
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait5.until(ExpectedConditions.visibilityOf(we));
    }
}
