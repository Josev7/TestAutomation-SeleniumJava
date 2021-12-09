package Practico13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SpotifyTesting {

    public WebDriver driver;



    public void setup() {   //Va a inicar cada vez que corra un test
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(Constants.SPOTIFY_SINGUP_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }



    @Test
    public void SpotifyByCssPlaceHolderTest() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs("Registrarte - Spotify"));

        //Camion C1 = new Camion("rojo);
        SpotifyFillingForm spotifyFillingForm = new SpotifyFillingForm(driver);
        spotifyFillingForm.completeForm(Constants.DUPLICATE_EMAIL_VALUE, Constants.DUPLICATE_EMAIL_VALUE, Constants.PASSWORD_VALUE, Constants.PROFILE_VALUE);

        WebElement emailError = driver.findElement(By.cssSelector("[aria-label='Indicador de error']"));

        Assert.assertEquals(emailError.getText(), Constants.DUPLICATE_EMAIL_ERROR, "ERROR: Se esperaba otro mensaje!");
    }


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
            if (errorElement.getText().equals(Constants.EMPTY_DAY_ERROR)) {
                encontroErrorDelMes = true;
            }

            /*if (errorElement.getText().equals(Constants.EMPTY_PASSWORD_ERROR)) {

            }*/
        }

        Assert.assertEquals(encontroErrorDelMes, true);
        Assert.assertTrue(encontroErrorDelMes, "No se encontro el ERROR del mes de nacimiento");
    }

    @Test
    public void invalidEmailErrorTest() {
        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys("test");
        driver.findElement(By.cssSelector("[placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys(Constants.DUPLICATE_EMAIL_VALUE);
        driver.findElement(By.cssSelector("[placeholder='Crea una contraseña.']")).sendKeys(Constants.PASSWORD_VALUE);
        driver.findElement(By.cssSelector("[placeholder='Introduce un nombre de perfil.']")).sendKeys(Constants.PROFILE_VALUE);
        driver.findElement(By.cssSelector("[placeholder='DD']")).sendKeys("01");

        WebElement elementoMeses = driver.findElement(By.cssSelector("[name='month']"));
        Select mesesSelect = new Select(elementoMeses);
        mesesSelect.selectByVisibleText("Agosto");

        driver.findElement(By.cssSelector("[placeholder='AAAA']")).sendKeys("2000");
        driver.findElement(By.cssSelector("[for='gender_option_male']")).click();
        driver.findElement(By.cssSelector("[for='marketing-opt-checkbox']")).click();
        driver.findElement(By.cssSelector("[for='third-party-checkbox']")).click();
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        WebElement emailErrorElement = driver.findElement(By.xpath("//*[contains(text(), 'Este correo electrónico no es válido.')]"));
        Assert.assertTrue(emailErrorElement.getText().contains("Este correo electrónico no es válido."), "Se esperaba un mensaje de email NO válido");
        Assert.assertEquals(emailErrorElement.getText(),"Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com", "Se esperaba un mensaje de email no válido");
    } //HACER CON CORREO YA REGISTRADO!

    @Test
    public void emptyPasswordErrorTest() {
        /*driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys("testselenium@spotify.com");
        driver.findElement(By.cssSelector("[placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("testselenium@spotify.com");
        driver.findElement(By.cssSelector("[placeholder='Crea una contraseña.']")).sendKeys("");
        driver.findElement(By.cssSelector("[placeholder='Introduce un nombre de perfil.']")).sendKeys(Constants.PROFILE_VALUE);
        driver.findElement(By.cssSelector("[placeholder='DD']")).sendKeys("01");    */
        SpotifyFillingForm spotifyFillingForm = new SpotifyFillingForm(driver);

        spotifyFillingForm.completeForm("testselenium@spotify.com", "testselenium@spotify.com", "", Constants.PROFILE_VALUE);

        WebElement elementoMeses = driver.findElement(By.cssSelector("[name='month']"));
        Select mesesSelect = new Select(elementoMeses);
        mesesSelect.selectByVisibleText("Agosto");

        driver.findElement(By.cssSelector("[placeholder='AAAA']")).sendKeys("2000");
        driver.findElement(By.cssSelector("[for='gender_option_male']")).click();
        driver.findElement(By.cssSelector("[for='marketing-opt-checkbox']")).click();
        driver.findElement(By.cssSelector("[for='third-party-checkbox']")).click();
        driver.findElement(By.xpath("//*[@type='submit']")).click();


    }

    @Test
    public void confirmationEmailErrorTest() {
        SpotifyFillingForm spotifyFillingForm = new SpotifyFillingForm(driver);
        spotifyFillingForm.completeForm("testselenium@spotify.com", "elkame@spotify.com", Constants.PASSWORD_VALUE, Constants.PROFILE_VALUE);



        WebElement elementoMeses = driver.findElement(By.cssSelector("[name='month']"));
        Select mesesSelect = new Select(elementoMeses);
        mesesSelect.selectByVisibleText("Agosto");

        driver.findElement(By.cssSelector("[placeholder='AAAA']")).sendKeys("2000");
        driver.findElement(By.cssSelector("[for='gender_option_male']")).click();
        driver.findElement(By.cssSelector("[for='marketing-opt-checkbox']")).click();
        driver.findElement(By.cssSelector("[for='third-party-checkbox']")).click();
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        WebElement emailError = driver.findElement(By.cssSelector("[aria-label='Indicador de error']"));
        System.out.println("-----> " + emailError.getText());

        Assert.assertEquals(emailError.getText(), "Las direcciones de correo electrónico no coinciden.", "Se esperaba otro mensaje!");


    }

    @Test
    public void profileErrorTest() {
        SpotifyFillingForm spotifyFillingForm = new SpotifyFillingForm(driver);
        spotifyFillingForm.completeForm("testselenium@spotify.com", "testselenium@spotify.com", Constants.PASSWORD_VALUE, "");



        WebElement elementoMeses = driver.findElement(By.cssSelector("[name='month']"));
        Select mesesSelect = new Select(elementoMeses);
        mesesSelect.selectByVisibleText("Agosto");

        driver.findElement(By.cssSelector("[placeholder='AAAA']")).sendKeys("2004");
        driver.findElement(By.cssSelector("[for='gender_option_male']")).click();
        driver.findElement(By.cssSelector("[for='marketing-opt-checkbox']")).click();
        driver.findElement(By.cssSelector("[for='third-party-checkbox']")).click();
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        WebElement profileError = driver.findElement(By.cssSelector("[aria-label='Indicador de error']"));
        System.out.println("-----> " + profileError.getText());

        Assert.assertEquals(profileError.getText(), "Introduce un nombre para tu perfil.", "Se esperaba otro mensaje!");


    }
    @AfterMethod //No es requerido necesariamente
    public void closeDriver() throws InterruptedException {
        Thread.sleep(2000);
        //driver.close();
    }

}
