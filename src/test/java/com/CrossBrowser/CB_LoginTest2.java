package com.CrossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class CB_LoginTest2 {
    public static WebDriver driver;

    @BeforeClass
    @Parameters("Browser")
    public static void browser_Config(String browserName){
        if(browserName.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.opencart.com/index.php?route=account/login");
        }
        else if(browserName.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
            driver=new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.opencart.com/index.php?route=account/login");
        }
        else {
            System.out.println("Browser not found !!!!");
        }
    }
    @AfterClass
    public static void close_Browser(){
        driver.close();
    }

    @Test(description = "Email and pass invalid")
    public static void TC_Login_001(){

        WebElement Email=driver.findElement(By.id("input-email"));
        Email.clear();
        Email.sendKeys("test@test.com");

        WebElement Password=driver.findElement(By.id("input-password"));
        Password.clear();
        Password.sendKeys("123456789");

        //Step 5
        WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        LoginBtn.click();

        //Verification
        String Expected_Title="Account Login";
        String Actual_title=driver.getTitle();

        if(Expected_Title.equals(Actual_title)){
            System.out.println("Test Case Passed.");
        }
        else {
            System.out.println("Test Case failed.");
        }

        System.out.println("TC_Login_002 Executed");
    }

    @Test(description = "Email valid but pass invalid")
    public static void TC_Login_002(){

        WebElement Email=driver.findElement(By.id("input-email"));
        Email.clear();
        Email.sendKeys("user101@gmail.com");

        WebElement Password=driver.findElement(By.id("input-password"));
        Password.clear();
        Password.sendKeys("123456789");

        WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        LoginBtn.click();

        //Verification
        String Expected_Title="Account Login";
        String Actual_title=driver.getTitle();

        if(Expected_Title.equals(Actual_title)){
            System.out.println("Test Case Passed.");
        }
        else {
            System.out.println("Test Case failed.");
        }

        System.out.println("TC_Login_003 Executed");
    }

    @Test(enabled = false,description = "Email invalid but pass valid")
    public static void TC_Login_003(){

        WebElement Email=driver.findElement(By.id("input-email"));
        Email.clear();
        Email.sendKeys("test@test.com");

        WebElement Password=driver.findElement(By.id("input-password"));
        Password.clear();
        Password.sendKeys("123456");

        WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        LoginBtn.click();

        //Verification
        String Expected_Title="Account Login";
        String Actual_title=driver.getTitle();

        if(Expected_Title.equals(Actual_title)){
            System.out.println("Test Case Passed.");
        }
        else {
            System.out.println("Test Case failed.");
        }

        System.out.println("TC_Login_004 Executed");
    }
}
