package com.Annonations;

import org.testng.annotations.*;

/*
1. @BeforeTest execute only one time before all @Test execute
2. @AfterTest execute only one time after all @Test execute

output:
Browser launch Successfully
This is from testCase_001
This is from testCase_002
Browser Close Successfully
 */

public class TestNGTestAnnotations {
    @Test
    public static void testCase_001(){
        System.out.println("This is from testCase_001");
    }
    @Test
    public static void testCase_002(){
        System.out.println("This is from testCase_002");
    }
    @BeforeTest
    public static void browserLaunch(){
        System.out.println("Browser launch Successfully");
    }
    @AfterTest
    public static void browserClose(){
        System.out.println("Browser Close Successfully");
    }

}
