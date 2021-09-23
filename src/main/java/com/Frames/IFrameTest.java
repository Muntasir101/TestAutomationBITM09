package com.Frames;

import com.Base.TestBase;

public class IFrameTest extends TestBase {
    public static void main(String[] args) {
        launch_Chrome();
        openURL("https://the-internet.herokuapp.com/frames");
        TC_singleFrame();
        close_Chrome();
    }
    public static void TC_singleFrame(){
        clickOnElementByLinkText("iFrame");
        smallWait();
        switchToIFrame("mce_0_ifr");
        clearElementByID("tinymce");
        typeOnElementByID("tinymce","Test Automation By Selenium");
        smallWait();
    }
}
