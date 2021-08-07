package Pages;

import SharedComponents.Helper;
import org.testng.Assert;

public class Bag {

    Helper helper = new Helper();

    public void verifyBagPage() {
        Assert.assertTrue(helper.verifyElementExistsByClassName("cart") || helper.verifyElementExistsByClassName("cart-empty"));
    }

    public void clickProceedToCheckout() {
        helper.findElementByXpath("//*[contains(@class,'btn-proceed--checkout')]").click();
    }

    public String returnSubTotal() {
        return helper.findElementByXpath("//*[@class='cart-summary-total']/p/span").getText();
    }

}
