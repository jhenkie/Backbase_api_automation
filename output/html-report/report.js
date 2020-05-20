$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Article.feature");
formatter.feature({
  "line": 2,
  "name": "Article API",
  "description": "",
  "id": "article-api",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@regression"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "create new article",
  "description": "",
  "id": "article-api;create-new-article",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "User verify created article",
  "keyword": "Then "
});
formatter.match({
  "location": "ArticleStepDefinition.userVerifyCreatedArticle()"
});
formatter.result({
  "duration": 7065787880,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "see article",
  "description": "",
  "id": "article-api;see-article",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "User verify article",
  "keyword": "Then "
});
formatter.match({
  "location": "ArticleStepDefinition.userVerifyArticle()"
});
formatter.result({
  "duration": 663365366,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "update article",
  "description": "",
  "id": "article-api;update-article",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "User verify update article",
  "keyword": "Then "
});
formatter.match({
  "location": "ArticleStepDefinition.userVerifyUpdateArticle()"
});
formatter.result({
  "duration": 638036531,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "delete article",
  "description": "",
  "id": "article-api;delete-article",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "User verify deleted article",
  "keyword": "Then "
});
formatter.match({
  "location": "ArticleStepDefinition.userVerifyDeletedArticle()"
});
formatter.result({
  "duration": 601572866,
  "status": "passed"
});
formatter.uri("Login.feature");
formatter.feature({
  "line": 2,
  "name": "Login API",
  "description": "",
  "id": "login-api",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@regression"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "Login with valid credential",
  "description": "",
  "id": "login-api;login-with-valid-credential",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "User verify with valid credentials",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinition.user_verify_with_valid_credentials()"
});
formatter.result({
  "duration": 368073554,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Login with invalid credential",
  "description": "",
  "id": "login-api;login-with-invalid-credential",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "User verify with invalid credentials \"random@gmail.com\" \"random\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "random@gmail.com",
      "offset": 38
    },
    {
      "val": "random",
      "offset": 57
    }
  ],
  "location": "LoginStepDefinition.userVerifyWithInvalidCredentials(String,String)"
});
formatter.result({
  "duration": 304334056,
  "status": "passed"
});
formatter.uri("Register.feature");
formatter.feature({
  "line": 2,
  "name": "Register API",
  "description": "",
  "id": "register-api",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@regression"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "Register without data",
  "description": "",
  "id": "register-api;register-without-data",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "User verify error empty data",
  "keyword": "Then "
});
formatter.match({
  "location": "RegisterStepDefinition.userVerifyErrorEmptyData()"
});
formatter.result({
  "duration": 354258979,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Register with existed data",
  "description": "",
  "id": "register-api;register-with-existed-data",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "User verify error existed data",
  "keyword": "Then "
});
formatter.match({
  "location": "RegisterStepDefinition.userVerifyErrorExistedData()"
});
formatter.result({
  "duration": 359225583,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Register with data",
  "description": "",
  "id": "register-api;register-with-data",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "User verify successful create user",
  "keyword": "Then "
});
formatter.match({
  "location": "RegisterStepDefinition.userVerifySuccessfulCreateUser()"
});
formatter.result({
  "duration": 364150247,
  "status": "passed"
});
formatter.uri("User.feature");
formatter.feature({
  "line": 2,
  "name": "User API",
  "description": "",
  "id": "user-api",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@regression"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "update user detail",
  "description": "",
  "id": "user-api;update-user-detail",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "User verify updated detail",
  "keyword": "Then "
});
formatter.match({
  "location": "UserStepDefinition.userVerifyUpdatedDetail()"
});
formatter.result({
  "duration": 598048506,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "See user detail",
  "description": "",
  "id": "user-api;see-user-detail",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "User verify detail data",
  "keyword": "Then "
});
formatter.match({
  "location": "UserStepDefinition.userVerifyDetailData()"
});
formatter.result({
  "duration": 632480450,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "see profile",
  "description": "",
  "id": "user-api;see-profile",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "User verify profile",
  "keyword": "Then "
});
formatter.match({
  "location": "UserStepDefinition.userVerifyProfile()"
});
formatter.result({
  "duration": 590291995,
  "status": "passed"
});
});