package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pageObject.CheckoutPage;
import org.example.pageObject.InventoryPage;
import org.example.pageObject.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PurchaseSteps {
    private final WebDriver driver = Hooks.driver;
    LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @Then("User click shopping cart badge")
    public void UserClickCartButton() throws InterruptedException {
        checkoutPage.clickCartButton();
        Thread.sleep(3000);
    }

    @And("User remove Sauce Labs Bike Light from shopping cart")
    public void userRemoveFromShoppingCart() {
        checkoutPage.clickRemoveSauceLabs();
    }

    @And("user click Checkout button")
    public void userClickCheckoutButton() {
        checkoutPage.clickCheckoutButton();
    }

    @Then("User redirected to Checkout Step One page")
    public void userRedirectedToCheckoutStepOnePage() {
        Assert.assertTrue(checkoutPage.verifyCheckoutStepone());
    }

    @And("User input {string} as Firstname {string} as Lastname {string} as Zipcode")
    public void userInputAsFirstnameAsLastnameAsZipcode(String firstName, String lastName, String zipCode) {
        checkoutPage.inputFirstName(firstName, lastName, zipCode);
    }

    @And("User click Continue button")
    public void userClickContinueButton() {
        checkoutPage.clickContinueButton();
    }

    @Then("User redirected to Checkout Step Two page")
    public void userRedirectedToCheckoutStepTwoPage() {
        String expected = "Total: $8.63";
        String actual = checkoutPage.verifySummaryTotal();
        Assert.assertEquals(expected, actual);
    }

    @And("User click Finish button")
    public void userClickFinishButton() {
        checkoutPage.clickFinishButton();
    }

    @Then("User redirected to Checkout Complete page")
    public void userRedirectedToCheckoutCompletePage() {
        Assert.assertTrue(checkoutPage.verifyCheckoutComplete());
    }
}
