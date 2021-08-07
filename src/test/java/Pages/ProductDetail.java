package Pages;

import SharedComponents.Helper;
import SharedComponents.Tests;
import Variables.PLTVariables;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class ProductDetail {

    Helper helper = new Helper();

    public void verifyPageHeader() {
        if (PLTVariables.navPage.toLowerCase().equals("beauty")) {
            Assert.assertTrue(helper.verifyElementExistsById("beauty-school"));
        } else if (PLTVariables.navPage.toLowerCase().equals("the edit")) {
            Assert.assertTrue(helper.verifyElementExistsById("the-edit"));
        } else {
            WebElement headerElement = helper.findElementByXpath("//*[@class='category-description std']/h1");
            Assert.assertTrue(headerElement.getText().toLowerCase().contains(PLTVariables.navPage.toLowerCase()));
        }
    }

    public void selectProductByName(String productName) throws IOException {

        boolean itemFound = false;
        String productXpath = "//*[@class='product-page']/div";

        int productCount = helper.findElementCountByXpath(productXpath);

        for (int i = 1; i <= productCount; i++) {
            WebElement productElement = helper.findElementByXpath(productXpath + "[" + i + "]");

            if (productElement.getAttribute("data-productname").toLowerCase().equals(productName.toLowerCase())) {
                itemFound = true;
                productElement.click();
                PLTVariables.productName = productName;
                break;
            }
        }

        if (itemFound == false) {
            Tests tests = new Tests();
            tests.ThrowAssertionError("ProductNotFound_" + productName);
        }
    }
}
