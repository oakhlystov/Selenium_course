/*
 * Copyright (c) 2023.
 * @oakhlystov
 */

package com.course.browsers.tests.helpers;

public class Links {
    private final String urlIFrame = "https://kitchen.applitools.com/ingredients/iframe";
    private final String urlAlerts = "https://the-internet.herokuapp.com/javascript_alerts";
    private final String urlWikipedia = "https://www.wikipedia.org/";
    private final String urlSelects = "https://kitchen.applitools.com/ingredients/select";
    private String previousUrl;
    private String expectedUrl;

    public String getExpectedUrl() {
        return expectedUrl;
    }

    public void setExpectedUrl(String expectedUrl) {
        this.expectedUrl = expectedUrl;
    }

    public String getPreviousUrl() {
        if (previousUrl == null) {
            return previousUrl = "";
        }
        return previousUrl;
    }

    public void setPreviousUrl(String previousUrl) {
        this.previousUrl = previousUrl;
    }

    public void setPrevAndExpectedUrls(String previousUrl, String expectedUrl) {
        this.previousUrl = previousUrl;
        this.expectedUrl = expectedUrl;
    }

    public final String getUrlIFrame() {
        return urlIFrame;
    }

    public final String getUrlAlters() {
        return urlAlerts;
    }

    public final String getUrlWikipedia() {
        return urlWikipedia;
    }

    public final String getUrlSelects() {
        return urlSelects;
    }
}
