package com.thoughtworks.bootcamp;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class BootCampHW {

    public WebDriver driver;

    @org.junit.Before
    private void setUp() throws Exception
    {
        driver = new FirefoxDriver();
        driver.get("http://www.flipkart.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    private void outOfStockTest() throws InterruptedException
    {

        //driver.findElement(By.id("fk-top-search-box")).clear();
        driver.findElement(By.id("fk-top-search-box")).sendKeys("ThoughtWorks");
        driver.findElement(By.cssSelector("input[class='search-bar-submit fk-font-13 fk-font-bold']")).click();
        driver.findElements(By.partialLinkText("BOOKS")).get(1).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='The ThoughtWorks Anthology 1st Edition']")).isDisplayed());
        driver.findElement(By.xpath("//img[@alt='The ThoughtWorks Anthology 1st Edition']/..")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Out of Stock')]")).isDisplayed());
    }

    @Test
    private void inStockTest() throws InterruptedException
    {
        driver.findElement(By.id("fk-top-search-box")).sendKeys("The Cucumber Book");
        driver.findElement(By.cssSelector("input[class='search-bar-submit fk-font-13 fk-font-bold']")).click();
        WebElement cucumberBookLink = driver.findElement(By.xpath("//img[@alt='The Cucumber Book (English)']/.."));
        Assert.assertTrue(cucumberBookLink.isDisplayed());
        cucumberBookLink.click();
        WebElement addToCart= driver.findElement(By.xpath("//input[@value='Add to Cart']"));
        Assert.assertTrue(addToCart.isEnabled());

    }


    @org.junit.After
    private void tearDown() throws Exception {
        driver.quit();
    }
}