package Pages;

import SharedComponents.Helper;
import Variables.PLTVariables;
import Variables.PLTVariables;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Checkout {

    Helper helper = new Helper();

    public void verifyCheckoutPage() {
        Assert.assertTrue(helper.verifyElementExistsByClassName("checkout-steps__container"));
    }

    public void submitEmail(String email) {
        helper.findElementById("customer-email").sendKeys(email);
    }

    public void verifyPasswordFieldIsDisplayed() {
        Assert.assertTrue(helper.verifyElementExistsById("customer-password"));
    }

    public void submitPassword(String password) {
        helper.findElementById("customer-password").sendKeys(password);
    }

    public void clickContinue() {
        helper.findElementByXpath("//*[@type='submit']").click();
    }

    public void verifySubTotal() {

        WebElement subtotalElement = helper.findElementByXpath("//*[contains(@class,'bag__list')]/li[1]/span[2]");

        Assert.assertEquals(PLTVariables.subtotal, subtotalElement.getText(), "Price difference found between checkout and bag subtotals");
    }

    public void selectPayWithCard() {
        helper.scrollElementIntoViewByClassName("payment-methods-container");
        helper.findElementById("worldpay-container").click();
    }

    public void verifyFirstname(String firstname) {
        WebElement heyMessageElement = helper.findElementByXpath("//*[@class='payment-container']/section/div/div");
        Assert.assertTrue(heyMessageElement.getText().contains(firstname));
    }

    public void verifyPayByCard() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertTrue(helper.verifyElementExistsByClassName("worldpay-forms"));
    }
}
