package org.example.chrome.tests.pages;

import org.example.chrome.tests.helpers.AlertsMethods;
import org.example.chrome.tests.helpers.DriverSetup;
import org.example.chrome.tests.helpers.Links;
import org.example.chrome.tests.helpers.TabsController;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertsTests {
    private final WebDriver driver;
    private final String sendKeysPhrase = "Hello Java";
    Links link = new Links();
    AlertsMethods am = new AlertsMethods();
    TabsController tc = new TabsController();

    public AlertsTests() {
        this.driver = DriverSetup.getDriver();
    }

    public void alertsTest() {
        link.setExpectedUrl(link.getUrlAlters());
        tc.openNewTabWithLink(link.getUrlAlters());
        tc.changeToTheLastTab();
        tc.checkTargetTabUrl(driver.getCurrentUrl());

        for (int i = 1; i <=3; i++) {
            am.findAndClickAlertButton(i);
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            switch (i) {
                case 1 -> alert.accept();
                case 2 -> alert.dismiss();
                case 3 -> am.sendKeysAndAcceptAlert(sendKeysPhrase, alert);
                default -> System.out.println("Error in switch/case.");
            }
        }
    }
}
