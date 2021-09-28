package com.Annonations;

import org.testng.annotations.*;

public class TestNGSuiteAnnotations {
    @Test
    public static void testCase_001(){
        System.out.println("This is from testCase_001");
    }
    @Test
    public static void testCase_002(){
        System.out.println("This is from testCase_002");
    }
    @BeforeSuite
    public static void browserLaunch(){
        System.out.println("Browser launch Successfully");
    }
    @AfterSuite
    public static void browserClose(){
        System.out.println("Browser Close Successfully");
    }

}
