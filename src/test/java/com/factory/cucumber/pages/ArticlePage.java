package com.factory.cucumber.pages;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ArticlePage extends Function{
    LoginPage loginPage = new LoginPage();

    public ArticlePage() {
        loginPage.loginValidCredential();
    }

    public String credential(String title, String desc, String body, String tag) {
        String credential = "{\n" +
                "  \"article\": {\n" +
                "    \"title\": \""+title+"\",\n" +
                "    \"description\": \""+desc+"\",\n" +
                "    \"body\": \""+body+"\",\n" +
                "    \"tagList\": \""+tag+"\"" +
                "  }\n" +
                "}";
        return credential;
    }

    public void createArticle() {
        Response resp =
                        given()
                                .contentType(ContentType.JSON).header("Authorization","Basic Y2FuZGlkYXRleDpxYS1pcy1jb29s")
                                .header("jwtauthorization",System.getProperty("token"))
                                .body(credential("How to survive during corona pandemic","Survival tips","Keep the distance and stay safe. Together we strong","virus"))
                        .when()
                                .post("https://qa-task.backbasecloud.com/api/articles");

        JsonPath js = resp.jsonPath();

        assertValue("code",String.valueOf(resp.getStatusCode()),"200");
        assertValue("value",js.get("article.title"),"How to survive during corona pandemic");
        assertValue("value",js.get("article.description"),"Survival tips");
        assertValue("value",js.get("article.body"),"Keep the distance and stay safe. Together we strong");

        List<ArrayList> list = new ArrayList<>();
        list.add(js.get("article.tagList"));
        assertValue("value",String.valueOf(list.get(0)),"[virus]");

        System.setProperty("slug",js.get("article.slug"));
    }

    public void seeArticle() {
        Response resp =
                        given()
                                .contentType(ContentType.JSON).header("Authorization","Basic Y2FuZGlkYXRleDpxYS1pcy1jb29s")
                        .when()
                                .get("https://qa-task.backbasecloud.com/api/articles/"+System.getProperty("slug"));

        JsonPath js = resp.jsonPath();

        assertValue("code",String.valueOf(resp.getStatusCode()),"200");
        assertValue("value",js.get("article.title"),"How to survive during corona pandemic");
    }

    public void updateArticle() {
        Response resp =
                        given()
                                .contentType(ContentType.JSON).header("Authorization","Basic Y2FuZGlkYXRleDpxYS1pcy1jb29s")
                                .header("jwtauthorization",System.getProperty("token"))
                                .body(credential("I change the title","","",""))
                        .when()
                                .put("https://qa-task.backbasecloud.com/api/articles/"+System.getProperty("slug"));

        JsonPath js = resp.jsonPath();

        assertValue("code",String.valueOf(resp.getStatusCode()),"200");
        assertValue("value",js.get("article.title"),"I change the title");
    }

    public void deleteArticle() {
        Response resp =
                        given()
                                .contentType(ContentType.JSON).header("Authorization","Basic Y2FuZGlkYXRleDpxYS1pcy1jb29s")
                                .header("jwtauthorization",System.getProperty("token"))
                        .when()
                                .delete("https://qa-task.backbasecloud.com/api/articles/"+System.getProperty("slug"));

        assertValue("code",String.valueOf(resp.getStatusCode()),"204");
    }

}
