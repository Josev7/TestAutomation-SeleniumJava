package Practico16.test;

import Practico16.pages.BasePage;
import Practico16.pages.LandingPage;
import Practico16.pages.LoginPage;
import Practico16.pages.SignupPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SpotifyTest extends BaseTest {

    //
    /*
    String SPOTIFY_URL = "https://www.spotify.com";
    public WebDriver driver;
    public LandingPage landingPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(SPOTIFY_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        landingPage = new LandingPage(driver);
    }
    */


    //EJERCICIO 1
    @Test
    public void registrationFromLoginPage() throws InterruptedException {
       // driver.findElement(By.xpath("//*[@data-ga-action='log-in']")).click();
        //REEMPLAZO POR:
        LoginPage loginPage = landingPage.clickOnLoginBtn();

        //REEMPLAZO driver POR loginPage
        Assert.assertEquals(loginPage.getPageTitle(), "Iniciar sesión - Spotify", "ERROR: Se esperaba otro título");
        Assert.assertTrue(loginPage.getPageUrl().contains("login"), "ERROR: Se esperaba la palabra 'login' en la url");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        //driver.findElement(By.id("sign-up-link")).click();
        //REEMPLAZO POR:
        SignupPage signupPage = loginPage.clickOnRegistrationBtn();
        Assert.assertTrue(signupPage.getPageUrl().contains("signup"), "ERROR: Se esperaba la palabra 'signup' en la url");

        /*
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
        */

        //A LO ANTERIOR lo reemplazo por:

        signupPage.fillRegistrationFields();

    }

    /*
    @Test
    public void SpotifyByCssPlaceHolderTest() {

        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("[placeholder='Introduce tu correo electrónico.']")).sendKeys("testing@test.com");
        driver.findElement(By.cssSelector("[placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("testing@test.com");
        driver.findElement(By.cssSelector("[placeholder='Crea una contraseña.']")).sendKeys("eldada10");
        driver.findElement(By.cssSelector("[placeholder='Introduce un nombre de perfil.']")).sendKeys("elkame10");
        driver.findElement(By.cssSelector("[placeholder='DD']")).sendKeys("09");

        WebElement elementoMeses = driver.findElement(By.cssSelector("[name='month']"));
        Select mesesSelect = new Select(elementoMeses);
        mesesSelect.selectByVisibleText("Agosto");

        driver.findElement(By.cssSelector("[placeholder='AAAA']")).sendKeys("1992");
        driver.findElement(By.cssSelector("[for='gender_option_male']")).click();
        driver.findElement(By.cssSelector("[for='marketing-opt-checkbox']")).click();
        driver.findElement(By.cssSelector("[for='third-party-checkbox']")).click();

        WebElement emailError = driver.findElement(By.cssSelector("[aria-label='Indicador de error']"));
        System.out.println("-----> " + emailError.getText());

        Assert.assertEquals(emailError.getText(), "Este correo electrónico ya está conectado a una cuenta. Inicia sesión.", "ERROR: Se esperaba otro mensaje!");

    } */
}
