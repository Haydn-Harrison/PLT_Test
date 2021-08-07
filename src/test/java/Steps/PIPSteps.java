package Steps;

import Pages.ProductInformation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class PIPSteps {
    @When("I add the product {string} in size {string} to my bag")
    public void iAddTheProductYInSizeXToMyBag(String productName, String productSize) throws IOException, InterruptedException {
        PDPSteps pdpSteps = new PDPSteps();
        pdpSteps.iChooseTheProduct(productName);
        iPickTheSize(productSize);
        ProductInformation productInformation = new ProductInformation();
        productInformation.clickAddToBag();
    }

    @Then("the PIP is opened")
    public void thePIPIsOpened() {
        ProductInformation productInformation = new ProductInformation();
        productInformation.verifyProductHeader();
    }

    @Then("the background colour of the size icon changes to {string}")
    public void theBackgroundColourOfTheSizeIconChangesToRgba(String rgbaColour) {
        ProductInformation productInformation = new ProductInformation();
        productInformation.verifyBackgroundColourOfSize(rgbaColour);
    }

    @And("I pick the size {string}")
    public void iPickTheSize(String productSize) throws IOException {
        ProductInformation productInformation = new ProductInformation();
        productInformation.selectSize(productSize);
    }
}
