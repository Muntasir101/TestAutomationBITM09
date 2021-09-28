package com.Annonations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
1. @BeforeClass execute only one time before all @Test execute
2. @AfterClass execute only one time after all @Test execute

output:
Browser launch Successfully
This is from testCase_001
This is from testCase_002
Browser Close Successfully
 */

public class TestNGClassAnnotations {

    @Test
    public static void testCase_001(){
        System.out.println("This is from testCase_001");
    }
    @Test
    public static void testCase_002(){
        System.out.println("This is from testCase_002");
    }
    @BeforeClass
    public static void browserLaunch(){
        System.out.println("Browser launch Successfully");
    }
    @AfterClass
    public static void browserClose(){
        System.out.println("Browser Close Successfully");
    }

}
