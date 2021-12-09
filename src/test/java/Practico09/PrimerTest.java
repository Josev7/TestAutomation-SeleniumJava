package Practico09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class PrimerTest {
    public WebDriver getNetflixDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.netflix.com.ar");
        return driver;
    }

    public WebDriver getDriver(String url) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        return driver;
    }
    @Test
    public void PrimerTesteo() {
        WebDriver driver = getNetflixDriver();
        driver.manage().window().maximize();
        System.out.println("El titulo de la página es : " + driver.getTitle());
        System.out.println("La URL de la página es: " + driver.getCurrentUrl());

        WebElement elementoH1 = driver.findElement(By.tagName("h1"));
        System.out.println("H1: " + elementoH1.getText());

        WebElement elementoH2 = driver.findElement(By.tagName("h2"));
        System.out.println("H2: " + elementoH2.getText());

        List<WebElement> listaH1s = driver.findElements(By.tagName("h1"));
        System.out.println("La cantidad de H1s es: " + listaH1s.size());

        for (WebElement h1 : listaH1s) {
            System.out.println("H1 es: " + h1.getText());

        }
        //driver.close();
    }
    //Comentario
    @Test
    public void SpotifyTest() {
        /*System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();*/
        WebDriver driver = getDriver("http://www.spotify.com");


        //EJERCICIO 7
        System.out.println(driver.getTitle());
        if (driver.getTitle().equals("Escuchar es todo - Spotify")) {
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED");
        }

    }

}
