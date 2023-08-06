package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "#signin2")
     private WebElement signUpButton ;

    @FindBy(id = "login2")
    private WebElement loginButton;

    @FindBy(css = "#nameofuser")
    private WebElement loginMessage;

    @FindBy(xpath = "//a[contains(text(),'Monitors')]")
    private WebElement monitorsButton;

    @FindBy(css = "#cartur")
    private WebElement cartButton;

    @FindBy(css = "a[onclick='logOut()']")
    private WebElement logOutButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        clickElement(this.loginButton);
    }

    public void clickSignUpButton() {
        clickElement(this.signUpButton);
    }

    public boolean isSignUpButtonDisplayed() {
        return isElementDisplayed(this.signUpButton);
    }

    public String welcomeLogInMessage() {
        return getText(this.loginMessage);
    }

    public void clickMonitorsButton() {
        clickElement(this.monitorsButton);
    }

    public void clickCartButton() {
        clickElement(this.cartButton);
    }

    public void clickLogOutButton() {
        clickElement(this.logOutButton);
    }
}
