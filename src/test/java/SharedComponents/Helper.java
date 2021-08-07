package SharedComponents;

import io.cucumber.java.en_old.Ac;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Helper {

    static WebDriver driver;
    WebElement element;

    public void open(String url, String browser) {

        browser = browser.toLowerCase();
        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src\\test\\Resources\\Drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src\\test\\Resources\\Drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "src\\test\\Resources\\Drivers\\msedgedriver.exe");
                driver = new EdgeDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebElement findElementById(String locater) {
        element = driver.findElement(By.id(locater));
        return element;
    }

    public WebElement findElementByXpath(String locater) {
        element = driver.findElement(By.xpath(locater));
        return element;
    }

    public WebElement findElementByClassName(String locater) {
        element = driver.findElement(By.className(locater));
        return element;
    }

    public boolean verifyElementExistsById(String locater) {
        try {
            element = driver.findElement(By.id(locater));
            if (element.isDisplayed()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean verifyElementExistsByClassName(String locater) {
        try {
            element = driver.findElement(By.className(locater));
            if (element.isDisplayed()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public int findElementCountByXpath(String locater) {
        List<WebElement> elements = driver.findElements(By.xpath(locater));
        return (elements.size());
    }

    public void scrollElementIntoViewByClassName(String className) {
        WebElement elementToScrollTo = driver.findElement(By.className(className));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToScrollTo);
        actions.perform();
    }

    public void takeScreenshot(String errorDescription) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String fileDate = new SimpleDateFormat("yyyy_MM_dd_HHmmss").format(new Date());
        File DestFile = new File("src\\test\\java\\Screenshots\\FailedTests\\" + errorDescription + "_" + fileDate + "_" + ".png");
        FileUtils.copyFile(scrFile, DestFile);
        scrFile.delete();
    }

    public WebDriver allowAccessToDriver() {
        return driver;
    }

}
