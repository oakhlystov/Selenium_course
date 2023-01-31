package org.example.chrome.tests;

import org.example.chrome.tests.pages.AlertsTests;
import org.example.chrome.tests.pages.IFrameTests;
import org.example.chrome.tests.pages.WikipediaTests;

public class ChromeTests {
    WikipediaTests wt = new WikipediaTests();
    AlertsTests at = new AlertsTests();
    IFrameTests it = new IFrameTests();

    public void startTests() {
        wt.wikiTest();
        at.alertsTest();
        it.iframeTest();
    }
}
