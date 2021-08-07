package Pages;

import SharedComponents.Helper;
import SharedComponents.Tests;
import Variables.PLTVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.IOException;

public class Home {

    Helper helper = new Helper();
    Tests tests = new Tests();

    public void ClickOnCookiesBanner(String buttonName) throws IOException {
        buttonName = buttonName.toLowerCase();

        if (buttonName.equals("more info")) {
            helper.findElementByXpath("//*[contains(@class,'cookie-preference__more button')]").click();
        } else if (buttonName.equals("accept all")) {
            helper.findElementByXpath("//*[contains(@class,'cookie-preference__accept button')]").click();
        } else {
            tests.ThrowAssertionError("CookieButtonNotFound_" + buttonName);
        }
    }

    public void clickOnNavMenuItem(String menuItem) throws IOException {
        boolean menuItemFound = false;
        String navXpath = "//*[contains(@id,'primary-navigation')]/li";
        int navItemCount = (helper.findElementCountByXpath(navXpath));

        for (int i = 1; i <= navItemCount; i++) {
            WebElement navItemElement = helper.findElementByXpath(navXpath + "[" + i + "]");

            if (navItemElement.getText().equals(menuItem.toUpperCase())) {
                navItemElement.click();
                menuItemFound = true;
                PLTVariables.navPage = menuItem;
                break;
            }
        }

        if (menuItemFound == false) {
            tests.ThrowAssertionError("NavItemNotFound_" + menuItem);
        }
    }

    public int checkBagQuantity() {
        if (helper.findElementById("shopping-bag-text").getText().equals("")) {
            return 0;
        } else {
            return Integer.parseInt(helper.findElementById("shopping-bag-text").getText());
        }
    }

    public void clickBag() {
        helper.findElementByClassName("mini-cart").click();
    }

    public void verifyItemIsAddedToBag() {
        WebDriver driver = helper.allowAccessToDriver();

        WebElement bagElement = helper.findElementById("topcart");

        Actions builder = new Actions(driver);
        builder.moveToElement(bagElement).perform();
        //   By locator = By.xpath("//*[contains(@class,'item last')]/a/div/p");
        //   Assert.assertEquals(PLTVariables.productName, driver.findElement(locator).getText());
        Assert.assertEquals(PLTVariables.productName, helper.findElementByXpath("//*[contains(@class,'item last')]/a/div/p").getText());
    }

}
