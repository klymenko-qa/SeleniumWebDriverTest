import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//div[contains(@class, 'container')]//h1");
    private By userNameField = By.xpath("//input[@id='user_login']");
    private By emailField = By.xpath("//input[@id='user_email']");
    private By passwordField = By.xpath("//input[@id='user_password']");
    private By signUpButton = By.xpath("//button[@type='submit']");
    private By mainError = By.xpath("//div[contains(@class, 'flash-error')]");
    private By passwordError = By.xpath("//dl[contains(@class, 'required errored')]//dd[@id]");
    private By userNameError = By.xpath("//dl[contains(@class, 'required errored')]//dd[@class='error']/div[1]/div[1]");

    public SignUpPage typeUserName(String username) {
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public SignUpPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage registerWithInvalidCreds (String username, String email, String password) {
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    public String getErrorText() {
        return driver.findElement(mainError).getText();
    }

    public String getPasswordErrorText() {
        return driver.findElement(passwordError).getText();
    }

    public String getUserNameErrorText() {
        return driver.findElement(userNameError).getText();
    }

}
