package com.thoughtworks.bootcamp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.internal.Streams;

public class SearchResults {

    WebDriver driver;

    public SearchResults(WebDriver driver){
        this.driver = driver;
    }

    public boolean checkStockStatus(String bookName)
    {
        String xPath = "//div[@class='unit size1of1']//a[contains(normalize-space(.),'"+bookName+"')]//ancestor::div[@class='unit size1of1']//div[contains(@class,'lu-status')]//strong";
        WebElement bookStatus = driver.findElement(By.xpath(xPath));
        System.out.println(bookStatus.getText());
        if(bookStatus.getText().equals("Out of Stock")) {
            return false;
        }
        else {
            return true; }
    }

    public void selectBookFilter(){
        driver.findElement(By.xpath("//a[@sid='bks']")).click();
    }
}
