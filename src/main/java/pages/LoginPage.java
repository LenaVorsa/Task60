package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(how = How.ID, using = "mailbox__login")
    private WebElement usernameField;

    @FindBy(how = How.ID, using = "mailbox__password")
    private WebElement passwordField;

    @FindBy(how = How.ID, using = "mailbox__auth__button")
    private WebElement loginButton;

    @FindBy (how = How.ID, using = "PH_authLink")
    private WebElement enterLink;

    public void setUserName(String usernameText) {
        usernameField.sendKeys(usernameText);
    }

    public void setPasswordField(String passwordText) {
        passwordField.sendKeys(passwordText);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getFindEnterLink() {
        return enterLink.getText();
    }

}
