package Steps;

import Pages.Bag;
import Variables.PLTVariables;
import io.cucumber.java.en.And;

public class BagSteps {

    @And("I click proceed to checkout")
    public void iClickProceedToCheckout() {
        Bag bag = new Bag();
        PLTVariables.subtotal = bag.returnSubTotal();
        bag.clickProceedToCheckout();
    }
}
