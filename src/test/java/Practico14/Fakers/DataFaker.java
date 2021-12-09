package Practico14.Fakers;

import Practico13.Constants;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DataFaker {
    public WebDriver driver;

    @Test
    public void dataFakerTest() {
        Faker faker = new Faker();

        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.internet().ipV4Address());
        System.out.println(faker.internet().password(4, 10));
        System.out.println("Position: " + faker.job().position());
        System.out.println("Seniority: " + faker.job().seniority());
        System.out.println("title: " + faker.job().title());
    }

    @BeforeMethod
    public void setup() {   //Va a inicar cada vez que corra un test
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/ar/signup/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void registrationTest() {

        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys(DataFakerGenerator.getLastName());
        driver.findElement(By.cssSelector("[placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys(DataFakerGenerator.getEmailAdress());
        driver.findElement(By.cssSelector("[placeholder='Crea una contraseña.']")).sendKeys(DataFakerGenerator.getPassword());
        driver.findElement(By.cssSelector("[placeholder='Introduce un nombre de perfil.']")).sendKeys(DataFakerGenerator.getFakeFirstName());
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
        Assert.assertEquals(emailErrorElement.getText(), "Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com", "Se esperaba un mensaje de email no válido");
    }
}
