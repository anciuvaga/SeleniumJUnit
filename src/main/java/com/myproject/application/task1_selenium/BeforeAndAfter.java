package com.myproject.application.task1_selenium;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BeforeAndAfter {
    @Before
    public void before() {
        Driver.driverStart();
    }


    @After
    public void after() throws Exception {
        Thread.sleep(5000);
        Driver.getDriver().quit();
    }
}
