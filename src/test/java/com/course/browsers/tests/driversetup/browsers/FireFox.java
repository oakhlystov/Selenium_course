/*
 * Copyright (c) 2023.
 * @oakhlystov
 */

package com.course.browsers.tests.driversetup.browsers;

import com.course.browsers.tests.driversetup.BrowserDriverSetup;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFox implements BrowserDriverSetup {
    @Override
    public WebDriver setStrategy() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox");
        return new FirefoxDriver(options);
    }
}
