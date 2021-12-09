package Practico13.Factories;

import org.testng.annotations.*;

public class TestngTest {
    private int unNumero = 0;
    public TestngTest(int unParametro) {
        this.unNumero = unParametro;
    }

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

    @Test(priority = 0, groups = {"loginTest"})
    public void test1() {
        System.out.println("***** TEST 1 *****");
        System.out.println("Se recibió el número: " + unNumero);
    }

    @Test (priority = 1, groups = {"loginTest"})
    public void test2() {
        System.out.println("***** TEST 2 *****");
        System.out.println("Se recibió el número: " + unNumero);
    }

    @Test (priority = 2, groups = {"registrationTest"})
    public void test3() {
        System.out.println("***** TEST 3 *****");
        System.out.println("Se recibió el número: " + unNumero);
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
