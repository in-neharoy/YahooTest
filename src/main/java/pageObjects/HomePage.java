package pageObjects;

import functionLibrary.CommonFunctions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "_yb_qwfgw")
    public WebElement signInButton;

    @FindBy(className = "_yb_2gip2")
    public WebElement actualLoginString;

    @FindBy(id="root_5")
    public WebElement menuFinance;

    //Method to click on Sign In button
    public void clickSignIn()
    {
        signInButton.click();
    }

    //Method to assert if the user is a valid user
    public void validateLogin()
    {
        String expectedStr = "123";
        Assert.assertEquals(actualLoginString.getText(),expectedStr);
    }

    //Method to click on menu Finance
    public void clickMenuFinance()
    {
        menuFinance.click();
    }
}
