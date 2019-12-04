package com.myproject.application.task1_selenium;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static junit.framework.Assert.assertFalse;

public class OrderProductsStepDefinitions {
    OpencartPage opencartPage;

    @Given("^User is on the OpenCart page$")
    public void getOnOpencartWebsite() throws Exception {
        opencartPage = new OpencartPage();
        opencartPage.initialisePage();
    }

    @When("^Login on OpenCart$")
    public void loginOnOpenCart(DataTable dt) throws Exception {
        List<String> testCredentials = dt.asList(String.class);
        opencartPage.myAccountClick();
        opencartPage.myAccountLogin();
        opencartPage.setEmail(testCredentials.get(0));
        opencartPage.setPassword(testCredentials.get(1));
        opencartPage.loginSubmit();
    }

    @And("^Add product to cart$")
    public void addProductToCart() throws Exception {
        opencartPage.selectTabletsCategory();
        opencartPage.selectSamsungGalaxy();
        opencartPage.addToCart();
    }

    @And("^Add another product$")
    public void addAnotherProduct() throws Exception {
        opencartPage.selectPhonesPDAsCategory();
        opencartPage.selectIphone();
        opencartPage.addToCart();
    }

    @And("^Go to ShoppingCart$")
    public void goToShoppingCart() {
        opencartPage.getShoppingCart();
    }

    @Then("^Product added is displayed in the cart$")
    public void checkProductIsInCart() {
        opencartPage.selectedProductDisplayedShoppingCart();
    }

    @When("^Remove the product from cart$")
    public void removeCartItems() {
        opencartPage.removeCartItems();

    }

    @Then("^Shoppingcart is empty$")
    public void shoppingCartIsEmpty() throws Exception {
        opencartPage.shoppingCartTotal();
        opencartPage.verifyIfCartIsEmpty();
    }

    @Then("^Items added are displayed in the cart$")
    public void viewShoppingCartTotal(){
        opencartPage.getShoppingCart();
        opencartPage.selectedItemsDisplayedShoppingCart();
    }

    @Then("^Validate that removed item is missing from shopping cart$")
    public void valideRemovedItem(){
        opencartPage.validateRemovedItem();
    }
}