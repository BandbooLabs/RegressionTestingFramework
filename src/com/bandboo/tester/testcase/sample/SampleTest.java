package com.bandboo.tester.testcase.sample;

import com.bandboo.tester.testcase.sample.tests.GoogleSearch;
import com.bandboo.tester.testcase.sample.tests.Navigate;
import com.bandboo.tester.testcase.sample.tests.OpenGoogle;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SampleTest {

    @Test
    public void Test01SearchBandbooUsingGoogle() throws InterruptedException {
        OpenGoogle openGoogle = new OpenGoogle();
        openGoogle.openGoogle();

        GoogleSearch googleSearch = new GoogleSearch();
        googleSearch.googleSearch();
    }

    @Test
    public void Test02NavigateToVideo() throws InterruptedException {
        Navigate navigate = new Navigate();
        navigate.navigate();
    }
}
