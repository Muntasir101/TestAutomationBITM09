package com.BrowserOptions;

import com.Base.TestBase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSL extends TestBase {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        ChromeOptions opt=new ChromeOptions();
        //Accept certificate
        opt.setAcceptInsecureCerts(true);
        driver=new ChromeDriver(opt);

        openURL("https://cacert.com/");


    }
}
