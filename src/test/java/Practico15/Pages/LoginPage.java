package Practico15.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver remoteDriver) {
        this.driver = remoteDriver;
    }

    public String getPageTittle() {

        return driver.getTitle();
    }

    public String getPageUrl() {

        return driver.getCurrentUrl();
    }

    public String getInicaSesionH1() {
        WebElement iniciaSesionElement = driver.findElement(By.tagName("h1"));
        return iniciaSesionElement.getText();
    }

    public void setAccountEmail(String anEmail) {
        driver.findElement(By.id("id_userLoginId")).sendKeys(anEmail);
    }
    public void setAccountPassword(String anPassword) {
        driver.findElement(By.id("id_password")).sendKeys(anPassword);
    }

    public void clickOnIniciaSesionBtn() {
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
    }

    public String getLogErrorMessage() {
        WebElement errorElement = driver.findElement(By.className("ui-message-contents"));
        return errorElement.getText();
    }



}
