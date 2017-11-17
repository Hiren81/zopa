package com.zopa.technical.test;

import com.zopa.technical.test.driver.DriverManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks {

    private DriverManager driverManager;

    public Hooks(DriverManager diDriverManager) {
        this.driverManager = diDriverManager;
    }

    @Before
    public void setUp() {
        driverManager.openBrowser().navigateToUrl().applyImplictWait().maximizeWindow();
    }

    @After
    public void tearDown() {
        driverManager.closeBrowser();
    }
}
