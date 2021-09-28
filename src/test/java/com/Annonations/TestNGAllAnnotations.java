package com.Annonations;

import org.testng.annotations.*;

public class TestNGAllAnnotations {
    @Test
    public static void testCase_001(){
        System.out.println("This is from testCase_001");
    }
    @Test
    public static void testCase_002(){
        System.out.println("This is from testCase_002");
    }
    @BeforeTest
    public static void before_Test(){
        System.out.println("Print from @BeforeTest");
    }
    @AfterTest
    public static void after_Test(){
        System.out.println("Print from @AfterTest");
    }
    @BeforeClass
    public static void before_Class(){
        System.out.println("Print from @BeforeClass");
    }
    @AfterClass
    public static void after_Class(){
        System.out.println("Print from @AfterClass");
    }
    @BeforeMethod
    public static void before_Method(){
        System.out.println("Print from @BeforeMethod");
    }
    @AfterMethod
    public static void after_Method(){
        System.out.println("Print from @AfterMethod");
    }

    @BeforeSuite
    public static void before_Suite(){
        System.out.println("Print from @BeforeSuite");
    }
    @AfterSuite
    public static void after_Suite(){
        System.out.println("Print from @AfterSuite");
    }



}
