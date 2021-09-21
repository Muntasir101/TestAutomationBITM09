package com.Opencart;

import com.Base.TestBase;

import java.io.IOException;

public class EndToEndTest extends TestBase {
    public static void main(String[] args) throws IOException {
        launch_Chrome();

        RegistrationTest.open_RegistrationPage();
        RegistrationTest.TC_Registration_01();
        Logout.TC_logout();

        LoginETE.open_LoginPage();
        LoginETE.TC_Login_ETN_001();
        Logout.TC_logout();

        close_Chrome();
    }
}
