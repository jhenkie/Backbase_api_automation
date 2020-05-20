package com.factory.cucumber.pages;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class LoginPage extends Function{
    public String credential(String email, String password) {
        String credential = "{\n" +
                "  \"user\":{\n" +
                "    \"email\": \""+email+"\",\n" +
                "    \"password\": \""+password+"\"\n" +
                "  }\n" +
                "}";
        return credential;
    }

    public void loginValidCredentialChecking() {
        Response resp =
                given()
                        .contentType(ContentType.JSON).header("Authorization","Basic Y2FuZGlkYXRleDpxYS1pcy1jb29s").body(credential(readFromFile(),"jhenkie"))
                        .when()
                        .post("https://qa-task.backbasecloud.com/api/users/login");

        JsonPath js = resp.jsonPath();

        assertValue("code",String.valueOf(resp.getStatusCode()),"200");
        assertValue("value",js.get("user.username"),readFromFile().substring(0,readFromFile().indexOf('@')));
        assertValue("value",js.get("user.email"),readFromFile());

        System.setProperty("token","Token "+js.get("user.token"));
    }

    public void loginValidCredential() {
        Response resp =
                        given()
                                .contentType(ContentType.JSON).header("Authorization","Basic Y2FuZGlkYXRleDpxYS1pcy1jb29s").body(credential(readFromFile(),"jhenkie"))
                        .when()
                                .post("https://qa-task.backbasecloud.com/api/users/login");

        JsonPath js = resp.jsonPath();
        System.setProperty("token","Token "+js.get("user.token"));
    }

    public void loginInvalidCredential(String email, String password) {
        Response resp =
                        given()
                                .contentType(ContentType.JSON).header("Authorization","Basic Y2FuZGlkYXRleDpxYS1pcy1jb29s").body(credential(email,password))
                        .when()
                                .post("https://qa-task.backbasecloud.com/api/users/login");

        JsonPath js = resp.jsonPath();

        assertValue("code",String.valueOf(resp.getStatusCode()),"422");
        assertValue("value",js.get("errors.\"email or password\""),"is invalid");
    }
}
