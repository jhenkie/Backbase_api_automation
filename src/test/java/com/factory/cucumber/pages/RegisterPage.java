package com.factory.cucumber.pages;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RegisterPage extends Function{
    public String data(String username, String email, String password) {
        String data = "{\n" +
                "  \"user\":{\n" +
                "    \"username\": \""+username+"\",\n" +
                "    \"email\": \""+email+"\",\n" +
                "    \"password\": \""+password+"\"\n" +
                "  }\n" +
                "}";
        return data;
    }

    public void registerEmptyData() {
        Response resp =
                        given()
                                .contentType(ContentType.JSON).header("Authorization","Basic Y2FuZGlkYXRleDpxYS1pcy1jb29s").body(data("", "", ""))
                        .when()
                                .post("https://qa-task.backbasecloud.com/api/users");

        JsonPath js = resp.jsonPath();

        assertValue("code",String.valueOf(resp.getStatusCode()),"422");
        assertValue("value",js.get("errors.username"),"can't be blank");
        assertValue("value",js.get("errors.email"),"can't be blank");

    }

    public void registerExistedData() {
        Response resp =
                        given()
                                .contentType(ContentType.JSON).header("Authorization","Basic Y2FuZGlkYXRleDpxYS1pcy1jb29s").body(data("jhenkie1", "jhenkie1@gmail.com", ""))
                        .when()
                                .post("https://qa-task.backbasecloud.com/api/users");

        JsonPath js = resp.jsonPath();

        assertValue("code",String.valueOf(resp.getStatusCode()),"422");
        assertValue("value",js.get("errors.username"),"is already taken.");
        assertValue("value",js.get("errors.email"),"is already taken.");
    }

    public void registerData() {
        increaseEmailNumber();
        Response resp =
                        given()
                        .contentType(ContentType.JSON).header("Authorization","Basic Y2FuZGlkYXRleDpxYS1pcy1jb29s").body(data(readFromFile().substring(0,readFromFile().indexOf('@')), readFromFile(), "jhenkie"))
                        .when()
                        .post("https://qa-task.backbasecloud.com/api/users");

        JsonPath js = resp.jsonPath();

        assertValue("code",String.valueOf(resp.getStatusCode()),"200");
        assertValue("value",js.get("user.username"),readFromFile().substring(0,readFromFile().indexOf('@')));
        assertValue("value",js.get("user.email"),readFromFile());
    }
}
