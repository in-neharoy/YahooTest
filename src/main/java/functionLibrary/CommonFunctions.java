package functionLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonFunctions {

    public static WebDriver driver;

    //Method to launch a chrome browser
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //Method to accept cookies whenever a browser is launched
    public void acceptCookies()
    {
            driver.findElement(By.xpath("//div[@class='actions couple']/button[@name='agree']")).click();
    }

    //Method to quit driver
    public void quitBrowser()
    {
        driver.quit();
    }

    //Method to implement wait
    public void implicitWait(int waitTime)
    {
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
    }

    //Method to read data from properties file
    public String readFile(String key) throws Exception
    {
        String filePath = new File("src/main/resources/testData/testData.properties").getAbsolutePath();
        // Read the file through FileInputStream
        FileInputStream inputStream = new FileInputStream(filePath);
        //Load the properties of the file read
        Properties properties = new Properties();
        properties.load(inputStream);
        //get the value of the property on basis of key from the file
        String value = properties.getProperty(key);
        return value;
    }

    //Method to scroll down in a webpage
    public void scrollDown()
    {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
    }

}
