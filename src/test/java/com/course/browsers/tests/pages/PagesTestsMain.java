/*
 * Copyright (c) 2023.
 * @oakhlystov
 */

package com.course.browsers.tests.pages;

public class PagesTestsMain {
    WikipediaTests wt = new WikipediaTests();
    AlertsTests at = new AlertsTests();
    IFrameTests it = new IFrameTests();
    SelectTests st = new SelectTests();

    public PagesTestsMain() {
        startTests();
    }

    public void startTests() {
        wt.wikiTest();
        at.alertsTest();
        it.iframeTest();
        st.selectTests();
    }
}
