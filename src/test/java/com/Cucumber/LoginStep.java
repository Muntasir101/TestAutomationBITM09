package com.Cucumber;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStep {

    WebDriver driver;

    @Given("Open Browser and Navigate to Login page")
    public void open_browser_and_navigate_to_login_page() {
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/index.php?route=account/login");
    }
    @When("Enter Email and Password")
    public void enter_email_and_password() {
        WebElement Email=driver.findElement(By.id("input-email"));
        Email.clear();
        Email.sendKeys("invalid@gmail.com");

        WebElement Password=driver.findElement(By.id("input-password"));
        Password.clear();
        Password.sendKeys("assd12233");

        WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        LoginBtn.click();

    }
    @Then("Login UnSuccessful and Close Test")
    public void login_un_successful_and_close_test() {
        //Verification
        String Expected_Title="Account Login";
        String Actual_title=driver.getTitle();

        if(Expected_Title.equals(Actual_title)){
            System.out.println("Test passed");
        }
        else {
            System.out.println("Test failed");
        }
        driver.close();
    }


}
