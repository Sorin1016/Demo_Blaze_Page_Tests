package DemoBlazeTests;
import constants.Constants;
import constants.ErrorMessages;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignUpPage;
import utils.Utils;

public class SignUpTests extends BaseTests {

    private SignUpPage signUpPage;
    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        this.signUpPage = new SignUpPage(driver);
    }

    @Test
    public void signUpTest() {
        homePage.clickSignUpButton();
        Utils.waitInSeconds(1);
        signUpPage.inputGeneratedCredentials();
        Utils.waitInSeconds(1);
        String actualMessage = Constants.SIGNUP_SUCCESSFUL_MESSAGE;
        Utils.waitInSeconds(1);
        String expectedMessage = Utils.getAlertText(driver);
        Assert.assertEquals(actualMessage, expectedMessage, ErrorMessages.NOT_SAME_ACTUAL_AND_EXPECTED);
        Utils.acceptAlert(this.driver);
    }

    @Test
    public void signUpWithSameCredentials() {
        homePage.clickSignUpButton();
        Utils.waitInSeconds(1);
        signUpPage.inputValidCredentials();
        signUpPage.clickSignUpButton();
        Utils.waitInSeconds(1);
        String actualMessage = Constants.EXISTING_THIS_USERNAME;
        String expectedMessage = Utils.getAlertText(driver);
        Assert.assertEquals(actualMessage, expectedMessage, ErrorMessages.NOT_SAME_ACTUAL_AND_EXPECTED);
        Utils.acceptAlert(driver);
        Utils.acceptAlert(driver);
    }

    @Test
    public void signUpWithoutPassword() {
        homePage.clickSignUpButton();
        Utils.waitInSeconds(1);
        signUpPage.inputGeneratedUsername();
        signUpPage.clickSignUpButton();
        Utils.waitInSeconds(1);
        String actualMessage = Utils.getAlertText(this.driver);
        Assert.assertEquals(actualMessage, Constants.FAIL_LOGIN_OR_REGISTER_MESSAGE,
                ErrorMessages.NOT_SAME_ACTUAL_AND_EXPECTED);
        Utils.acceptAlert(this.driver);
    }

    @Test
    public void signUpWithoutUsername() {
        homePage.clickSignUpButton();
        Utils.waitInSeconds(1);
        signUpPage.inputPassword();
        signUpPage.clickSignUpButton();
        Utils.waitInSeconds(1);
        String actualMessage = Utils.getAlertText(this.driver);
        Assert.assertEquals(actualMessage, Constants.FAIL_LOGIN_OR_REGISTER_MESSAGE,
                ErrorMessages.NOT_SAME_ACTUAL_AND_EXPECTED);
        Utils.acceptAlert(this.driver);
    }

    @Test
    public void signUpWithoutUsernameAndPassword() {
        homePage.clickSignUpButton();
        Utils.waitInSeconds(1);
        signUpPage.clickSignUpButton();
        String actualMessage = Utils.getAlertText(this.driver);
        Assert.assertEquals(actualMessage, Constants.FAIL_LOGIN_OR_REGISTER_MESSAGE,
                ErrorMessages.NOT_SAME_ACTUAL_AND_EXPECTED);
        Utils.acceptAlert(this.driver);
    }

    @Test
    public void isDisplayedSignUp() {
       homePage.clickSignUpButton();
       Utils.waitInSeconds(1);
       Assert.assertTrue(signUpPage.isDisplayedSignUp(), ErrorMessages.IS_NOT_DISPLAYED);
    }

    @Test
    public void isDisplayedUsername() {
        homePage.clickSignUpButton();
        Utils.waitInSeconds(1);
        Assert.assertTrue(signUpPage.isDisplayedUsername(), ErrorMessages.IS_NOT_DISPLAYED);
    }

    @Test
    public void isDisplayedPassword() {
        homePage.clickSignUpButton();
        Utils.waitInSeconds(1);
        Assert.assertTrue(signUpPage.isDisplayedPassword(), ErrorMessages.IS_NOT_DISPLAYED);
    }

    @Test
    public void isDisplayedSignUpButton() {
        homePage.clickSignUpButton();
        Utils.waitInSeconds(1);
        Assert.assertTrue(signUpPage.isDisplayedSignUpButton(), ErrorMessages.IS_NOT_DISPLAYED);
    }

    @Test
    public void signUpButtonColorTest() {
        homePage.clickSignUpButton();
        Utils.waitInSeconds(1);
        String expectedColor = Constants.BLUE_COLOR_SIGNUP_BUTTON;
        String actualColor = signUpPage.getBackgroundButtonColor();
        Assert.assertEquals(actualColor, expectedColor, ErrorMessages.INCORRECT_COLOR_BUTTON);
    }
}
