package com.myproject.application.task1_selenium;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    @FindBy(xpath = "//table[@class='table table-bordered']//img[@class='img-thumbnail']")
    private static WebElement selectedProductDisplayedShoppingCart;

    /**
     * Actions on OpencartPage
     */
    public static void myAccountClick() {
        myAccount.click();
    }

    public static void myAccountLogin() {
        myAccountLogin.click();
    }

    public static void setEmail() {
        email.sendKeys("bob.bob@gmail.com");
    }

    public static void setPassword() {
        password.sendKeys("bobbob");
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
        assertTrue(selectedProductDisplayedShoppingCart.isDisplayed());
    }

}
