package pages;
import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#loginusername")
    private WebElement loginField;

    @FindBy(css = "#loginpassword")
    private WebElement passwordField;

    @FindBy(css = "button[onclick='logIn()']")
    private WebElement loginButton;

    @FindBy(css = "#logInModalLabel")
    private WebElement loginTitle;

    @FindBy(css = "label[for='log-name']")
    private WebElement usernameTitle;

    @FindBy(css = "label[for='log-pass']")
    private WebElement passwordTitle;

    public void inputValidCredentials() {
        this.loginField.sendKeys(Constants.USERNAME);
        this.passwordField.sendKeys(Constants.PASSWORD);
        this.loginButton.click();
    }

    public void clickLoginButton() {
        this.loginButton.click();
    }

    public void inputGeneratedUsername() {
        this.loginField.sendKeys(Constants.generateUsername());
    }

    public void inputPassword() {
        this.passwordField.sendKeys(Constants.PASSWORD);
    }

    public void inputExistingUsername() {
        this.loginField.sendKeys(Constants.USERNAME);
    }

    public void inputWrongPassword() {
        this.passwordField.sendKeys(Constants.WRONG_PASSWORD);
    }

    public boolean isDisplayedLogin() {
        return this.loginTitle.isDisplayed();
    }

    public boolean isDisplayedUsername() {
        return this.usernameTitle.isDisplayed();
    }

    public boolean isDisplayedPassword() {
        return this.passwordTitle.isDisplayed();
    }

    public String getBackgroundButtonColor() {
        return this.loginButton.getCssValue(Constants.BACKGROUND_COLOR);
    }
}
