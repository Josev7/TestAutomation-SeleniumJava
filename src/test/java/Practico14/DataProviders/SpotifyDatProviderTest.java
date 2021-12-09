package Practico14.DataProviders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SpotifyDatProviderTest {

    String url = "https://www.spotify.com/ar/signup/";
    public WebDriver driver;


    @BeforeMethod
    public void setup() {   //Va a inicar cada vez que corra un test
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }

    @Test (dataProvider = "datosSpotify", dataProviderClass = DataFactory.class)
    public void registrationTest(String email, String confirmation, String password) {
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("confirm")).sendKeys(confirmation);
        driver.findElement(By.name("password")).sendKeys(password);

        //if (errorType.equals("DUPLICATE_EMAIL_ERROR")) {

        //} else if
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

    }*/
}
