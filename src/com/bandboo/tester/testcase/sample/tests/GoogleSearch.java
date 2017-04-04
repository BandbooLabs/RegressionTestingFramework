package com.bandboo.tester.testcase.sample.tests;

import com.bandboo.tester.util.Browser;
import org.junit.Test;

public class GoogleSearch {

    @Test
    public void googleSearch() throws InterruptedException {
        Browser.driver.enterText("//*[@id=\"lst-ib\"]", "\"Bandboo\"", 1);
        Browser.driver.click("//*[@id=\"_fZl\"]", 1);
        Browser.driver.click("//*[@id=\"rso\"]/div/div/div[1]/div/h3/a", 1);
    }

}
