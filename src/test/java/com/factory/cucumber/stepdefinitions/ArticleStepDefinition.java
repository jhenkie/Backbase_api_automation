package com.factory.cucumber.stepdefinitions;

import com.factory.cucumber.pages.ArticlePage;
import cucumber.api.java.en.Then;

public class ArticleStepDefinition {
    ArticlePage articlePage = new ArticlePage();

    @Then("^User verify created article$")
    public void userVerifyCreatedArticle() {
        articlePage.createArticle();
    }

    @Then("^User verify article$")
    public void userVerifyArticle() {
        articlePage.seeArticle();
    }

    @Then("^User verify update article$")
    public void userVerifyUpdateArticle() {
        articlePage.updateArticle();
    }

    @Then("^User verify deleted article$")
    public void userVerifyDeletedArticle() {
        articlePage.deleteArticle();
    }
}
