package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import functionLibrary.CommonFunctions;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginSteps extends CommonFunctions {

    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Given("^I am on home page$")
    public void i_am_on_home_page() throws Exception {
        driver.get(readFile("url"));
    }

    @When("^I click on the Sign in button$")
    public void i_click_on_the_Sign_in_button()  {
        implicitWait(3);
        acceptCookies();
        homePage.clickSignIn();
    }

    @When("^I enter the username \"([^\"]*)\"$")
    public void i_enter_the_username(String username) throws Exception {
        loginPage.enterUsername(readFile("username"));
    }

    @When("^I click next to enter the password$")
    public void i_click_next_to_enter_the_password()  {
        loginPage.clickNextPasswordButton();
    }

    @When("^I enter the password \"([^\"]*)\"$")
    public void i_enter_the_password(String password) throws Exception {
        loginPage.enterPassWord(readFile("password"));
    }

    @When("^I click next button to sign in$")
    public void i_click_next_button_to_sign_in()  {
        loginPage.clickNextSignInButton();
    }

    @Then("^I reach my yahoo home page$")
    public void i_reach_my_yahoo_home_page()  {
        homePage.validateLogin();
    }

    @When("^I enter invalid username \"([^\"]*)\"$")
    public void i_enter_invalid_username(String username) {
            loginPage.enterUsername(username);
    }

    @Then("^I should see error message \"([^\"]*)\"$")
    public void i_should_see_error_message(String errorMsg) {
        implicitWait(3);
        loginPage.validateErrorMsg(errorMsg);
    }


}
