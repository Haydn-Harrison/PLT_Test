package Pages;

import SharedComponents.Helper;
import SharedComponents.Tests;
import Variables.PLTVariables;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class ProductInformation {

    Helper helper = new Helper();

    public void selectSize(String productSize) throws IOException {

        boolean itemFound = false;
        String sizeXpath = "//*[@class='plt-box size-options js-selectsize']/div/div";

        int sizeCount = helper.findElementCountByXpath(sizeXpath);

        for (int i = 1; i <= sizeCount; i++) {
            WebElement sizeElement = helper.findElementByXpath(sizeXpath + "[" + i + "]");

            if (sizeElement.getText().equals(productSize)) {
                itemFound = true;
                sizeElement.click();
                PLTVariables.selectedSize = productSize;
                break;
            }
        }

        if (itemFound == false) {
            Tests tests = new Tests();
            tests.ThrowAssertionError("SizeNotFound_" + productSize);
        }
    }

    public void verifyBackgroundColourOfSize(String rgbaColour) {
        String sizeXpath = "//*[@class='plt-box size-options js-selectsize']/div/div";

        int sizeCount = helper.findElementCountByXpath(sizeXpath);

        for (int i = 1; i <= sizeCount; i++) {
            WebElement sizeElement = helper.findElementByXpath(sizeXpath + "[" + i + "]");

            if (sizeElement.getText().equals(PLTVariables.selectedSize)) {
                Assert.assertEquals(sizeElement.getCssValue("background-color"), rgbaColour);
                break;
            }
        }
    }

    public void clickAddToBag() throws InterruptedException {
        Home home = new Home();
        helper.findElementById("add-to-bag").click();
        PLTVariables.currentBagCount = PLTVariables.currentBagCount + 1;
    }


    public void verifyProductHeader() {
        WebElement productHeaderElement = helper.findElementByClassName("product-view-title");
        Assert.assertTrue(productHeaderElement.getText().toLowerCase().equals(PLTVariables.productName.toLowerCase()));
    }
}
