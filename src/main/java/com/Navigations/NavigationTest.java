package com.Navigations;

import com.Base.TestBase;

public class NavigationTest extends TestBase {
    public static void main(String[] args) {
        launch_Chrome();
        openURL("https://google.com");
        smallWait(); //3 seconds
        navigateTo("https://demo.opencart.com/");
        longWait();  // 10 seconds
        navigateBack();
        mediumWait();  //5 seconds
        navigateForward();

    }
    public static void navigateTo(String URL){
        driver.navigate().to(URL);
    }
    public static void navigateBack(){
        driver.navigate().back();
    }
    public static void navigateForward(){
        driver.navigate().forward();
    }
}
