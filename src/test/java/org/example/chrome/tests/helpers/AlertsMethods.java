package org.example.chrome.tests.helpers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsMethods {
    private final WebDriver driver;
    public AlertsMethods() {
        this.driver = DriverSetup.getDriver();
    }
    public void findAndClickAlertButton(int i) {
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait5.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[" + i + "]/button"))));
            driver.findElement(By.xpath("//div[@class='example']//li[" + i + "]//button")).click();
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
