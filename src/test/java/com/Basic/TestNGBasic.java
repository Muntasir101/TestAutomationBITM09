package com.Basic;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestNGBasic {

    @Test(priority = -1)
    public static void testCase_003(){
        System.out.println("This is from testCase_003");
    }
    @Test(enabled = true,priority = -2,description = "Invalid Test case")
    public static void testCase_001(){
        System.out.println("This is from testCase_001");
    }

    @Test(description = "valid Test Case",priority = 0)
    public static void testCase_002(){
        System.out.println("This is from testCase_002");
    }
    @Test(description = "Test Case Skipped")
    public static void testCase_004(){
        throw new SkipException("Custom Exception");
    }
    @Test(description = "Test Case Failed")
    public static void testCase_005(){
        Assert.fail("Custom Failed");
    }

}
