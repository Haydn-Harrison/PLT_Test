package Steps;

import Pages.*;
import SharedComponents.Helper;
import Variables.PLTVariables;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class SharedSteps {

    Helper helper = new Helper();

    @Given("I am on the PLT homepage")
    public void i_am_on_the_plt_homepage() throws IOException {
        helper.open("https://www.prettylittlething.com/", "chrome");
        Home home = new Home();
        home.ClickOnCookiesBanner("accept all");
    }

    @Given("I am on the {string} page")
    public void iAmOnThePage(String pageName) throws IOException {
        i_am_on_the_plt_homepage();
        iSelectMenuItemInTheNavMenu(pageName);
    }

    @When("I select {string} in the nav menu")
    public void iSelectMenuItemInTheNavMenu(String menuItem) throws IOException {

        Home home = new Home();
        home.clickOnNavMenuItem(menuItem);
    }

    @When("I have a bag with the product {string} in size {string} opened")
    public void iHaveABagWithTheProductXInSizeYOpened(String productName, String productSize) throws IOException, InterruptedException {
        PIPSteps pipSteps = new PIPSteps();
        pipSteps.iAddTheProductYInSizeXToMyBag(productName, productSize);
        iClickOnTheBagButton();
    }

    @Then("the {string} page is opened")
    public void theXPageIsOpened(String pageName) {
        switch (pageName.toLowerCase()) {
            case "product detail":
                ProductDetail productDetail = new ProductDetail();
                productDetail.verifyPageHeader();
                break;
            case "product information":
                ProductInformation productInformation = new ProductInformation();
                productInformation.verifyProductHeader();
                break;
            case "bag":
                Bag bag = new Bag();
                bag.verifyBagPage();
                break;
            case "checkout":
                Checkout checkout = new Checkout();
                checkout.verifyCheckoutPage();
        }
    }

    @Then("the bag quantity is correct")
    public void theBagQuantityIsCorrect() throws InterruptedException {
        Home home = new Home();
        Thread.sleep(500);
        Assert.assertEquals(PLTVariables.currentBagCount, home.checkBagQuantity());
    }

    @And("the added item is visible at the bottom of the bag list")
    public void theAddedItemIsVisibleAtTheBottomOfTheBagList() {
        Home home = new Home();
        home.verifyItemIsAddedToBag();
    }

    @And("I click on the bag button")
    public void iClickOnTheBagButton() throws InterruptedException {
        Thread.sleep(500);
        Home home = new Home();
        home.clickBag();
    }

    @And("I click proceed to checkout and sign in with valid credentials")
    public void iClickProceedToCheckoutAndSignInWithValidCredentials() {
        BagSteps bagSteps = new BagSteps();
        bagSteps.iClickProceedToCheckout();
        CheckoutSteps checkoutSteps = new CheckoutSteps();
        checkoutSteps.iSupplyTheXY("Email", "plttesthaydn@gmail.com");
        checkoutSteps.iSupplyTheXY("Password", "Test123!");
    }

    @After
    public void afterScenario() {
        helper.closeBrowser();
    }

}
