package com.SeleniumWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitConcepts {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize(); //Maximize window

        /*
         Implicit wait: dynamic wait
         its only applicable for web Element
         Its a global wait
         */
        driver.get("https://demo.opencart.com/index.php?route=account/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // WebElement Email=driver.findElement(By.id("input-email"));
      //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // Email.sendKeys("assadasdasd");

     //   WebDriverWait wait=new WebDriverWait(driver,10,2000);
     //   wait.until(ExpectedConditions.presenceOfElementLocated(driver.findElement(By.id("input-email")).sendKeys("");

        WebElement Password=driver.findElement(By.id("input-password"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Password.clear();
        Thread.sleep(5000);  //Static wait
        Password.sendKeys("123456");

    }

}
