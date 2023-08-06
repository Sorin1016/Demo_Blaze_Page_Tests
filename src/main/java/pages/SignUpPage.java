package pages;
import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#sign-username")
    private WebElement usernameField;
    @FindBy(css = "#sign-password")
    private WebElement passwordField;
    @FindBy(css = "button[onclick='register()']")
    private WebElement registerButton;
    @FindBy(css = "#signInModalLabel")
    private WebElement signUpTitle;
    @FindBy(css = "label[for='sign-username']")
    private WebElement usernameTitle;
    @FindBy(css = "label[for='sign-password']")
    private WebElement passwordTitle;

    public void inputValidCredentials() {
        this.usernameField.sendKeys(Constants.USERNAME);
        this.passwordField.sendKeys(Constants.PASSWORD);
        this.registerButton.click();
    }

    public void inputGeneratedCredentials() {
        this.usernameField.sendKeys(Constants.generateUsername());
        this.passwordField.sendKeys(Constants.PASSWORD);
        this.registerButton.click();
    }

    public void inputPassword() {
        this.passwordField.sendKeys(Constants.PASSWORD);
    }

    public void inputGeneratedUsername() {
        this.usernameField.sendKeys(Constants.generateUsername());
    }

    public void clickSignUpButton() {
        this.registerButton.click();
    }

    public boolean isDisplayedSignUp() {
        return this.signUpTitle.isDisplayed();
    }

    public boolean isDisplayedUsername() {
        return this.usernameTitle.isDisplayed();
    }

    public boolean isDisplayedPassword() {
        return this.passwordTitle.isDisplayed();
    }

    public boolean isDisplayedSignUpButton() {
        return this.registerButton.isDisplayed();
    }

    public String getBackgroundButtonColor() {
        return this.registerButton.getCssValue(Constants.BACKGROUND_COLOR);
    }
}