/*
 * Copyright (c) 2023.
 * @oakhlystov
 */

package com.course.browsers.tests.driversetup;

import com.course.browsers.tests.driversetup.browsers.Chrome;
import com.course.browsers.tests.driversetup.browsers.FireFox;

public class DriverImplementer {
    public static BrowserDriverSetup chooseBrowser(String strategy) {
        switch (strategy) {
            case "Chrome" -> {
                return new Chrome();
            }
            case "FireFox" -> {
                return new FireFox();
            }
            default -> {
                return null;
            }
        }
    }
}
