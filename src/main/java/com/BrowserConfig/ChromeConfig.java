package com.BrowserConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChromeConfig {
    public static WebDriver driver;

    public static void main(String[] args) {
       launch_Chrome();
    }
    public static void launch_Chrome(){
        System.setProperty("webdriver.chrome.driver","");
        driver=new ChromeDriver();
    }

}
