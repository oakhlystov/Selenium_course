/*
 * Copyright (c) 2023.
 * @oakhlystov
 */

package com.course.browsers.tests.pages;

import com.course.browsers.tests.driversetup.DriverSingleton;
import com.course.browsers.tests.helpers.TabsController;
import com.course.browsers.tests.helpers.Languages;
import com.course.browsers.tests.helpers.Links;
import com.course.browsers.tests.helpers.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaTests {
    private final WebDriver driver;
    private final String jsLinkBoxCss = "js-link-box-";
    private final String searchInputText = "searchInput";
    private final String senKeysText = "Selenium (software)";
    private final String submitBtnXPath = "//button[@type='submit']";
    private final String hrefText = "href";
    private final String footerCss = "#footer-places-cookiestatement";
    private final String wikiRegEx = "/wiki";

    Links link = new Links();
    Waits w = new Waits();
    TabsController tc = new TabsController();

    public WikipediaTests() {
        this.driver = DriverSingleton.getDriver();
    }

    public void wikiTest() {
        link.setExpectedUrl(link.getUrlWikipedia());
        driver.get(link.getUrlWikipedia());
        tc.checkTargetTabUrl(link.getExpectedUrl(), wikiRegEx);

        for (Languages lang : Languages.values()) {
            try {
                w.wait5(driver.findElement(By.id(jsLinkBoxCss + lang)));
                WebElement langBtn = driver.findElement(By.id(jsLinkBoxCss + lang));

                link.setPrevAndExpectedUrls(driver.getCurrentUrl(), langBtn.getAttribute(hrefText));

                langBtn.click();
                w.wait5(driver.findElement(By.cssSelector(footerCss)));
                tc.checkTargetTabUrl(link.getExpectedUrl(), wikiRegEx);

                link.setPrevAndExpectedUrls(driver.getCurrentUrl(), link.getUrlWikipedia());

                driver.navigate().back();
                w.wait5(driver.findElement(By.id(jsLinkBoxCss + lang)));
                tc.checkTargetTabUrl(link.getExpectedUrl(), wikiRegEx);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error in finding language, or clicking on it, or going to the previous page. See stack trace above.");
            }
        }

        try {
            driver.findElement(By.id(searchInputText)).sendKeys(senKeysText);
            driver.findElement(By.xpath(submitBtnXPath)).click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error. Can't find input bar, or sendKeys, or submit button. See stackTrace above. " + getClass());
        }
    }
}
