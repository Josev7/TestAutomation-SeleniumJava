package Practico16.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    //WebDriver driver; //Desaparece por Herencia

    public LoginPage(WebDriver remoteDriver) {

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

    public SignupPage clickOnRegistrationBtn() {
        driver.findElement(By.id("sign-up-link")).click();
        SignupPage nextPage = new SignupPage(driver);
        return nextPage;
    }
}

