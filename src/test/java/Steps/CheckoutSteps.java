package Steps;

import Pages.Checkout;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CheckoutSteps {

    @Then("the password field is displayed")
    public void thePasswordFieldIsDisplayed() {
        Checkout checkout = new Checkout();
        checkout.verifyPasswordFieldIsDisplayed();
    }

    @Then("The firstname {string} is displayed in the hey message on the checkout screen")
    public void theFirstnameXIsDisplayedInTheHeyMessageOnTheCheckoutScreen(String firstname) {
        Checkout checkout = new Checkout();
        checkout.verifyFirstname(firstname);
    }

    @Then("the bag subtotal and the checkout subtotal are the same")
    public void theBagSubtotalAndTheCheckoutSubtotalAreTheSame() {
        Checkout checkout = new Checkout();
        checkout.verifySubTotal();
    }

    @Then("the pay by card window is displayed")
    public void thePayByCardWindowIsDisplayed() throws InterruptedException {
        Checkout checkout = new Checkout();
        checkout.verifyPayByCard();
    }

    @And("I select the payment method {string}")
    public void iSelectThePaymentMethodPayWithCard(String paymentMethod) throws InterruptedException {
        switch (paymentMethod.toLowerCase()) {
            case "pay with card":
                Checkout checkout = new Checkout();
                checkout.selectPayWithCard();
                break;
        }
    }

    @And("I supply the {string} {string}")
    public void iSupplyTheXY(String field, String value) {
        Checkout checkout = new Checkout();
        switch (field.toLowerCase()) {
            case "email":
                checkout.submitEmail(value);
                checkout.clickContinue();
                break;
            case "password":
                checkout.submitPassword(value);
                checkout.clickContinue();
                break;
        }

    }
}
