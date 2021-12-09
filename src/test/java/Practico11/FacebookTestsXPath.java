package Practico11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FacebookTestsXPath {
    String fb_url = "https://www.facebook.com/";

    public WebDriver getDriver(String url) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        return driver;
    }


    @Test
    public void FacebookXPathRelativoTest() throws InterruptedException {
        WebDriver driver = getDriver(fb_url);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@ajaxify='/reg/spotlight/']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("GAEL");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("ELIAS");
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("test@facebook.com");
        driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("elkame10");

        WebElement elementoDia = driver.findElement(By.xpath("//*[@aria-label='Día']"));
        Select selectDias = new Select(elementoDia);
        selectDias.selectByIndex(5);

        //Sexo usando byXPath y AND
        driver.findElement(By.xpath("//*[@name='sex' and @value='-1']")).click();

        Thread.sleep(1000);
        //Usando Contains byXPath
        driver.findElement(By.xpath("//*[contains(text(), 'Registrarse')]")).click();
    }
}
