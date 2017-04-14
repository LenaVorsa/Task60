package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    By userNameLocator = By.id("mailbox__login");
    By passwordLocator = By.id("mailbox__password");
    By loginButtonLocator = By.id("mailbox__auth__button");
    By loginLinkLocator = By.id("PH_authLink");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String username) {
        driver.findElement(userNameLocator).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButtonLocator).click();
    }

    public String findLoginLinkText(){
        return driver.findElement(loginLinkLocator).getText();
    }

    public MailPage loginToLoginPage(String username, String password) throws InterruptedException {
        setUserName(username);
        setPassword(password);
        clickLogin();
        Thread.sleep(10000);
        return new MailPage(driver);
    }
}
