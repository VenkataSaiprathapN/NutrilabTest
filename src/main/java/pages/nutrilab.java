
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;
import utils.ActionUtils;
import utils.PopupHandler;

public class nutrilab
{

    private WebDriver driver;

    public nutrilab(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[normalize-space(text())='NutriLab']")
    private WebElement nutriLabHeader;

    public boolean isNutriLabHeaderDisplayed() {
        WaitUtils.waitForElementToBeVisible(driver, nutriLabHeader);
        return ActionUtils.isDisplayed(nutriLabHeader);
    }
}