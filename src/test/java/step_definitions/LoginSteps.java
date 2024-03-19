package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.InventoryPage;
import org.example.pageObject.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private final WebDriver driver = Hooks.driver;

    LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);

    @When("User input {string} as userName and {string} as password and click login")
    public void credential(String userName, String password){
        loginPage.inputFieldUserName(userName);
        loginPage.inputFieldPassword(password);
        loginPage.clickButtonLogin();
    }
    @Then("User already on dashboard page")
    public void userAlreadyOnDashboardPage() {
        Assert.assertTrue(inventoryPage.verifyLabelProduct());
    }

    @Given("User open the web sauce demo")
    public void userOpenTheWebSauceDemo() {
        Assert.assertTrue(loginPage.verifyLoginPage());
    }

    @Then("User see {string} as error text")
    public void userSeeAsErrorText(String text) {
        Assert.assertEquals(text, loginPage.getErrorMessage());
    }
}
