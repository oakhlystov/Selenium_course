/*
 * Copyright (c) 2023.
 * @oakhlystov
 */

package com.course;

import com.course.browsers.tests.driversetup.DriverSingleton;
import com.course.browsers.tests.helpers.Browsers;
import com.course.browsers.tests.pages.PagesTestsMain;

public class Main {
    public static void main(String[] args) {
        DriverSingleton.getInstance(String.valueOf(Browsers.CHROME));
        new PagesTestsMain();
//        ptm.startTests();
    }
}