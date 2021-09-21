package com.Opencart;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Logout extends TestBase {
    public static void main(String[] args) {

    }
    public static void TC_logout(){
        //Logout
        WebElement Logout=driver.findElement(By.linkText("Logout"));
        Logout.click();

    }
}
