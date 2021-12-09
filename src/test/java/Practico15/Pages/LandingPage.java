package Practico15.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LandingPage {
    public WebDriver driver;

    public LandingPage(WebDriver remoteDriver) {

        this.driver = remoteDriver;
    }

    public String getPageTittle() {

        return driver.getTitle();
    }

    public String getPageUrl() {

        return driver.getCurrentUrl();
    }

    public int getAmountH1s() {
        List<WebElement> listaH1s = driver.findElements(By.tagName("h1"));
        return listaH1s.size();
    }

    public LoginPage clickOnLoginBtn() {
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        //Creo EL PASAJE A LA SIGUIENTE PAGINA.
        LoginPage nextPage = new LoginPage(driver);
        return nextPage;
    }
}
