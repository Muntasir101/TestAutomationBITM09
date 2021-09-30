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

public class CB_LoginTest {
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

    @Test(description = "Email and Password are valid")
    public static void TC_Login_001() throws IOException {

        WebElement Email=driver.findElement(By.id("input-email"));
        Email.clear();
        Email.sendKeys("user101@gmail.com");

        WebElement Password=driver.findElement(By.id("input-password"));
        Password.clear();
        Password.sendKeys("123456");

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

}
