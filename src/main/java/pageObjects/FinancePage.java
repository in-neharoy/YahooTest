package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FinancePage {

    public WebDriver driver;

    public FinancePage (WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver= driver;
    }

    @FindBy(id="uh-logo")
    public WebElement yahooFinanceLogo;

    @FindBy(css ="div[title='Market Data']")
    public WebElement menuMarketData;

    @FindBy(css ="a[title='Calendar']")
    public WebElement menuCalendar;

    @FindBy(xpath = "//a[@title='Next']//*[name()='svg']")
    public WebElement nextArrow;

    @FindBy(xpath = "//div[@class='W(100%) Pos(r) Mb(20px)']//li[6]//a")
    public List<WebElement> financeRows;

    @FindBy(xpath = "//div[@class='W(100%) Pos(r) Mb(20px)']//li[6]//div/span")
    public List<WebElement> dateInfo;

    //Method to validate that Yahoo Finance page is reached.
    public void validateLogo()
    {
        Assert.assertTrue(yahooFinanceLogo.isDisplayed());
    }

    //Method to hover over the menu Market Data
    public void hoverMenuMarketData()
    {
        Actions action = new Actions(driver);
        action.moveToElement(menuMarketData).build().perform();
    }

    //Method to click on submenu Calendar
    public void clickMenuCalendar()
    {
        menuCalendar.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Method to perform a click operation on SVG webelement Next
    public void clickNextArrow()
    {
        Actions a = new Actions(driver);
        a.moveToElement(nextArrow).click().build().perform();
    }

    //Method to display date. This method is called in method validateFinanceInfo
    private void displayDateInfo(){
        String firstPart = "//div[@id='fin-cal-events']//div[@class='W(100%) Pos(r) Mb(20px)']//li[6]/div/span[";
        String secondPart= "]";
        String displayDate ="";
        for(int i=1;i<=dateInfo.size();i++)
        {
            String finalXpath = firstPart+i+secondPart;
            String actualResult = driver.findElement(By.xpath(finalXpath)).getText();
            displayDate = displayDate.concat(actualResult);
            displayDate = displayDate +" ";
        }
        System.out.println("Date :" + displayDate);
    }

    //Method to assert that valid Finance events
    public void validateFinanceInfo()
    {
        String [] expectedString = {"Earnings","Stock splits","IPO pricing","Economic events"};
        String firstPart = "//div[@id='fin-cal-events']//div[@class='W(100%) Pos(r) Mb(20px)']//li[6]//a[";
        String secondPart= "]/span";
        String thirdPart = "]";
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int noOfEntries = financeRows.size();
        System.out.println("No of entries: "+financeRows.size());
        for (int i = 1; i <= noOfEntries; i++) {
            String finalXpath = firstPart + i + secondPart;
            String valueXPath = firstPart + i + thirdPart;
            String actualResult = driver.findElement(By.xpath(finalXpath)).getText();
            String valueResult = driver.findElement(By.xpath(valueXPath)).getText();
            for (int j=0; j<4;j++){
                if(actualResult.equalsIgnoreCase(expectedString[j])) {
                    Assert.assertTrue(actualResult.contains(expectedString[j]));
                    System.out.println(valueResult);
                }
            }
        }
        displayDateInfo();
    }



}
