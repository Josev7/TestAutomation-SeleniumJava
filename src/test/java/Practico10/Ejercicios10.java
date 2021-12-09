package Practico10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Ejercicios10 {
    public WebDriver getDriver(String url) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        return driver;
    }

    //EJERCICIO 1
    @Test
    public void forgotAccountTest() throws InterruptedException {
        WebDriver driver = getDriver("https://www.facebook.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());


        //Validación titulo Facebook
        Assert.assertEquals(driver.getTitle(), "Facebook - Inicia sesión o regístrate", "ERROR: Se esperaba otro titulo");
        //Click en texto
        driver.findElement(By.linkText("¿Olvidaste tu contraseña?")).click();
        Thread.sleep(2000);
        //Nueva validación titulo
        Assert.assertEquals(driver.getTitle(), "¿Olvidaste tu contraseña? | No puedo iniciar sesión | Facebook");
        //Validacion de URL distinta de “https://www.facebook.com/”
        Assert.assertFalse(driver.getCurrentUrl().endsWith("https://www.facebook.com/"));
    }


    //EJERCICIO 2
    @Test
    public void forgotAccountPartialLinkTest() {
        WebDriver driver = getDriver("https://www.facebook.com/");
        driver.findElement(By.partialLinkText("¿Olvidaste")).click();
        Assert.assertEquals(driver.getTitle(), "¿Olvidaste tu contraseña? | No puedo iniciar sesión | Facebook", "ERROR: No es la URL esperada");
    }

    //EJERCICIO 3
    @Test
    public void customSalesforceLink() throws InterruptedException {
        WebDriver driver = getDriver("https://login.salesforce.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("mydomainLink")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("mydomain")).sendKeys("as");
        driver.findElement(By.id("mydomainContinue")).click();
    }

    //EJERCICIO 4
    @Test
    public void checkBoxAndComboboxTest() throws InterruptedException {
        WebDriver driver = getDriver("https://www.facebook.com/");
        driver.manage().window().maximize();
        //Busco por linktext, ya que class y id son dinamicos
        driver.findElement(By.linkText("Crear cuenta nueva")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("firstname")).sendKeys("Alan");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        //Selecciono el combo y seteo en sexo Hombre
        //USO CssSelector
        driver.findElement(By.cssSelector("input[name='sex'][value='2']")).click();

        //SELECCIONO DROPDOWN para elegir la FECHA
        WebElement elementDay = driver.findElement(By.id("day")); //Elemento nombrado 'elementDay'
        Select daySelect = new Select(elementDay);     //Creo objeto 'daySelect' q es un SELECT(Xml)
        daySelect.selectByValue("4");       //Selecciono por valor

        WebElement elementMonth = driver.findElement(By.id("month"));
        Select monthSelect = new Select(elementMonth);
        monthSelect.selectByVisibleText("abr");

        WebElement elementYear = driver.findElement(By.id("year"));
        Select yearSelect = new Select(elementYear);
        yearSelect.selectByIndex(10); //ByIndex se Guia por el indice interno del SELECT!!!!
    }

    //EJERCICIO 6
    @Test
    public void birthdateTest() throws InterruptedException {
        WebDriver driver = getDriver("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.partialLinkText("Crear cuenta")).click();
        Thread.sleep(2000);

        //SELECCIONO DROPDOWN para elegir la FECHA
        WebElement elementDay = driver.findElement(By.id("day")); //Elemento nombrado 'elementDay'
        Select daySelect = new Select(elementDay);     //Creo objeto 'daySelect' q es un SELECT(Xml)
        daySelect.selectByIndex(20);       //Selecciono por Indice del select

        WebElement elementMonth = driver.findElement(By.id("month"));
        Select monthSelect = new Select(elementMonth);
        monthSelect.selectByVisibleText("dic");

        WebElement elementYear = driver.findElement(By.id("year"));
        Select yearSelect = new Select(elementYear);
        yearSelect.selectByValue("1990"); //Selecciono por el atributo VALUE
    }

    //EJERCICIO 7
    @Test
    public void comboboxTest() throws InterruptedException {
        WebDriver driver = getDriver("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Crear cuenta nueva")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("birthday_month"));
        //List<WebElement> elementsMonths = new ArrayList<WebElement>();}

    }
}