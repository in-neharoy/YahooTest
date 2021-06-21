package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage (WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="login-username")
    public WebElement userid;

    @FindBy(id="login-signin")
    public WebElement nextPasswordButton;

    @FindBy(id="login-passwd")
    public WebElement passwd;

    @FindBy(id="login-signin")
    public WebElement nextSignInButton;

    @FindBy(id="username-error")
    public WebElement errorMessage;

    //Method to input the username
    public void enterUsername(String username)
    {
        userid.sendKeys(username);
    }
    //Method to click next to enter the password
    public void clickNextPasswordButton()
    {
        nextPasswordButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Method to input the password
    public void enterPassWord(String password)
    {
        passwd.sendKeys(password);
    }

    //Method to click next to sign in
    public void clickNextSignInButton()
    {
        nextSignInButton.click();
    }

    //Method to validate error message is displayed if username is invalid
    public void validateErrorMsg(String expectedErrorMsg)
    {
        String actualErrorMsg = errorMessage.getText();
        Assert.assertTrue(actualErrorMsg.equalsIgnoreCase(expectedErrorMsg));
    }

}
