package com.Alerts;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AlertTest extends TestBase {
    public static void main(String[] args) {
        launch_Chrome();
        openURL("https://the-internet.herokuapp.com/javascript_alerts");
        normalAlert();
        confirmAlert();
        promptAlert();
        close_Chrome();
    }
    public static void normalAlert(){
        WebElement JSNormalAlert=driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(1) > button"));
        JSNormalAlert.click();
        mediumWait();
        String AlertText=driver.switchTo().alert().getText();
        System.out.println("Normal Alert Text: "+AlertText);
        driver.switchTo().alert().accept(); //click on OK
    }
    public static void confirmAlert(){
        WebElement JSConfirmAlert=driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(2) > button"));
        JSConfirmAlert.click();
        mediumWait();
        String AlertText=driver.switchTo().alert().getText();
        System.out.println("Confirm Alert Text: "+AlertText);
       // driver.switchTo().alert().accept(); //click on OK
        driver.switchTo().alert().dismiss();   // click on Cancel
    }
    public static void promptAlert(){
        WebElement JSPromptAlert=driver.findElement(By.cssSelector("#content > div > ul > li:nth-child(3) > button"));
        JSPromptAlert.click();
        mediumWait();
        String AlertText=driver.switchTo().alert().getText();
        System.out.println("Prompt Alert Text: "+AlertText);
        driver.switchTo().alert().sendKeys("Test Automation");
        mediumWait();
        driver.switchTo().alert().accept(); //click on OK
        mediumWait();
    }



}
