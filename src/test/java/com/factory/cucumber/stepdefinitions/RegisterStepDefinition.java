package com.factory.cucumber.stepdefinitions;

import com.factory.cucumber.pages.RegisterPage;
import cucumber.api.java.en.Then;

public class RegisterStepDefinition {
    RegisterPage registerPage = new RegisterPage();

    @Then("User verify error empty data")
    public void userVerifyErrorEmptyData() {
        registerPage.registerEmptyData();
    }

    @Then("User verify successful create user")
    public void userVerifySuccessfulCreateUser() {
        registerPage.registerData();
    }

    @Then("User verify error existed data")
    public void userVerifyErrorExistedData() {
        registerPage.registerExistedData();
    }
}