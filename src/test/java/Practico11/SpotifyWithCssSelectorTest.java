package Practico11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SpotifyWithCssSelectorTest {
    //EJERCICIO 9
    public WebDriver getDriver(String url) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        return driver;
    }


    @Test
    public void spotifyByPlaceHolderTest() {
        WebDriver driver = getDriver("https://www.spotify.com/ar/signup/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("input[placeholder='Introduce tu correo electrónico.']")).sendKeys("benja@test.com");
        driver.findElement(By.cssSelector("input[placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("benja@test.com");
        driver.findElement(By.cssSelector("input[placeholder='Crea una contraseña.']")).sendKeys("benja@test.com");
        driver.findElement(By.cssSelector("input[placeholder='Introduce un nombre de perfil.']")).sendKeys("Benjamin");

    }
}
