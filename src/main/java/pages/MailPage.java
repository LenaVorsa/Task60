package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage {
    private WebDriver driver;

    public MailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(how = How.ID, using = "PH_logoutLink")
    private WebElement logoutLink;

    public String getFindLogoutLink() {
        return logoutLink.getText();
    }

    public void clickLogoutLink() {
        logoutLink.click();
    }

    // Не работает этот метод. Пришлось делать через  Thread.sleep(10000); Хочу с тобой обсудить, почему так не работает?
//    public void WaitForLogoutLinkToDisplay(WebDriver webDriver) {
//        WebDriverWait wait = new WebDriverWait(webDriver, 60, 10000);
//        wait.until(ExpectedConditions.visibilityOf(logoutLink));
//    }


}
