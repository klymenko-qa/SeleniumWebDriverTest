import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {
    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/serhii_klymenko/IdeaProjects/SeleniumWebDriverTest/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/join");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void signUpWithShortPasswordTest() {
        SignUpPage sp = signUpPage.typePassword("lohmq ");
        String error = sp.getPasswordErrorText();
        Assert.assertEquals("Password is too short (minimum is 8 characters) and needs at least 1 number", error);
    }

    @Test
    public void signUpUnavailableUsernameTest() {
        SignUpPage sp = signUpPage.typeUserName("username");
        String error = sp.getUserNameErrorText();
        Assert.assertEquals("Username 'username' is unavailable.", error);
    }

    @Test
    public void getHeadingTest() {
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Create your account", heading);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
