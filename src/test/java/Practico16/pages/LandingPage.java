package Practico16.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {

    //WebDriver driver; //Desaparece Por herencia

    public LandingPage(WebDriver remoteDriver) {
        driver = remoteDriver;
    }

    public LoginPage clickOnLoginBtn() {
        driver.findElement(By.xpath("//*[@data-ga-action='log-in']")).click();
        LoginPage nextPage = new LoginPage(driver);
        return nextPage;
    }


}
