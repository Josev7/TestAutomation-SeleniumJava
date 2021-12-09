package Practico11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Ejercicios11  {

    public WebDriver getDriver(String url) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        return driver;
    }

    //EJERCICIO1
    @Test
    public void DocusignTest() throws InterruptedException {
        WebDriver driver = getDriver("https://go.docusign.com/o/trial/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Elias");
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Ovando");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("5493487221422");
        driver.findElement(By.xpath("//input[@name='title']")).sendKeys("Engineer");

        WebElement selectIndustry = driver.findElement(By.xpath("//select[@name='ds_industry']"));
        Select industry = new Select(selectIndustry);
        industry.selectByValue("Technology");
        Thread.sleep(3000);
        driver.close();
    }

    //EJERCICIO2
    @Test
    public void defaultxPathTest() throws InterruptedException {
        WebDriver driver = getDriver("https://go.docusign.com/o/trial/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//label[@id='dsFormLabel_First_Name']")).sendKeys("Anaís");
        driver.findElement(By.xpath("//label[@id='dsFormLabel_Last_Name']")).sendKeys("Quecaña");
        driver.findElement(By.xpath("//label[@id='dsFormLabel_Email']")).sendKeys("anaismelunch@test.com");
        driver.findElement(By.xpath("//label[@id='dsFormLabel_Phone']")).sendKeys("3487221415");
        driver.findElement(By.xpath("//label[@id='dsFormLabel_Job_Title']")).sendKeys("Carpinter");

        WebElement selectIndustry = driver.findElement(By.xpath("//select[@aria-label='Industry']"));
        Select industry = new Select(selectIndustry);
        industry.selectByVisibleText("Manufacturing");
        Thread.sleep(3000);
        driver.close();
    }

    //EJERCICIO3






}
