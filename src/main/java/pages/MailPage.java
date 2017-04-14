package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MailPage {
    private WebDriver driver;
    By logoutLinkLocator = By.id("PH_logoutLink");

    public MailPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFindLogoutLink() {
        return driver.findElement(logoutLinkLocator).getText();
    }

    public LoginPage clickLogoutButton() {
        driver.findElement(logoutLinkLocator).click();
        return new LoginPage(driver);
    }

}

