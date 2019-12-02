package com.myproject.application.task1_selenium;

import com.myproject.application.task1_selenium.OpencartPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestProductIsDisplay {
    OpencartPage opencartPage;

    @Given("^User is on the OpenCart page$")
    public void loginOnOpencart() throws Exception {
        opencartPage = new OpencartPage();
        opencartPage.initialisePage();
    }

    @When("^Login on OpenCart$")
    public void loginOnOpenCarts() throws Exception {
        opencartPage.myAccountClick();
        opencartPage.myAccountLogin();
        opencartPage.setEmail();
        opencartPage.setPassword();
        opencartPage.loginSubmit();
    }

    @And("^Add product to cart$")
    public void addProductToCart() throws Exception {
        opencartPage.selectTabletsCategory();
        opencartPage.selectSamsungGalaxy();
        opencartPage.addToCart();
    }

    @Then("^Check product is in cart$")
    public void checkProductIsInCart() {
        opencartPage.getShoppingCart();
        opencartPage.selectedProductDisplayedShoppingCart();
    }

}