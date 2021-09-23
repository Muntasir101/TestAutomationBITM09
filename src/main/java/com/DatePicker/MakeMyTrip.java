package com.DatePicker;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MakeMyTrip extends TestBase {
    public static void main(String[] args) {
        launch_Chrome();
        MakeMyTrip obj=new MakeMyTrip();
        obj.trips();
    }
    public void selectDate(String month,String select_day){
        List<WebElement> elements=driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div[1]/div[3]/label/p[1]/span[1]"));

        for (int i=0;i<elements.size();i++){
            System.out.println(elements.get(i).getText());
            //Selecting Month
            if(elements.get(i).getText().equals(month)){
                //Selecting date
                List<WebElement> days= driver.findElements(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[4]/div[6]/div/p"));
                for(WebElement d:days){
                    System.out.println(d.getText());
                    if(d.getText().equals(select_day)){
                        d.click();
                        mediumWait();
                        return;
                    }
                }
            }
        }
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div[1]/div[3]/label/span")).click();
        selectDate(month,select_day);
    }
    public void trips(){
        openURL("https://www.makemytrip.com/");
        mediumWait();
        driver.findElement(By.xpath("//*[@id=\"departure\"]")).click();

        Date d=new Date();
        SimpleDateFormat formatter=new SimpleDateFormat("dd-MMMM-yyyy");
        String date=formatter.format(d);
        String splitter[]=date.split("-");
        String month=splitter[1];
        String day=splitter[0];
        System.out.println(month);
        System.out.println(day);
        selectDate(month,day);
    }
}
