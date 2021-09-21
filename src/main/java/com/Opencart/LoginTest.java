package com.Opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoginTest {

    public static WebDriver driver;

    public static void main(String[] args) throws IOException {
        launch_Chrome();
        open_LoginPage();
        TC_Login_001();
        TC_Login_002();
        TC_Login_003();
        TC_Login_004();
        close_Chrome();
    }
    //Step 1
    public static void launch_Chrome(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize(); //Maximize window
    }

    //Step 2
    public static void open_LoginPage(){
        driver.get("https://demo.opencart.com/index.php?route=account/login");
    }

    //Email and pass valid
    public static void TC_Login_001() throws IOException {

        /*
        Step 3, 4 and 5
         */

        //Step 3
        WebElement Email=driver.findElement(By.id("input-email"));
        Email.clear();
        Email.sendKeys("Email");

        //Step 4
        WebElement Password=driver.findElement(By.id("input-password"));
        Password.clear();
        Password.sendKeys("Password");

        //Step 5
        WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        LoginBtn.click();

        //Verification by Title
        String Expected_Title="My Account";
        String Actual_title=driver.getTitle();


        if(Expected_Title.equals(Actual_title)){
            System.out.println("Account Successfully Login.Test Case Passed.");
        }
        else {
            System.out.println("Test Case failed.");
        }

        //Logout
        WebElement Logout=driver.findElement(By.linkText("Logout"));
        Logout.click();

        WebElement LoginPage=driver.findElement(By.linkText("Login"));
        LoginPage.click();

        System.out.println("TC_Login_001 Executed");
    }

    //Email and pass invalid
    public static void TC_Login_002(){
        /*
        Step 3, 4 and 5
         */
        //Step 3
        WebElement Email=driver.findElement(By.id("input-email"));
        Email.clear();
        Email.sendKeys("test@test.com");

        //Step 4
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

    //Email valid but pass invalid
    public static void TC_Login_003(){
        /*
        Step 3, 4 and 5
         */
        //Step 3
        WebElement Email=driver.findElement(By.id("input-email"));
        Email.clear();
        Email.sendKeys("user101@gmail.com");

        //Step 4
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

        System.out.println("TC_Login_003 Executed");
    }

    //Email invalid but pass valid
    public static void TC_Login_004(){
         /*
        Step 3, 4 and 5
         */
        //Step 3
        WebElement Email=driver.findElement(By.id("input-email"));
        Email.clear();
        Email.sendKeys("test@test.com");

        //Step 4
        WebElement Password=driver.findElement(By.id("input-password"));
        Password.clear();
        Password.sendKeys("123456");

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

        System.out.println("TC_Login_004 Executed");
    }




    //step 6
    public static void close_Chrome(){
        driver.close();
    }
}
