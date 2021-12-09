package Practico14.DataProviders;

import org.testng.annotations.DataProvider;

public class DataFactory {
    @DataProvider (name = "paises")
    public Object[][] datosPaises() {
        return new Object[][] {
                {"Santiago", "Chile"},
                {"Buenos Aires", "Argentina"},
                {"Montevideo", "Uruguay"}
        };
    }

    @DataProvider (name = "datosSpotify")
    public Object[][] datosCuentas() {
        return new Object[][] {
                {"test@test.com", "test@test.com", "elkame10", "DUPLICATE_EMAIL_ERROR"},
                {"testqa@test.com", "abc@gmail.com", "ffffff", "DIFFERENT_EMAIL_ERROR"},
                {"Montevideo", "Uruguay", "Hola", "INVALID_EMAIL_ERROR"}
        };
    }
}
