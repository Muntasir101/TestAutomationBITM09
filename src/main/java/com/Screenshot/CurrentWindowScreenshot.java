package com.Screenshot;

import com.Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class CurrentWindowScreenshot extends TestBase {
    public static void main(String[] args) throws IOException {
        launch_Chrome();
        openURL("https://google.com");
        currentWindow_Screenshot();
        smallWait();
        close_Chrome();

    }
    public static void currentWindow_Screenshot() throws IOException {
        //Screenshot Capture
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //Store Image
        FileUtils.copyFile(screenshotFile,new File("./src/main/ScreenshotFiles/CurrentWindow.png"),true);
    }
}
