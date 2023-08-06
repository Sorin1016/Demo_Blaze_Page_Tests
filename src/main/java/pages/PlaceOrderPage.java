package pages;
import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaceOrderPage extends BasePage {

    @FindBy(css = "#name")
    private WebElement nameField;

    @FindBy(css = "#country")
    private WebElement countryField;

    @FindBy(css = "#city")
    private WebElement cityField;

    @FindBy(css = "#card")
    private WebElement creditCardField;

    @FindBy(css = "#month")
    private WebElement monthField;

    @FindBy(css = "#year")
    private WebElement yearField;

    @FindBy(css = "button[onclick='purchaseOrder()']")
    private WebElement purchaseButton;

    @FindBy(xpath = "//h2[contains(text(),'Thank')]")
    private WebElement successOrderText;

    @FindBy(css = ".confirm.btn.btn-lg.btn-primary")
    private WebElement confrimButtonAfterOrder;

    public PlaceOrderPage(WebDriver driver) {
        super(driver);
    }

    public void inputName() {
        inputText(this.nameField, Constants.ORDER_NAME);
    }

    public void inputCountry() {
        inputText(this.countryField, Constants.ORDER_COUNTRY);
    }

    public void inputCity() {
        inputText(this.cityField, Constants.ORDER_CIRY);
    }

    public void inputCreditCard() {
        inputText(this.creditCardField, Constants.ORDER_CREDIT_CARD);
    }

    public void inputMonth() {
        inputText(this.monthField, Constants.ORDER_MONTH);
    }

    public void inputYear() {
        inputText(this.yearField, Constants.ORDER_YEAR);
    }

    public void clickPurchaseButton() {
        clickElement(this.purchaseButton);
    }

    public String getSuccessOrderText() {
        return getText(this.successOrderText);
    }

    public void clickOkButtonAfterOrder() {
        clickElement(this.confrimButtonAfterOrder);
    }
}
