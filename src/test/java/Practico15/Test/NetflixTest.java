package Practico15.Test;

import Practico15.Pages.LandingPage;
import Practico15.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NetflixTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.netflix.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void netflixRegistrationText(){
        LandingPage landingpage = new LandingPage(driver);

        System.out.println(landingpage.getPageTittle());
        System.out.println(landingpage.getPageUrl());

        Assert.assertEquals(landingpage.getPageTittle(), "Netflix Argentina: Ve series online, ve películas online", "ERROR: Se esperaba otro TITULO");
        Assert.assertEquals(landingpage.getPageUrl(), "https://www.netflix.com/ar/", "Se esperaba otra URL");


        //for (WebElement elementos: listaH1s) {
        //    System.out.println("--> " + elementos.getText());
        //}
        //Assert.assertEquals(landingpage.getAmountH1s(), 6, "Deberia haber 6 H1's");

        LoginPage loginPage = landingpage.clickOnLoginBtn();

        Assert.assertEquals(loginPage.getPageTittle(), "Netflix", "ERROR: Se esperaba otro TITULO");
        Assert.assertEquals(loginPage.getPageUrl(), "https://www.netflix.com/ar/login", "ERROR: Se esperaba otra URL" );

        Assert.assertEquals(loginPage.getInicaSesionH1(), "Inicia sesión", "ERROR: Se esperaba otro H1");


        //driver.findElement(By.id("id_password")).sendKeys("elÑoñoNetflixianno");

        loginPage.setAccountEmail("eldada@netflix.com");
        loginPage.setAccountPassword("elkame10");

        //driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        loginPage.clickOnIniciaSesionBtn();

        System.out.println(loginPage.getLogErrorMessage());
        Assert.assertTrue(loginPage.getLogErrorMessage().contains("No podemos encontrar una cuenta con esta dirección de email."));
    }

    /*
    System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        Assert.assertEquals(driver.getTitle(), "Netflix Argentina: Ve series online, ve películas online", "ERROR: Se esperaba otro TITULO");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.netflix.com/ar/", "Se esperaba otra URL");
        List<WebElement> listaH1s = driver.findElements(By.tagName("h1"));
        for (WebElement elementos: listaH1s) {
            System.out.println("--> " + elementos.getText());
        }
        Assert.assertEquals(listaH1s.size(), 6, "Deberia haber 6 H1's");

        driver.findElement(By.xpath("//*[@href='/login']")).click();
        Assert.assertEquals(driver.getTitle(), "Netflix", "ERROR: Se esperaba otro TITULO");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.netflix.com/ar/login", "ERROR: Se esperaba otra URL" );

        WebElement iniciaSesionElement = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(iniciaSesionElement.getText(), "Inicia sesión", "ERROR: Se esperaba otro H1");

        driver.findElement(By.id("id_userLoginId")).sendKeys("elÑoño@netflix.com");
        driver.findElement(By.id("id_password")).sendKeys("elÑoñoNetflixianno");
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        WebElement errorElement = driver.findElement(By.className("ui-message-contents"));
        System.out.println(errorElement.getText());
        Assert.assertTrue(errorElement.getText().contains("No podemos encontrar una cuenta con esta dirección de email."));
    }
     */
}
