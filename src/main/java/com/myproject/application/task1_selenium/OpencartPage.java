package com.myproject.application.task1_selenium;

import cucumber.api.java.After;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OpencartPage {

    /**
     * Initialize Page
     */

    private static final String URL = "https://demo.opencart.com";

    public static void initialisePage() {
        Driver.getDriver().get(URL);
        PageFactory.initElements(Driver.getDriver(), OpencartPage.class);
    }

    @After
    public void after() throws Exception {
        Thread.sleep(5000);
        Driver.getDriver().quit();
    }

    /**
     * Find all elements by Xpath
     */

    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    private static WebElement myAccount;

    @FindBy(xpath = "//a[contains(text(),'Login')]")
    private static WebElement myAccountLogin;

    @FindBy(xpath = "//input[@id='input-email']")
    private static WebElement email;

    @FindBy(xpath = "//input[@id='input-password']")
    private static WebElement password;

    @FindBy(xpath = "//input[@class='btn btn-primary']")
    private static WebElement loginSubmit;

    @FindBy(xpath = "//a[contains(text(),'Tablets')]")
    private static WebElement selectTabletsCategory;

    @FindBy(xpath = "//div[@class='image']//img[@class='img-responsive']")
    private static WebElement selectSamsungGalaxy;

    @FindBy(xpath = "//button[@id='button-cart']")
    private static WebElement addToCart;

    @FindBy(xpath = "//span[contains(text(),'Shopping Cart')]")
    private static WebElement getShoppingCart;

    @FindBy(xpath = "//span[@id='cart-total']")
    private static WebElement shoppingCartTotal;

    @FindBy(xpath = "//table[@class='table table-bordered']//a[contains(text(),'Samsung Galaxy Tab 10.1')]")
    private static WebElement SamsungGalaxyTabDisplayedInShoppingCart;

    @FindBy(xpath = "//table[@class='table table-bordered']//a[contains(text(),'iPhone')]")
    private static WebElement IphoneDisplayedInShoppingCart;

    @FindBy(xpath = "//i[@class='fa fa-times-circle']")
    private static WebElement removeCartItems;

    @FindBy(xpath = "//p[@class='text-center']")
    private static WebElement emptyShoppingCart;

    @FindBy(xpath = "//a[contains(text(),'Phones & PDAs')]")
    private static WebElement selectPhonesPDAsCategory;

    @FindBy(xpath = "//body//div[@class='row']//div[@class='row']//div[2]//div[1]//div[1]//a[1]//img[1]")
    private static WebElement selectIphone;

 //   @FindBy(xpath = "")

    /**
     * Actions on OpencartPage
     */
    public static void myAccountClick() {
        myAccount.click();
    }

    public static void myAccountLogin() {
        myAccountLogin.click();
    }

    public static void setEmail(String testCredentials) {
        email.sendKeys(testCredentials);
    }

    public static void setPassword(String testCredentials) {
        password.sendKeys(testCredentials);
    }

    public static void loginSubmit() {
        loginSubmit.click();
    }

    public static void selectTabletsCategory() {
        selectTabletsCategory.click();
    }

    public static void selectSamsungGalaxy  () {
        selectSamsungGalaxy.click();
    }

    public static void addToCart() {
        addToCart.click();
    }

    public static void getShoppingCart() {
        getShoppingCart.click();
    }

    public static void selectedProductDisplayedShoppingCart() {
        assertTrue(SamsungGalaxyTabDisplayedInShoppingCart.isDisplayed()); }

    public static void selectedItemsDisplayedShoppingCart() {
        assertTrue(SamsungGalaxyTabDisplayedInShoppingCart.isDisplayed() && IphoneDisplayedInShoppingCart.isDisplayed());
    }

    public static void removeCartItems(){ removeCartItems.click();}

    public static void shoppingCartTotal(){ shoppingCartTotal.click();}

    public static void verifyIfCartIsEmpty() {
        assertTrue(emptyShoppingCart.isDisplayed());
    }
    public static void valideRemovedItem() {
        assertFalse(SamsungGalaxyTabDisplayedInShoppingCart.isDisplayed() && !IphoneDisplayedInShoppingCart.isDisplayed());
    }
    public static void selectPhonesPDAsCategory() {
        selectPhonesPDAsCategory.click();
    }
    public static void selectIphone() {
        selectIphone.click();
    }
}




