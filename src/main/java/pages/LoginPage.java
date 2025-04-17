package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;
import utils.ActionUtils;
import utils.PopupHandler;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Enter your Email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@placeholder='Enter Your Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(.,'Login')]")
    private WebElement loginButton;

    // @FindBy(xpath = "//img[@alt='logo']")
    // private WebElement logobtn;

    public void login(String email, String password) {
        WaitUtils.waitForElementToBeVisible(driver, emailInput);
        emailInput.sendKeys(email);

        WaitUtils.waitForElementToBeVisible(driver, passwordInput);
        passwordInput.sendKeys(password);

        WaitUtils.waitForElementToBeClickable(driver, loginButton);
        loginButton.click();

        // WaitUtils.waitForElementToBeVisible(driver, logobtn);
        // ActionUtils.isDisplayed(logobtn); // ✅ now works because method is static

        // Handle any alert that might appear after login
       PopupHandler.handleAlert(driver, true);   

    }
}
