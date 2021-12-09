package Practico12;

import org.testng.annotations.*;

public class TestNgAnotations {

    @BeforeSuite
    public void beforeSuiteTest() {
        System.out.println("---> @BeforeSuite");
    }

    @BeforeTest
    public void beforetest() {
        System.out.println("---> @BeforeTest");
    }

    @BeforeClass
    public void beforeClassTest() {
        System.out.println("---> @BeforeClassTest");
    }

    @BeforeMethod
    public void beforeMethodTest() {
        System.out.println("---> @BeforeMethod");
    }

    @Test (priority = 0, groups = {"loginTest"})
    public void test1() {
        System.out.println("***** TEST 1 *****");
    }

    @Test (priority = 1, groups = {"loginTest"})
    public void test2() {
        System.out.println("***** TEST 2 *****");
    }

    @Test (priority = 3, groups = {"registrationTest"})
    public void test3() {
        System.out.println("***** TEST 3 *****");
    }

    @AfterMethod
    public void afterMethodTest() {
        System.out.println("===> @afterMethod");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("===> @afterClass");
    }
    @AfterTest
    public void afterTest() {
        System.out.println("===> @afterTest");
    }
    @AfterSuite
    public void afterSuiteTest() {
        System.out.println("===> @afterMethod");
    }

}
