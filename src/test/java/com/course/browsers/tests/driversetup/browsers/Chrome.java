/*
 * Copyright (c) 2023.
 * @oakhlystov
 */

package com.course.browsers.tests.driversetup.browsers;

import com.course.browsers.tests.driversetup.BrowserDriverSetup;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements BrowserDriverSetup {
    @Override
    public WebDriver setStrategy() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }
}
