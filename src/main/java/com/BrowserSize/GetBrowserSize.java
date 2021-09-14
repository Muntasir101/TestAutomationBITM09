package com.BrowserSize;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetBrowserSize {
    public static WebDriver driver;

    public static void main(String[] args) {
        launch_Chrome();
        getMaxSize();
        close_Chrome();
    }
    public static void launch_Chrome(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize(); //Maximize window
    }

    public static void getMaxSize(){
        Dimension maxSize=driver.manage().window().getSize(); //(1382, 744)
        System.out.println(maxSize);

        //Option 1
        int Width=driver.manage().window().getSize().getWidth();
        int Height=driver.manage().window().getSize().getHeight();

        //Option 2
       // int Width=maxSize.getWidth();
     //   int Height=maxSize.getHeight();
        System.out.println("Width: "+Width +" Height: "+Height);
    }

    public static void close_Chrome(){
        driver.close();
    }

}
