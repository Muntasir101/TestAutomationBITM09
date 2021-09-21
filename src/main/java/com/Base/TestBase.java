package com.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

/*
1. Browser launch
2. Open URL
3. Browser Close
4. Wait
 */
public class TestBase {
    public static WebDriver driver;

    public static void launch_Chrome(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize(); //Maximize window
    }
    public static void launch_Firefox(){
        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
    }

    public static void openURL(String URL)
    {
        if(URL==null){
            return;
        }
        if(URL.isEmpty()){
            return;
        }
        driver.get(URL);
    }

    public static void close_Firefox(){
        driver.close();
        //Close only one Active Tab
    }

    public static void quit_Firefox(){
        driver.quit();
        //Close only one Active Tab
    }

    public static void close_Chrome(){
        driver.close();
        //Close only one Active Tab
    }

    public static void quit_Chrome(){
        driver.quit();
        //Close only one Active Tab
    }

    public static void smallWait(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void mediumWait(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void longWait(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void customWait(int milliSeconds){
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void implicitWait(int Seconds)
    {
        driver.manage().timeouts().implicitlyWait(Seconds, TimeUnit.SECONDS);
    }

    public static void getPageTitle(){
        String Title=driver.getTitle();
        System.out.println("Title:" +Title);
    }
    public static String getPageURL(){
        return driver.getCurrentUrl();
    }
}

