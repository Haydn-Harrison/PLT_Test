package Steps;

import Pages.ProductDetail;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class PDPSteps {
    ProductDetail productDetail = new ProductDetail();

    @Then("the PDP is opened")
    public void thePDPIsOpened() {
        productDetail.verifyPageHeader();
    }

    @And("I choose the product {string}")
    public void iChooseTheProduct(String productName) throws IOException {
        productDetail.selectProductByName(productName);
    }
}
