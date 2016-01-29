package com.thoughtworks.bootcamp;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OutOfStockTest {

    public WebDriver driver;
    @org.junit.Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }

    @Test
    public void firstTest(){


        driver.get("http://www.flipkart.com");
        driver.findElement(By.id("fk-top-search-box")).sendKeys("");
        driver.findElement(By.cssSelector(".search-bar-submit")).click();
        WebElement element = driver.findElement(By.cssSelector(".parent .store"));
        element.findElement(By.cssSelector(".parent.active")).click();

        WebElement book = driver.findElement(By.xpath(".//*[@id='products']/div[2]/div[1]/div/div/div[1]/div/a[2]"));
        System.out.println(book.getText());


        // //div[@class='unit size1of1']//a[contains(normalize=space(.), 'The ThoughtWorks Anthology')]

    }


    @org.junit.After
    public void tearDown() throws Exception {
        driver.quit();
    }
}