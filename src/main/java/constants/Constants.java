package constants;
import com.github.javafaker.Faker;

public class Constants {
    public static final String URL = "https://www.demoblaze.com/index.html";
    public static final String USERNAME = "Sor2in132";
    public static final String PASSWORD = "123456";
    public static final String WELCOME_MESSAGE = "Welcome";
    public static final String SIGNUP_SUCCESSFUL_MESSAGE = "Sign up successful.";
    public static final String FAIL_LOGIN_OR_REGISTER_MESSAGE = "Please fill out Username and Password.";
    public static final String FAIL_LOGIN_WITH_WRONG_PASSWORD = "Wrong password.";
    public static final String WRONG_PASSWORD = "11223a";
    public static final String FAIL_LOGIN_WITH_WRONG_USERNAME = "User does not exist.";
    public static final String EXISTING_THIS_USERNAME = "This user already exist.";
    public static final String PRODUCT_ADDED_TEXT = "Product added.";
    public static final String ALERT_TEXT_BOX_IS_INCORECT = "The alert box text is incorrect";
    public static final String ORDER_NAME = "Sorin";
    public static final String ORDER_COUNTRY = "Romania";
    public static final String ORDER_CIRY = "Deva";
    public static final String ORDER_CREDIT_CARD = "5555444466667777";
    public static final String ORDER_MONTH = "August";
    public static final String ORDER_YEAR = "2023";
    public static final String SUCCESS_ORDER = "Thank you for your purchase!";

    // CssValues

    public static final String BACKGROUND_COLOR = "background-color";
    public static String generateUsername() {
        Faker faker = new Faker();
        return faker.name().firstName() + "@gmail.com";
    }

    // rgb colors

    public static final String BLUE_COLOR_LOGIN_BUTTON = "rgba(2, 117, 216, 1)";
    public static final String BLUE_COLOR_SIGNUP_BUTTON = "rgba(2, 117, 216, 1)";
}
