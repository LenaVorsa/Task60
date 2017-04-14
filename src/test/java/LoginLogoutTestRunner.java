//http://seleniummaster.com/sitecontent/index.php/selenium-web-driver-menu/selenium-test-automation-with-java/226-using-page-factory-in-selenium-web-driver

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MailPage;
import java.util.concurrent.TimeUnit;

public class LoginLogoutTestRunner {
    private WebDriver driver;

    private final static String webSiteURLText = "https://mail.ru/";
    private final static String usernameText = "seleniumtests10@mail.ru";
    private final static String passwordText = "060788avavav";
    private final static String logoutlinkText = "выход";
    private final static String loginLinkText = "Вход";

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(webSiteURLText);
    }

    @AfterMethod
    public void treatDown() {
        driver.quit();
    }

    @Test
    public void loginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(usernameText);
        loginPage.setPasswordField(passwordText);
        loginPage.clickLoginButton();
        Thread.sleep(10000);
        MailPage mailPage = new MailPage(driver);
        Assert.assertTrue(mailPage.getFindLogoutLink().toLowerCase().contains(logoutlinkText));
    }

    @Test
    public void logoutTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(usernameText);
        loginPage.setPasswordField(passwordText);
        loginPage.clickLoginButton();
        Thread.sleep(10000);
        MailPage mailPage = new MailPage(driver);
        mailPage.clickLogoutLink();
        Thread.sleep(10000);
        Assert.assertEquals(loginPage.getFindEnterLink(), loginLinkText);

    }
}
