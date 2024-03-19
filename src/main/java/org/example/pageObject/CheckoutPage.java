package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    public static WebDriver webDriver;

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//div[@id='shopping_cart_container']/a[1]")
    private WebElement cartButton;

    public void clickCartButton() {
        cartButton.click();
    }

    @FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']")
    private WebElement removeSauceLabs;

    public void clickRemoveSauceLabs() {
        removeSauceLabs.click();
    }

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutButton;

    public void clickCheckoutButton() {
        checkoutButton.click();
    }
    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstNameField;
    public void inputFirstName(String inputFirstName,String inputLastName,String inputZipCode){
        firstNameField.sendKeys(inputFirstName);
        lastNameField.sendKeys(inputLastName);
        zipCodeField.sendKeys(inputZipCode);
    }
    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastNameField;
    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement zipCodeField;
    public boolean verifyCheckoutStepone(){
        boolean a = firstNameField.isDisplayed();
        boolean b = lastNameField.isDisplayed();
        boolean c = zipCodeField.isDisplayed();
        return a && b && c;
    }
    public String verifySummaryTotal(){
        return summaryTotal.getText();
    }
    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;
    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    private WebElement summaryTotal;
    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishButton;
    public void clickFinishButton(){
        finishButton.click();
    }
    @FindBy(xpath = "//img[@alt='Pony Express']")
    private WebElement thankYou;
    public void clickContinueButton(){
        continueButton.click();
    }
    public boolean verifyCheckoutComplete(){
        return thankYou.isDisplayed();
    }
}
