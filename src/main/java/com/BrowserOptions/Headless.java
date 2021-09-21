package com.BrowserOptions;

import com.Opencart.LoginTest;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;

public class Headless extends LoginTest {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
        FirefoxOptions obj=new FirefoxOptions();
        obj.setHeadless(true);
        driver=new FirefoxDriver(obj);

        open_LoginPage();
        TC_Login_001();
        TC_Login_002();
        TC_Login_003();
        TC_Login_004();

        driver.quit();
    }
}


/*
Account Successfully Login.Test Case Passed.
TC_Login_001 Executed
Test Case Passed.
TC_Login_002 Executed
Test Case Passed.
TC_Login_003 Executed
Test Case Passed.
TC_Login_004 Executed

 */
