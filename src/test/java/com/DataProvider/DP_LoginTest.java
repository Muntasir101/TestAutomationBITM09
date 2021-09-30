package com.DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class DP_LoginTest {
    public static WebDriver driver;

    @BeforeClass
    @Parameters("Browser")
    public static void browser_Config(String browserName){
        if(browserName.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.opencart.com/index.php?route=account/login");
        }
        else if(browserName.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
            driver=new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.opencart.com/index.php?route=account/login");
        }
        else {
            System.out.println("Browser not found !!!!");
        }
    }
    @AfterClass
    public static void close_Browser(){
        driver.close();
    }

    @DataProvider(name="LoginData_InValid")
    public Object[][] data(){
        Object [][] data=new Object[4][2];

        //set 1
        data[0][0]="mail123@gmail.com";
        data[0][1]="1234";

        //set 2
        data[1][0]="mail1234@gmail.com";
        data[1][1]="1234";

        //set 3
        data[2][0]="mail12345@gmail.com";
        data[2][1]="1234";

        //set 4
        data[3][0]="muntasir@gmail.com";
        data[3][1]="1234";

        return data;
    }

    @Test(dataProvider="LoginData_InValid")
    public static void TC_Login_invalid(String DP_Email,String DP_Password){
        WebElement Email=driver.findElement(By.id("input-email"));
        Email.clear();
        Email.sendKeys(DP_Email);

        WebElement Password=driver.findElement(By.id("input-password"));
        Password.clear();
        Password.sendKeys(DP_Password);

        WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        LoginBtn.click();

        //Verification
        String Expected_Title="Account Login";
        String Actual_title=driver.getTitle();

        if(Expected_Title.equals(Actual_title)){
            System.out.println("Test Case Passed.");
        }
        else {
            System.out.println("Test Case failed.");
        }

    }
}
