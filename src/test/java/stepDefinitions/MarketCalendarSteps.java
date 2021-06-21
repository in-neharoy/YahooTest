package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import functionLibrary.CommonFunctions;
import pageObjects.FinancePage;
import pageObjects.HomePage;

public class MarketCalendarSteps extends CommonFunctions {

    HomePage homePage = new HomePage(driver);
    FinancePage financePage = new FinancePage(driver);

    @When("^I click on the menu Finance$")
    public void i_click_on_the_menu_Finance() {
        homePage.clickMenuFinance();
        financePage.validateLogo();
    }

    @When("^I mouse hover over Market Data$")
    public void i_mouse_hover_over_Market_Data() {
        financePage.hoverMenuMarketData();
    }

    @When("^I click on the sub menu Calendar$")
    public void i_click_on_the_sub_menu_Calendar() {
        financePage.clickMenuCalendar();
        implicitWait(5);
    }

    @When("^I scroll down the window$")
    public void i_scroll_down_the_window() {
        scrollDown();
        implicitWait(3);
    }

    @When("^I click on next$")
    public void i_click_on_next() {
        financePage.clickNextArrow();
        implicitWait(2);
        scrollDown();
    }

    @Then("^I can view the Finance Market Calendar$")
    public void i_can_view_the_Finance_Market_Calendar() {
        implicitWait(3);
        financePage.validateFinanceInfo();
    }


}
