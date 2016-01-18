package com.thoughtworks.bootcamp;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;


public class SampleTest {

    public WebDriver driver;
    @org.junit.Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }

    @Test
    public void firstTest(){
        driver.get("http://www.google.com");
    }


    @org.junit.After
    public void tearDown() throws Exception {
        driver.quit();
    }
}