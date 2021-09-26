package com.Screenshot;

import com.Base.TestBase;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class FullPageScreenshot extends TestBase {
    public static void main(String[] args) {
        launch_Chrome();
        openURL("https://demo.opencart.com/");
        smallWait();
        entirePage_screenshot();
        smallWait();
        close_Chrome();
    }
    public static void entirePage_screenshot(){
        Screenshot entirePage=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        try {
            ImageIO.write(entirePage.getImage(),"PNG",new File("./src/main/ScreenshotFiles/FullPage.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
