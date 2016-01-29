package com.thoughtworks.bootcamp;

import org.junit.Test;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class flipkartTest {

    public WebDriver driver;
    String URL = "http://www.flipkart.com";

    @org.junit.Before
    private void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    private void BookOutOfStockTest() {
        String bookToSearch = "//div[@class='unit size1of1']//a[contains(normalize-space(.),'The Thoughtworks Anthology')]";
        String bookStatusString = "//*[@id='products']//a[contains(normalize-space(.),'The ThoughtWorks Anthology 1st')]/parent::div/parent::div/parent::div/following-sibling::div//div[@class='fk-font-13 oos']/strong";

        driver.get(URL);
        WebElement search_box = driver.findElement(By.id("fk-top-search-box"));
        search_box.sendKeys("ThoughtWorks");

        WebElement search_button = driver.findElement((By.className("search-bar-submit")));
        search_button.click();

        WebElement filter = driver.findElement(By.xpath("//*[@id='substores']//a[contains(text(),'BOOKS')]"));
        filter.click();

        if(validateResult(bookToSearch)) {
            assertNotEquals(inStockOrNot(bookStatusString),true);
        }
    }


    @Test
    private void BookInStockTest() {
        String bookToSearch = "//div[@class='unit size1of1']//a[contains(normalize-space(.),'The Cucumber Book')]";
        String bookStatusString = "//*[@id='products']//a[contains(normalize-space(.),'The Cucumber Book')]/parent::div/parent::div/parent::div/following-sibling::div//div[@class='fk-font-13 oos']/strong";

        driver.get(URL);
        WebElement search_box = driver.findElement(By.id("fk-top-search-box"));
        search_box.click();

        search_box.sendKeys("The Cucumber Book");

        WebElement search_button = driver.findElement((By.className("search-bar-submit")));
        search_button.click();

        if(validateResult(bookToSearch)) {
            assertNotEquals(inStockOrNot(bookStatusString),false);
        }
    }


    //To validate Book is Displayed or not
    private boolean validateResult(String bookName)
    {
        WebElement bookValidate = driver.findElement((By.xpath(bookName)));
        if(bookValidate.isDisplayed()) {
            System.out.println("TEST Passed : Result found");
            return true;
        }
        else {
            System.out.println("TEST FAILED : Result not found");
            return false;
        }
    }

    //Tpo check whether book is in stock or not
    private boolean inStockOrNot(String prod) {
        WebElement status = driver.findElement(By.xpath(prod));
        if (status.getText() == "Out of Stock") {
            return false;
        } else {
            return true;
        }
    }

    @org.junit.After
    private void tearDown() throws Exception {
        driver.quit();
    }
}