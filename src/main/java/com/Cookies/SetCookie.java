package com.Cookies;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

public class SetCookie {
    public static WebDriver driver;

    public static void main(String[] args) {
        launch_Firefox();
        openURL();
        addCookie();
        getAllCookie();
        close_Firefox();

    }
    public static void launch_Firefox(){
        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
        driver=new FirefoxDriver();
    }
    public static void openURL(){
        driver.get("https://apple.com");
    }

    public static void addCookie(){
        Cookie cok=new Cookie("Muntasir","Test Cookie set by Automated Script");
        driver.manage().addCookie(cok);
    }
    public static void getAllCookie(){
        Set allCookies=driver.manage().getCookies();
        System.out.println(allCookies+"/n");
        System.out.println("Number of Cookies present: "+allCookies.size());
    }
    public static void close_Firefox() {
        driver.close();
    }
}
