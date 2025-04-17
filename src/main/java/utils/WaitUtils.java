package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class WaitUtils {

    // Get global delay from config.properties
    private static int globalDelay = Integer.parseInt(ConfigReader.get("stepDelay"));

    // Apply global delay before waiting for elements to be visible
    public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {
        applyGlobalDelay();  // Apply the global delay
        new WebDriverWait(driver, Duration.ofSeconds(15))
            .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeVisible(WebDriver driver, WebElement element, int timeoutInSeconds) {
        applyGlobalDelay();  // Apply the global delay
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
            .until(ExpectedConditions.visibilityOf(element));
    }

    // Apply global delay before waiting for elements to be clickable
    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        applyGlobalDelay();  // Apply the global delay
        new WebDriverWait(driver, Duration.ofSeconds(15))
            .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
        applyGlobalDelay();  // Apply the global delay
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
            .until(ExpectedConditions.elementToBeClickable(element));
    }

    // Method to apply global delay
    private static void applyGlobalDelay() {
        try {
            Thread.sleep(globalDelay);  // Apply delay in milliseconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // Restore interrupt status
        }
    }
}
