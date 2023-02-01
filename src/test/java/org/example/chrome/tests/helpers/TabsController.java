package org.example.chrome.tests.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TabsController {
    private final WebDriver driver;
    public TabsController() {
        this.driver = DriverSetup.getDriver();
    }

    public void changeToTheLastTab() {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
    }

    public void openNewTabWithLink(String url) {
        ((JavascriptExecutor)driver).executeScript("window.open('" + url + "')");
    }

    public void closeAllTabs() {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab); //.close();
            DriverSetup.closeDriver();
        }
    }
}
