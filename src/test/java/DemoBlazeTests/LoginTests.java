package DemoBlazeTests;
import constants.Constants;
import constants.ErrorMessages;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LogInPage;
import utils.Utils;

public class LoginTests extends BaseTests {

    private LogInPage logInPage;
    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        this.logInPage = new LogInPage(driver);
    }

    @Test
    public void logInTest() {
        homePage.clickLoginButton();
        Utils.waitInSeconds(1);
        logInPage.inputValidCredentials();
        logInPage.clickLoginButton();
        Utils.waitInSeconds(2);
        String actualMessage = homePage.welcomeLogInMessage();
        Assert.assertTrue(actualMessage.contains(Constants.WELCOME_MESSAGE),
                ErrorMessages.NOT_SAME_ACTUAL_AND_EXPECTED);
    }

    @Test
    public void loginWithoutUsernameAndPassword() {
        homePage.clickLoginButton();
        Utils.waitInSeconds(1);
        logInPage.clickLoginButton();
        Utils.waitInSeconds(1);
        String actualMessage = Utils.getAlertText(this.driver);
        Assert.assertEquals(actualMessage, Constants.FAIL_LOGIN_OR_REGISTER_MESSAGE,
                ErrorMessages.NOT_SAME_ACTUAL_AND_EXPECTED);
        Utils.waitInSeconds(1);
        Utils.acceptAlert(this.driver);
    }

    @Test
    public void loginTestWithoutPassword() {
        homePage.clickLoginButton();
        Utils.waitInSeconds(1);
        logInPage.inputGeneratedUsername();
        logInPage.clickLoginButton();
        Utils.waitInSeconds(1);
        String actualMessage = Utils.getAlertText(this.driver);
        Assert.assertEquals(actualMessage, Constants.FAIL_LOGIN_OR_REGISTER_MESSAGE,
                ErrorMessages.NOT_SAME_ACTUAL_AND_EXPECTED);
        Utils.waitInSeconds(1);
        Utils.acceptAlert(this.driver);
    }

    @Test
    public void loginTestWithoutUsername() {
        homePage.clickLoginButton();
        Utils.waitInSeconds(1);
        logInPage.inputPassword();
        logInPage.clickLoginButton();
        Utils.waitInSeconds(1);
        String actualMessage = Utils.getAlertText(this.driver);
        Assert.assertEquals(actualMessage, Constants.FAIL_LOGIN_OR_REGISTER_MESSAGE,
                ErrorMessages.NOT_SAME_ACTUAL_AND_EXPECTED);
        Utils.waitInSeconds(1);
        Utils.acceptAlert(this.driver);
    }

    @Test
    public void loginWithWrongPassword() {
        homePage.clickLoginButton();
        Utils.waitInSeconds(1);
        logInPage.inputExistingUsername();
        logInPage.inputWrongPassword();
        logInPage.clickLoginButton();
        Utils.waitInSeconds(1);
        String actualMessage = Utils.getAlertText(this.driver);
        Assert.assertEquals(actualMessage, Constants.FAIL_LOGIN_WITH_WRONG_PASSWORD,
                ErrorMessages.NOT_SAME_ACTUAL_AND_EXPECTED);
        Utils.waitInSeconds(1);
        Utils.acceptAlert(this.driver);
    }

    @Test
    public void loginWithWrongUsername() {
        homePage.clickLoginButton();
        Utils.waitInSeconds(1);
        logInPage.inputGeneratedUsername();
        logInPage.inputPassword();
        logInPage.clickLoginButton();
        Utils.waitInSeconds(1);
        String actualMessage = Utils.getAlertText(this.driver);
        Assert.assertEquals(actualMessage, Constants.FAIL_LOGIN_WITH_WRONG_USERNAME,
                ErrorMessages.NOT_SAME_ACTUAL_AND_EXPECTED);
        Utils.waitInSeconds(1);
        Utils.acceptAlert(this.driver);
    }

    @Test
    public void isDisplayedLogIn() {
        homePage.clickLoginButton();
        Utils.waitInSeconds(1);
        Assert.assertTrue(logInPage.isDisplayedLogin(), ErrorMessages.IS_NOT_DISPLAYED);
    }

    @Test
    public void isDisplayedUsername() {
        homePage.clickLoginButton();
        Utils.waitInSeconds(1);
        Assert.assertTrue(logInPage.isDisplayedUsername(), ErrorMessages.IS_NOT_DISPLAYED);
    }

    @Test
    public void isDisplayedPassword() {
        homePage.clickLoginButton();
        Utils.waitInSeconds(1);
        Assert.assertTrue(logInPage.isDisplayedPassword(), ErrorMessages.IS_NOT_DISPLAYED);
    }

    @Test
    public void loginButtonColorTest() {
        homePage.clickLoginButton();
        String expectedColor = Constants.BLUE_COLOR_LOGIN_BUTTON;
        String actualColor = logInPage.getBackgroundButtonColor();
        Assert.assertEquals(actualColor, expectedColor, ErrorMessages.INCORRECT_COLOR_BUTTON);
    }
}
