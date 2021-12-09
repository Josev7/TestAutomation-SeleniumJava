package Practico10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.channels.SelectableChannel;

public class FacebookTest {
    public WebDriver getDriver(String url) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        return driver;
    }

    @Test
    public void primerTest() {
        WebDriver driver = getDriver("https://www.facebook.com");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        //Validacion ASSERT
        Assert.assertEquals(driver.getTitle(), "Facebook - Inicia sesión o regístrate", "Se esperaba otro titulo");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/", "Se esperaba otra URL");

        //Busco por texto
        driver.findElement(By.linkText("¿Olvidaste tu contraseña?")).click();
        //driver.findElement(By.partialLinkText("cuenta")).click();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        Assert.assertEquals(driver.getTitle(),"¿Olvidaste tu contraseña? | No puedo iniciar sesión | Facebook", "Se esperaba otro TITULO");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/login/identify/?ctx=recover&ars=facebook_login&from_login_screen=0", "Se esperaba otra URL");

        //Otros tipos de Asserts
        Assert.assertTrue(driver.getTitle().contains("No puedo iniciar sesión"));
        Assert.assertFalse(driver.getCurrentUrl().endsWith("facebook.com/"));
    }

    @Test
    public void registrationTest() throws InterruptedException {
        WebDriver driver = getDriver("https://www.facebook.com");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Crear cuenta nueva")).click();
        Thread.sleep(2000); //Duerme 3 segundos el hilo
        driver.findElement(By.name("firstname")).sendKeys("Gael");
        driver.findElement(By.name("lastname")).sendKeys("Ovan");
        driver.findElement(By.name("reg_email__")).sendKeys("test@test.com");
        driver.findElement(By.id("password_step_input")).sendKeys("elefantito");

        WebElement elementDay = driver.findElement(By.id("day"));
        Select daySelect = new Select(elementDay);
        daySelect.selectByIndex(5);

        WebElement elementMonth = driver.findElement(By.id("month"));
        Select monthSelect = new Select(elementMonth);
        daySelect.selectByValue("4");

        WebElement elementYear = driver.findElement(By.id("year"));
        Select yearSelect = new Select(elementYear);
        yearSelect.selectByVisibleText("1992");

        //Selecciono un género
        WebElement maleGenderRadioButton = driver.findElement(By.cssSelector("input[name='sex'][value= '2']"));
        maleGenderRadioButton.click();



    }
}
