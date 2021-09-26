package com.Screenshot;

import com.Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class WebElementScreenshot extends TestBase {
    public static void main(String[] args) {
        launch_Chrome();
        openURL("https://demo.opencart.com/");
        smallWait();
        webElement_Screenshot();
        smallWait();
        close_Chrome();
    }
    public static void webElement_Screenshot(){
        WebElement searchBox=driver.findElement(By.name("search"));
        //Screenshot Capture
        File screenshotFile = ((TakesScreenshot) searchBox).getScreenshotAs(OutputType.FILE);
        //Store Image
        try {
            FileUtils.copyFile(screenshotFile,new File("./src/main/ScreenshotFiles/Searchbox.png"),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
