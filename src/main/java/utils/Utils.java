package utils;
import org.openqa.selenium.WebDriver;

public class Utils {
    public static void waitInSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public static String getAlertText(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }
}
