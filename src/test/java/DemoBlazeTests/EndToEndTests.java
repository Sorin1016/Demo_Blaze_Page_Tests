package DemoBlazeTests;
import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.Utils;

public class EndToEndTests extends BaseTests {
    private MonitorsPage monitorsPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private PlaceOrderPage placeOrderPage;
    private LogInPage logInPage;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        monitorsPage = new MonitorsPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        placeOrderPage = new PlaceOrderPage(driver);
        logInPage = new LogInPage(driver);
    }

    @Test
    public void endToEndFlowTest() {
        homePage.clickLoginButton();
        Utils.waitInSeconds(1);
        logInPage.inputValidCredentials();
        logInPage.clickLoginButton();
        Utils.waitInSeconds(2);
        String actualMessage = homePage.welcomeLogInMessage();
        Assert.assertTrue(actualMessage.contains(Constants.WELCOME_MESSAGE));
        homePage.clickMonitorsButton();
        Utils.waitInSeconds(1);
        monitorsPage.clickAsusMonitorLink();
        Utils.waitInSeconds(1);
        productPage.clickAddToCartButton();
        Utils.waitInSeconds(1);
        Assert.assertEquals(Utils.getAlertText(driver), Constants.PRODUCT_ADDED_TEXT,
                Constants.ALERT_TEXT_BOX_IS_INCORECT);
        Utils.acceptAlert(driver);
        Utils.waitInSeconds(1);
        homePage.clickCartButton();
        Utils.waitInSeconds(1);
        cartPage.clickPlaceOrderButton();
        Utils.waitInSeconds(1);
        placeOrderPage.inputName();
        placeOrderPage.inputCountry();
        placeOrderPage.inputCity();
        placeOrderPage.inputCreditCard();
        placeOrderPage.inputMonth();
        placeOrderPage.inputYear();
        placeOrderPage.clickPurchaseButton();
        Utils.waitInSeconds(1);
        Assert.assertEquals(Constants.SUCCESS_ORDER, placeOrderPage.getSuccessOrderText());
        placeOrderPage.clickOkButtonAfterOrder();
        Utils.waitInSeconds(1);
        homePage.clickLogOutButton();
        Utils.waitInSeconds(1);
        Assert.assertTrue(homePage.isSignUpButtonDisplayed());
    }
}
