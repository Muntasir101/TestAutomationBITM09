package com.Base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/*
1. Browser launch
2. Open URL
3. Browser Close
4. Wait
 */
public class TestBase {
    public static WebDriver driver;

    public static void launch_Chrome(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize(); //Maximize window
    }
    public static void launch_Firefox(){
        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
    }

    public static void openURL(String URL)
    {
        if(URL==null){
            return;
        }
        if(URL.isEmpty()){
            return;
        }
        driver.get(URL);
    }

    public static void close_Firefox(){
        driver.close();
        //Close only one Active Tab
    }

    public static void quit_Firefox(){
        driver.quit();
        //Close only one Active Tab
    }

    public static void close_Chrome(){
        driver.close();
        //Close only one Active Tab
    }

    public static void quit_Chrome(){
        driver.quit();
        //Close only one Active Tab
    }

    public static void smallWait(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void mediumWait(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void longWait(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void customWait(int milliSeconds){
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void implicitWait(int Seconds)
    {
        driver.manage().timeouts().implicitlyWait(Seconds, TimeUnit.SECONDS);
    }

    public static void getPageTitle(){
        String Title=driver.getTitle();
        System.out.println("Title:" +Title);
    }
    public static String getPageURL(){
        return driver.getCurrentUrl();
    }

    //Common Methods
    //Click
    public static void clickOnElementByID(String locator){
        driver.findElement(By.id(locator)).click();
    }
    public static void clickOnElementByNAME(String locator){
        driver.findElement(By.name(locator)).click();
    }
    public static void clickOnElementByCSS(String locator){
        driver.findElement(By.cssSelector(locator)).click();
    }
    public static void clickOnElementByXPATH(String locator){
        driver.findElement(By.xpath(locator)).click();
    }
    public static void clickOnElementByLinkText(String locator){
        driver.findElement(By.linkText(locator)).click();
    }

    //Type (SendKeys)
    public static void typeOnElementByID(String locator,String value){
        driver.findElement(By.id(locator)).sendKeys(value);
    }
    public static void typeOnElementByNAME(String locator,String value){
        driver.findElement(By.name(locator)).sendKeys(value);
    }
    public static void typeOnElementByCSS(String locator,String value){
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }
    public static void typeOnElementByXPATH(String locator,String value){
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }
    //Clear
    public static void clearElementByID(String locator){
        driver.findElement(By.id(locator)).clear();
    }
    public static void clearElementByNAME(String locator){
        driver.findElement(By.name(locator)).clear();
    }
    public static void clearElementByCSS(String locator){
        driver.findElement(By.cssSelector(locator)).clear();
    }
    public static void clearElementByXPATH(String locator){
        driver.findElement(By.xpath(locator)).clear();
    }

    //Frame
    public static void switchToIFrame(String locator){
        driver.switchTo().frame(locator);
    }

    //Screenshots
    public static void currentWindow_Screenshot(String ImageName,String Format) {
        //Screenshot Capture
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //Store Image
        try {
            FileUtils.copyFile(screenshotFile,new File("./src/main/ScreenshotFiles/"+ImageName+Format),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void webElement_Screenshot(String ImageName,String Format) {
        WebElement searchBox = driver.findElement(By.name("search"));
        //Screenshot Capture
        File screenshotFile = ((TakesScreenshot) searchBox).getScreenshotAs(OutputType.FILE);
        //Store Image
        try {
            FileUtils.copyFile(screenshotFile, new File("./src/main/ScreenshotFiles/"+ImageName+Format), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void entirePage_Screenshot(String ImageName){
        Screenshot entirePage=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        try {
            ImageIO.write(entirePage.getImage(),"PNG",new File("./src/main/ScreenshotFiles/"+ImageName+"png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

