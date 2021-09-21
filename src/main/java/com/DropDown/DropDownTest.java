package com.DropDown;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownTest extends TestBase {
    public static void main(String[] args) {
        launch_Chrome();
        openURL("https://the-internet.herokuapp.com/dropdown");
        selectionByIndex();
        selectionByValue();
        selectionByVisibleText();
        close_Chrome();
    }
    public static void selectionByIndex(){
        WebElement dropdown=driver.findElement(By.id("dropdown"));
        Select obj=new Select(dropdown);
        obj.selectByIndex(1);
        mediumWait();
    }
    public static void selectionByValue(){
        WebElement dropdown=driver.findElement(By.id("dropdown"));
        Select obj=new Select(dropdown);
        obj.selectByValue("2");
        mediumWait();
    }
    public static void selectionByVisibleText(){
        WebElement dropdown=driver.findElement(By.id("dropdown"));
        Select obj=new Select(dropdown);
        obj.selectByVisibleText("Option 1");
        mediumWait();
    }
}
