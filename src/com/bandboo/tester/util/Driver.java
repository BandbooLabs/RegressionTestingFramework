package com.bandboo.tester.util;

import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class Driver {
    private WebDriver driver;
    public void openBrowser(String url){
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
        driver.navigate().to(url);
    }

    public void enterText(String xPath, String input, int pauseTime) throws InterruptedException {
        try {
            ready(xPath, pauseTime);
            WebElement element = null;
            element = driver.findElement(By.xpath(xPath));
            element.sendKeys(input);
        } catch (ElementNotVisibleException e1) {
            Thread.sleep(1000);
            enterText(xPath, input, 1);
        }
    }

    public void click(String xPath,int pauseTime) throws InterruptedException {
        try {
            ready(xPath, pauseTime);
            WebElement element = null;
            element = driver.findElement(By.xpath(xPath));
            element.click();
        } catch (ElementNotVisibleException e1){
            Thread.sleep(1000);
            click(xPath,pauseTime);
        } catch (WebDriverException e2){
            Thread.sleep(1000);
            click(xPath,pauseTime);
        }
    }

    public void checkValue(String xPath,String expectedValue, int pauseTime) throws AssertionError, InterruptedException {
        try {
            ready(xPath, pauseTime);
            WebElement element = driver.findElement(By.xpath(xPath));
            String actualValue = element.getText();
            Assert.assertEquals(expectedValue, actualValue);
        } catch (ComparisonFailure e1) {
            Thread.sleep(1000);
            checkValue(xPath, expectedValue, pauseTime);
        }
    }

    public String getValue(String xPath, int pauseTime) throws InterruptedException {
        ready(xPath,pauseTime);
        WebElement element = driver.findElement(By.xpath(xPath));
        String actualValue = element.getText();
        return actualValue;
    }

    public void hover(String xPath, int pauseTime) throws InterruptedException {
        ready(xPath,pauseTime);
        moveToElement(xPath,pauseTime);
        Thread.sleep(pauseTime);
    }

    public void moveToElement(String xPath,int pauseTime) throws InterruptedException {
        ready(xPath,pauseTime);
        WebElement element = driver.findElement(By.xpath(xPath));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public void dropDown(String xPath, String input, int pauseTime) throws InterruptedException {
        ready(xPath,pauseTime);
        WebElement element;
        moveToElement(xPath,pauseTime);
        Select select = new Select(driver.findElement(By.xpath(xPath)));
        element = driver.findElement(By.xpath(xPath));
        element.click();
        select.selectByVisibleText(input);
    }

    public String getUrl(int pauseTime) throws InterruptedException {
        Thread.sleep(pauseTime);
        return driver.getCurrentUrl();
    }

    public void fileInput(String xPath, String input, int pauseTime) throws InterruptedException {
        ready(xPath,pauseTime);
        moveToElement(xPath,pauseTime);
        driver.findElement(By.xpath(xPath)).sendKeys(input);
    }

    public void closeBrowser(){
        driver.close();
    }

    public void ready(String xPath,int sleepAfterFoundinMs) throws InterruptedException {
        int count = 0;
        while(true){
            WebElement element = null;
            try{
                element= driver.findElement(By.xpath(xPath)) ;
            }catch (Exception e){
            }
            if(element != null){
                System.out.println("xPath:"+xPath+" found");
                Thread.sleep(sleepAfterFoundinMs);
                break;
            }
            if (count > 500000000) {
                break;
            }
            try {
                Thread.sleep(1);
                count++;
            } catch (InterruptedException e) {
            }
        }
    }

    public void nagivateTo(String url) {
        driver.get(url);
    }
}
