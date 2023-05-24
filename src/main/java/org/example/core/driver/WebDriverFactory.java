package org.example.core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.core.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {
    private static final String BROWSER = System.getProperty("browser");
    private static WebDriver driver;




    public static WebDriver getDriver(Browsers browsers){
       return switch (browsers) {
           case CHROME -> getChromeDriver();
           case SAFARI -> getSafariDriver();
           case FIREFOX -> getFirefoxDriver();
           case OPERA -> getOperaDriver();
           default -> throw new IllegalCallerException("Wrong browser was chosen");
       };

   }

    public static WebDriver getChromeDriver(){
        if( driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static WebDriver getSafariDriver(){
        if( driver == null) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        return driver;
    }

    public static WebDriver getOperaDriver(){
        if( driver == null) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }
        return driver;
    }

    public static WebDriver getFirefoxDriver(){
        if( driver == null) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }
}
