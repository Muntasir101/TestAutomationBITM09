package com.BrowserConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxConfig {
    public static WebDriver driver;

    public static void main(String[] args) {
        launch_Firefox();
       // close_Firefox();
        quit_Firefox();
    }
    public static void launch_Firefox(){
        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
    }
    public static void close_Firefox(){
        driver.close();  //Close only one Active Tab
    }
    public static void quit_Firefox(){
        driver.quit();  //Close full Browser
    }
}
