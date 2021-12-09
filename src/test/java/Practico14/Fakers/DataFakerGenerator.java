package Practico14.Fakers;

import com.github.javafaker.Faker;

public class DataFakerGenerator {
    private static Faker faker = new Faker();

    public static String getFakeFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getEmailAdress() {
        return faker.internet().emailAddress();
    }

    public static String getPassword() {
        return faker.internet().password();
    }
}
