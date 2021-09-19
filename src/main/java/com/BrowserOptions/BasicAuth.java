package com.BrowserOptions;

import com.Base.TestBase;

public class BasicAuth extends TestBase {
    public static void main(String[] args) {
        launch_Chrome();
        openURL("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
}
