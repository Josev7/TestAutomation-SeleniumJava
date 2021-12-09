package Practico13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SpotifyFillingForm {
    WebDriver driver;

    public SpotifyFillingForm(WebDriver remoteDriver) {
        driver = remoteDriver;
    }

    public void completeForm(String email, String confirmationMail, String password, String profile) {
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("[placeholder='Introduce tu correo electrónico.']")).sendKeys(email);
        driver.findElement(By.cssSelector("[placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys(confirmationMail);
        driver.findElement(By.cssSelector("[placeholder='Crea una contraseña.']")).sendKeys(password);
        driver.findElement(By.cssSelector("[placeholder='Introduce un nombre de perfil.']")).sendKeys(profile);
        driver.findElement(By.cssSelector("[placeholder='DD']")).sendKeys("01");

        WebElement elementoMeses = driver.findElement(By.cssSelector("[name='month']"));
        Select mesesSelect = new Select(elementoMeses);
        mesesSelect.selectByVisibleText("Agosto");

        driver.findElement(By.cssSelector("[placeholder='AAAA']")).sendKeys("2000");
        driver.findElement(By.cssSelector("[for='gender_option_male']")).click();
        driver.findElement(By.cssSelector("[for='marketing-opt-checkbox']")).click();
        driver.findElement(By.cssSelector("[for='third-party-checkbox']")).click();
    }
}
