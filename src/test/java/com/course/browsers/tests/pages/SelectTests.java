/*
 * Copyright (c) 2023.
 * @oakhlystov
 */

package com.course.browsers.tests.pages;

import com.course.browsers.tests.driversetup.DriverSingleton;
import com.course.browsers.tests.helpers.Links;
import com.course.browsers.tests.helpers.TabsController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SelectTests {
    private final WebDriver driver;
    private final String singleSpicesCssSelector = "#spices-select-single";
    private final String multySpicesCssSelector = "#spices-select-multi";
    private final String gingerText = "ginger";

    TabsController tc = new TabsController();
    Links link = new Links();
    public SelectTests() {
        this.driver = DriverSingleton.getDriver();
    }

    public void selectTests() {
        singleSelectTest();
        onMouseOverSelectTest();
    }

    private void singleSelectTest() {
        link.setExpectedUrl(link.getUrlSelects());
        tc.openNewTabWithLink(link.getUrlSelects());
        tc.changeToTheLastTab();
        tc.checkTargetTabUrl(link.getExpectedUrl());

        WebElement el = driver.findElement(By.cssSelector(singleSpicesCssSelector));
        Select select = new Select(el);
        select.selectByIndex(1);
    }

    private void onMouseOverSelectTest() {
        WebElement el = driver.findElement(By.cssSelector(multySpicesCssSelector));
        Select select = new Select(el);
        select.selectByValue(gingerText);
        Actions action = new Actions(driver);
        action.moveToElement(el).build().perform();
    }
}
