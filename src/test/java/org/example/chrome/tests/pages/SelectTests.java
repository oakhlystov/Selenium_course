package org.example.chrome.tests.pages;

import org.example.chrome.tests.helpers.DriverSetup;
import org.example.chrome.tests.helpers.Links;
import org.example.chrome.tests.helpers.TabsController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SelectTests {
    private final WebDriver driver;

    TabsController tc = new TabsController();
    Links link = new Links();
    public SelectTests() {
        this.driver = DriverSetup.getDriver();
    }

    public void selectTests() {
        singleSelectTest();
        onMouseOverSelectTest();
    }

    private void singleSelectTest() {
        tc.openNewTabWithLink(link.getUrlSelects());
        tc.changeToTheLastTab();

        WebElement el = driver.findElement(By.cssSelector("#spices-select-single"));
        Select select = new Select(el);
        select.selectByIndex(1);
    }

    private void onMouseOverSelectTest() {
        WebElement el = driver.findElement(By.cssSelector("#spices-select-multi"));
        Select select = new Select(el);
        select.selectByValue("ginger");
        Actions action = new Actions(driver);
        action.moveToElement(el).build().perform();
    }
}
