package tests;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ExtentManager;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;



public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData")
    public void loginTest(String email, String pass) {
        ExtentManager.startTest("Login Test");
        LoginPage lp = new LoginPage(getDriver());
        lp.login(email, pass);
        ExtentManager.log("Login attempted with: " + email);
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
            { ConfigReader.get("userid"), ConfigReader.get("password") }
        };
    }

    @Test(dataProvider = "invalidLoginData")
public void invalidLoginTest(String email, String pass) {
    ExtentManager.startTest("Invalid Login Test");
    WebDriver driver = getDriver();
    LoginPage lp = new LoginPage(driver);

    // Perform login with invalid credentials
    lp.login(email, pass);
    ExtentManager.log("Login attempted with: " + email);

    // Assert that error message is displayed
    boolean isErrorMessageDisplayed = driver.findElement(By.id("error-message")).isDisplayed();
    Assert.assertTrue(isErrorMessageDisplayed, "Error message was not displayed for invalid login");

    ExtentManager.log("Error message displayed for invalid login with: " + email);
}

@DataProvider(name = "invalidLoginData")
public Object[][] getInvalidData() {
    return new Object[][] {
        { "invaliduser@example.com", "wrongpassword" }
    };
}


  
}