package Practico16.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignupPage extends BasePage{

    //WebDriver driver; //Desaparece por herencia

    public SignupPage(WebDriver remoteDriver) {
        driver = remoteDriver;
    }

    //Lo paso a la clase BasePage y hago herencia
    /*
    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }
    */


    public void fillRegistrationFields() {
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


}
