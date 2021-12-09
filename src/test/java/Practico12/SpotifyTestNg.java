package Practico12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.security.PublicKey;
import java.util.List;

public class SpotifyTestNg {

    String url = "https://www.spotify.com/ar/signup/";
    public WebDriver driver;


    @BeforeMethod
    public void setup() {   //Va a inicar cada vez que corra un test
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }

    /*
    //EJERCICIO 1
    @Test
    public void SpotifyByCssName() throws InterruptedException {
        //WebDriver driver = getDriver(url); Ya no es necesario!

        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("[name='email']")).sendKeys("testing@test.com");
        driver.findElement(By.cssSelector("[name='confirm']")).sendKeys("testing@test.com");
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("eldada10");
        driver.findElement(By.cssSelector("[name='displayname']")).sendKeys("elkame10");
        driver.findElement(By.cssSelector("[name='day']")).sendKeys("09");

        WebElement elementoMeses = driver.findElement(By.cssSelector("[name='month']"));
        Select mesesSelect = new Select(elementoMeses);
        mesesSelect.selectByVisibleText("Agosto");

        driver.findElement(By.cssSelector("[name='year']")).sendKeys("1992");
        driver.findElement(By.cssSelector("[for='gender_option_male']")).click();
        driver.findElement(By.cssSelector("[for='marketing-opt-checkbox']")).click();
        driver.findElement(By.cssSelector("[for='third-party-checkbox']")).click();

    }

    @Test
    public void SpotifyByCssPlaceHolderTest() {

        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("[placeholder='Introduce tu correo electrónico.']")).sendKeys("testing@test.com");
        driver.findElement(By.cssSelector("[placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("testing@test.com");
        driver.findElement(By.cssSelector("[placeholder='Crea una contraseña.']")).sendKeys("elgael10");
        driver.findElement(By.cssSelector("[placeholder='Introduce un nombre de perfil.']")).sendKeys("EL14AS");
        driver.findElement(By.cssSelector("[placeholder='DD']")).sendKeys("01");

        WebElement elementoMeses = driver.findElement(By.cssSelector("[name='month']"));
        Select mesesSelect = new Select(elementoMeses);
        mesesSelect.selectByVisibleText("Agosto");

        driver.findElement(By.cssSelector("[placeholder='AAAA']")).sendKeys("2000");
        driver.findElement(By.cssSelector("[for='gender_option_male']")).click();
        driver.findElement(By.cssSelector("[for='marketing-opt-checkbox']")).click();
        driver.findElement(By.cssSelector("[for='third-party-checkbox']")).click();

        WebElement emailError = driver.findElement(By.cssSelector("[aria-label='Indicador de error']"));
        System.out.println("-----> " + emailError.getText());

        Assert.assertEquals(emailError.getText(), "Este correo electrónico ya está conectado a una cuenta. Inicia sesión.", "ERROR: Se esperaba otro mensaje!");
    }
     */

    @Test
    @Parameters({"tagName"})
    public void spotifyTagNamesTest(@Optional("a") String aTag) {
        List<WebElement> elementsList = driver.findElements(By.tagName(aTag));

        //Metodo 1
        //System.out.println("===> Se imprimiran todos los " + aTag + " del sitio");

        //Metodo 2
        if (aTag.equals("h2")) {
            System.out.println("-->Se imprimiran todos los h2s del sitio");
        } else if (aTag.equals("a")) {
            System.out.println("--->Se imprimiran todos los links del sitio");
        }
        for (WebElement element: elementsList) {
            System.out.println("===> " + element.getText());
        }
    }

    @Test
    public void emptyFieldsTest() {
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        List<WebElement> listaErrores = driver.findElements((By.xpath("//*[@aria-label='Indicador de error']")));
        Assert.assertEquals(listaErrores.size(), 9, "Se esperaban 9 errores");

        boolean encontroErrorDelMes = false;
        for (WebElement errorElement: listaErrores) {
            System.out.println("---> " + errorElement.getText());
            if (errorElement.getText().equals("Indica un día del mes válido.")) {
                encontroErrorDelMes = true;
            }

            if (errorElement.getText().equals("Debes introducir una contraseña.")) {

            }
        }

        Assert.assertEquals(encontroErrorDelMes, true);
        Assert.assertTrue(encontroErrorDelMes, "No se encontro el ERROR del mes de nacimiento");
    }

    @Test
    public void invalidEmailErrorTest() {
        driver.findElement(By.id("email")).sendKeys("test");
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        WebElement emailErrorElement = driver.findElement(By.xpath("//*[contains(text(), 'Este correo electrónico no es válido.')]"));
        Assert.assertTrue(emailErrorElement.getText().contains("Este correo electrónico no es válido."), "Se esperaba un mensaje de email NO válido");
        Assert.assertEquals(emailErrorElement.getText(),"Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com", "Se esperaba un mensaje de email no válido");
    } //HACER CON CORREO YA REGISTRADO!

    @AfterMethod //No es requerido necesariamente
    public void closeDriver() throws InterruptedException {
        Thread.sleep(2000);
        //driver.close();
    }

}
