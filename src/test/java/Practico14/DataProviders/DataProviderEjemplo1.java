package Practico14.DataProviders;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEjemplo1 {

    @DataProvider(name = "personas")
    public Object[][] datosPersonales() {
        return new Object[][] {
                {"Gael", 1},
                {"Melunchis", 2}
        };
    }

    @Test (dataProvider = "personas")
    public void datosPersonalesTest(String nombre, int unaEdad) {
        System.out.println(nombre + " tiene " + unaEdad);
    }

    @Test (dataProvider = "paises", dataProviderClass = DataFactory.class)
    public void datosPaisesyCapitales(String capital, String pais) {
        System.out.println("La capital de " + pais + " es: " + capital);
    }
}
