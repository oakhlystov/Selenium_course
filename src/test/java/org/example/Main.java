package org.example;

import org.example.chrome.tests.ChromeTests;
import org.example.chrome.tests.helpers.TabsController;

public class Main {
    public static void main(String[] args) {
        ChromeTests ct = new ChromeTests();
        TabsController tc = new TabsController();
        ct.startTests();
        tc.closeAllTabs();
    }
}