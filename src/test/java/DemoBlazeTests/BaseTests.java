package DemoBlazeTests;
import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class BaseTests {
    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp() {
        this.driver = new ChromeDriver();
        this.driver.get(Constants.URL);
        this.driver.manage().window().maximize();
        this.homePage = new HomePage(driver);
    }

    @AfterMethod
    public void closeDriver() {
        this.driver.close();
    }
}

