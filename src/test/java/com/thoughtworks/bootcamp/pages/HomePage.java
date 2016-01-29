package com.thoughtworks.bootcamp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void searchBook(String searchTerm){
        driver.findElement(By.id("fk-top-search-box")).sendKeys(searchTerm);
        driver.findElement(By.cssSelector(".search-bar-submit.fk-font-13.fk-font-bold")).click();
    }

}
