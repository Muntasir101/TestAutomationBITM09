package com.MultipleWindow;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

public class BrowserWindowHandle extends TestBase {
    public static void main(String[] args) {
        launch_Chrome();
        openURL("https://opensource-demo.orangehrmlive.com/");

        //Scroll down
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,300)");

        //Open Twitter
        WebElement Twitter=driver.findElement(By.cssSelector("#social-icons > a:nth-child(3) > img"));
        Twitter.click();

        Set<String> handles=driver.getWindowHandles();

        Iterator<String> it=handles.iterator();
        String parentWindowID=it.next();
        System.out.println("Parent Window ID: "+parentWindowID);

        String childWindowID=it.next();
        System.out.println("Child Window ID: "+childWindowID);

        //Switching to child
        driver.switchTo().window(childWindowID);
        mediumWait();
        getPageTitle();  //Twitter

       //Switching to parent
        driver.switchTo().window(parentWindowID);
        mediumWait();
        getPageTitle();   //OrangeHRM

        driver.navigate().to("https://google.com");
        mediumWait();
        getPageTitle();  // Google

        //switching to child
        driver.switchTo().window(childWindowID);
        mediumWait();
        driver.navigate().to("https://bbc.com");
        getPageTitle();   //BBC

        quit_Chrome(); //close all window

    }
}
