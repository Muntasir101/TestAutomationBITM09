package com.Opencart;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class RegistrationTest extends TestBase {

    public static void main(String[] args) throws IOException {
        launch_Chrome();
        open_RegistrationPage();
        TC_Registration_01();
        close_Chrome();
    }
    public static void open_RegistrationPage(){
        driver.get("https://demo.opencart.com/index.php?route=account/register");
    }

    public static void TC_Registration_01() throws IOException {
        FileInputStream fis=new FileInputStream("./src/main/resources/LoginData.properties");
        Properties prop=new Properties();
        prop.load(fis);


        WebElement First_Name=driver.findElement(By.id("input-firstname"));
        First_Name.clear();
        First_Name.sendKeys("Taufique");

        WebElement Last_Name=driver.findElement(By.id("input-lastname"));
        Last_Name.clear();
        Last_Name.sendKeys("Hasan");

        WebElement Email=driver.findElement(By.id("input-email"));
        Email.clear();
        Email.sendKeys(prop.getProperty("Email"));

        WebElement Telephone=driver.findElement(By.id("input-telephone"));
        Telephone.clear();
        Telephone.sendKeys("01700000000");

        WebElement Password=driver.findElement(By.id("input-password"));
        Password.clear();
        Password.sendKeys(prop.getProperty("Password"));

        WebElement Password_Confirm=driver.findElement(By.id("input-confirm"));
        Password_Confirm.clear();
        Password_Confirm.sendKeys(prop.getProperty("Password"));

        WebElement Subscribe=driver.findElement(By.cssSelector("#content > form > fieldset:nth-child(3) > div > div > label:nth-child(1) > input[type=radio]"));
        Subscribe.click();

        WebElement Privacy=driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)"));
        Privacy.click();

        WebElement Continue=driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));
        Continue.click();

    }
}
