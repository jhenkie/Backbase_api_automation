package com.factory.cucumber.stepdefinitions;

import com.factory.cucumber.pages.UserPage;
import cucumber.api.java.en.Then;

public class UserStepDefinition {
    UserPage userPage = new UserPage();

    @Then("^User verify updated detail$")
    public void userVerifyUpdatedDetail() {
        userPage.updatedData();
    }

    @Then("^User verify detail data$")
    public void userVerifyDetailData() {
        userPage.verifyData();
    }

    @Then("^User verify profile$")
    public void userVerifyProfile() {
        userPage.verifyProfile();
    }
}
