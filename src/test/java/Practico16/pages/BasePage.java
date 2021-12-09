package Practico16.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }
}
