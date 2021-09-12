package com.BrowserConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxConfig {
    public static WebDriver driver;

    public static void main(String[] args) {
//        FirefoxConfig obj=new FirefoxConfig(); //Create Object
//        obj.testMethod1();
//        testMethod2();

        launch_Firefox();
    }
    public static void launch_Firefox(){
        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
        driver=new FirefoxDriver();
    }
    private void testMethod1(){
        int a=5;
        int b=5;
        int sum=a+b;
        System.out.println("Result: "+sum);
    }
    private static void testMethod2(){
        int a=10;
        int b=5;
        int sub=a-b;
        System.out.println("Result: "+sub);
    }
}
