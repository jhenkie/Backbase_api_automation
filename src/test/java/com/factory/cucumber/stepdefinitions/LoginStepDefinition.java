package com.factory.cucumber.stepdefinitions;

import com.factory.cucumber.pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

public class LoginStepDefinition {
    LoginPage loginPage = new LoginPage();

    @Then("^User verify with valid credentials$")
    public void user_verify_with_valid_credentials() {
        loginPage.loginValidCredentialChecking();
    }

    @Then("^User verify with invalid credentials \"([^\"]*)\" \"([^\"]*)\"$")
    public void userVerifyWithInvalidCredentials(String email, String password) {
        loginPage.loginInvalidCredential(email, password);
    }
}
