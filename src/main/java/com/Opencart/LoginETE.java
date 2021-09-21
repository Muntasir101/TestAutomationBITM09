package com.Opencart;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginETE extends TestBase {
    public static void main(String[] args) throws IOException {
        launch_Chrome();
        open_LoginPage();
        TC_Login_ETN_001();
        close_Chrome();
    }

    public static void open_LoginPage() {
        driver.get("https://demo.opencart.com/index.php?route=account/login");
    }

    public static void TC_Login_ETN_001() throws IOException {

        FileInputStream fis = new FileInputStream("./src/main/resources/LoginData.properties");
        Properties prop = new Properties();
        prop.load(fis);

        /*
        Step 3, 4 and 5
         */

        //Step 3
        WebElement Email = driver.findElement(By.id("input-email"));
        Email.clear();
        Email.sendKeys(prop.getProperty("Email"));

        //Step 4
        WebElement Password = driver.findElement(By.id("input-password"));
        Password.clear();
        Password.sendKeys(prop.getProperty("Password"));

        //Step 5
        WebElement LoginBtn = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        LoginBtn.click();

        //Verification by Title
        String Expected_Title = "My Account";
        String Actual_title = driver.getTitle();


        if (Expected_Title.equals(Actual_title)) {
            System.out.println("Account Successfully Login.Test Case Passed.");
        } else {
            System.out.println("Test Case failed.");
        }

    }
}