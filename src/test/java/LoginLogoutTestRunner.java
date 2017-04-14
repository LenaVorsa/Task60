//Helper http://www.summa.com/blog/2011/10/10/using-page-objects-with-selenium-and-web-driver-20 and
// http://www.guru99.com/page-object-model-pom-page-factory-in-selenium-ultimate-guide.html

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.MailPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginLogoutTestRunner {
    private WebDriver driver;
    private LoginPage loginPage;
    private MailPage mailPage;

    private final static String webSiteURL = "https://mail.ru/";
    private final static String username = "seleniumtests10@mail.ru";
    private final static String password = "060788avavav";
    private final static String logoutlinkText = "выход";
    private final static String loginLinkText = "Вход";

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(webSiteURL);
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void treatDown() {
        driver.quit();
    }

    @Test
    public void LoginPageTest() throws InterruptedException {
        mailPage = loginPage.loginToLoginPage(username, password);
        Assert.assertTrue(mailPage.getFindLogoutLink().toLowerCase().contains(logoutlinkText));
    }

    @Test
    public void LogoutPagetest() throws InterruptedException {
        mailPage = loginPage.loginToLoginPage(username, password);
        mailPage.clickLogoutButton();
        Thread.sleep(10000);
        Assert.assertEquals(loginPage.findLoginLinkText(), loginLinkText);
    }
}
