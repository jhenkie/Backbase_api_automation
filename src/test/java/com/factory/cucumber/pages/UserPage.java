package com.factory.cucumber.pages;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserPage extends Function{
    LoginPage loginPage = new LoginPage();

    public UserPage() {
        loginPage.loginValidCredential();
    }

    public String credential(String bio) {
        String credential = "{\n" +
                "  \"user\":{\n" +
                "    \"bio\": \""+bio+"\"\n" +
                "  }\n" +
                "}";
        return credential;
    }

    public void updatedData() {
        Response resp =
                        given()
                                .contentType(ContentType.JSON).header("Authorization","Basic Y2FuZGlkYXRleDpxYS1pcy1jb29s")
                                .header("jwtauthorization",System.getProperty("token"))
                                .body(credential("Qa-is-cool"))
                        .when()
                                .put("https://qa-task.backbasecloud.com/api/user");

        JsonPath js = resp.jsonPath();

        assertValue("code",String.valueOf(resp.getStatusCode()),"200");
        assertValue("value",js.get("user.bio"),"Qa-is-cool");
    }

    public void verifyData() {
        Response resp =
                        given()
                                .contentType(ContentType.JSON).header("Authorization","Basic Y2FuZGlkYXRleDpxYS1pcy1jb29s")
                                .header("jwtauthorization",System.getProperty("token"))
                        .when()
                                .get("https://qa-task.backbasecloud.com/api/user");

        JsonPath js = resp.jsonPath();

        assertValue("code",String.valueOf(resp.getStatusCode()),"200");
        assertValue("value",js.get("user.username"),readFromFile().substring(0,readFromFile().indexOf('@')));
        assertValue("value",js.get("user.email"),readFromFile());
        assertValue("value",js.get("user.bio"),"Qa-is-cool");
    }

    public void verifyProfile() {
        Response resp =
                        given()
                                .contentType(ContentType.JSON).header("Authorization","Basic Y2FuZGlkYXRleDpxYS1pcy1jb29s")
                        .when()
                                .get("https://qa-task.backbasecloud.com/api/profiles/alextest555");

        JsonPath js = resp.jsonPath();

        assertValue("code",String.valueOf(resp.getStatusCode()),"200");
        assertValue("value",js.get("profile.username"),"alextest555");
    }
}
