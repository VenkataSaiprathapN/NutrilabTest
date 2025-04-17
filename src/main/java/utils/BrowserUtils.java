package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class BrowserUtils {

    public static void openNewTabAndNavigate(WebDriver driver, String url) {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        driver.get(url);
    }

    public static void switchToTab(WebDriver driver, int index) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (index < tabs.size()) {
            driver.switchTo().window(tabs.get(index));
        } else {
            throw new IllegalArgumentException("Tab index out of bounds: " + index);
        }
    }
}
