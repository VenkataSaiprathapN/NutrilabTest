package utils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class PopupHandler {

    // Handle JavaScript Alert
    public static void handleAlert(WebDriver driver, boolean acceptAlert) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            if (acceptAlert) {
                alert.accept();  // Clicks OK
            } else {
                alert.dismiss(); // Clicks Cancel
            }
        } catch (Exception e) {
            System.out.println("No alert present: " + e.getMessage());
        }
    }

    // Handle Switch to New Window
    public static void switchToNewWindow(WebDriver driver) {
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    // Switch Back to Main Window
    public static void switchToMainWindow(WebDriver driver, String mainWindowHandle) {
        driver.switchTo().window(mainWindowHandle);
    }

    // Handle Modal Dialog (if it's an HTML element, like a popup modal)
    public static void handleModal(WebDriver driver, By modalLocator, By closeButtonLocator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(modalLocator));
            WebElement closeButton = modal.findElement(closeButtonLocator);
            closeButton.click();  // Close the modal
        } catch (NoSuchElementException e) {
            System.out.println("Modal or Close button not found: " + e.getMessage());
        }
    }
}
