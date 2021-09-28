package com.Annonations;

import org.testng.annotations.*;

/*
1. @BeforeMethod will execute before every @Test
2. @AfterMethod will execute after every @Test

output:
Browser launch Successfully
This is from testCase_001
Browser Close Successfully
Browser launch Successfully
This is from testCase_002
Browser Close Successfully
 */

public class TestNGMethodAnnotations {
    @Test
    public static void testCase_001(){
        System.out.println("This is from testCase_001");
    }
    @Test
    public static void testCase_002(){
        System.out.println("This is from testCase_002");
    }
    @BeforeMethod
    public static void browserLaunch(){
        System.out.println("Browser launch Successfully");
    }
    @AfterMethod
    public static void browserClose(){
        System.out.println("Browser Close Successfully");
    }

}
