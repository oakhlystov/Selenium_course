package org.example.chrome.tests.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

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
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(url);
    }

    public void closeAllTabs() {
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab); //.close();
            DriverSetup.closeDriver();
        }
    }
}
