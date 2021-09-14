package com.BrowserSize;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetBrowserSize {
    public static WebDriver driver;

    public static void main(String[] args) {
        launch_Chrome();
        setSizeTab();
        setSizeMobile();
        close_Chrome();
    }
    public static void launch_Chrome(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize(); //Maximize window
    }

    public static void setSizeTab(){
        driver.manage().window().setSize(new Dimension(768,500));
    }
    public static void setSizeMobile(){
        driver.manage().window().setSize(new Dimension(375,500));
    }
    public static void close_Chrome(){
        driver.close();
    }
}
