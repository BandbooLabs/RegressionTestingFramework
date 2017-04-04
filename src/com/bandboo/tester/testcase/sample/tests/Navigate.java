package com.bandboo.tester.testcase.sample.tests;

import com.bandboo.tester.util.Browser;
import org.junit.Test;

public class Navigate {

    @Test
    public void navigate() throws InterruptedException {
        Browser.driver.click("/html/body/div[2]/div/div/a", 1);
    }

}
