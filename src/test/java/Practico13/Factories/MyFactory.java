package Practico13.Factories;

import org.testng.annotations.Factory;

public class MyFactory {

    @Factory
    public Object[] factoryMethod() {
        return new Object[] {
                new TestngTest(1),
                new TestngTest(2),
                new TestngTest(3)
        };
    }
}
