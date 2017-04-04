package com.bandboo.tester.testcase.sample.tests;

import com.bandboo.tester.util.Browser;
import org.junit.Test;

public class OpenGoogle {

    @Test
    public void openGoogle() {
        Browser.driver.openBrowser("https://www.google.com.sg/");
    }

}
