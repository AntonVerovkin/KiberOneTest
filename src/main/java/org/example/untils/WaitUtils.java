package org.example.untils;

import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitUtils {

    private WaitUtils() {

    }

    public static void waitUntilElementISVisible(WebDriver driver, WebElement webElement){
    WebDriverWait wait = new WebDriverWait(driver, 9);
        wait.until(ExpectedConditions.visibilityOf(webElement));
}
    public static void waitUntilElementISClickable(WebDriver driver, WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, 9);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }


}

//waitUntilElementISVisible(driver, elTitle);
