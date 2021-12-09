package Practico11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpotifyTest {
    String url = "https://www.spotify.com/ar/signup/";

    public WebDriver getDriver(String url) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        return driver;
    }

    //EJERCICIO 1
    @Test
    public void SpotifyByCssName() throws InterruptedException {
        WebDriver driver = getDriver(url);
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
        WebDriver driver = getDriver(url);
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

    }
}