`package com.thoughtworks.bootcamp;

import com.thoughtworks.bootcamp.pages.HomePage;
import com.thoughtworks.bootcamp.pages.SearchResults;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;


public class BookAvailability {

    public WebDriver driver;
    HomePage hp;
    SearchResults sr;

    @org.junit.Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        hp = new HomePage(driver);
        sr = new SearchResults(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://www.flipkart.com");
    }

    @Test
    public void outOfStockTest(){
        hp.searchBook("ThoughtWorks");
        sr.selectBookFilter();
        assertFalse("The ThoughtWorks Anthology 1st Book not Found...!!!",sr.checkStockStatus("The ThoughtWorks Anthology 1st"));

    }

    @Test
    public void availableForPurchaseTest(){
        hp.searchBook("The Cucumber Book");
        assertTrue("The Cucumber Book Found...!!!",sr.checkStockStatus("The Cucumber Book"));
    }

    @org.junit.After
    public void tearDown() throws Exception {
        driver.quit();
    }
}