package ru.volsu.qa;

import java.lang.Math;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.volsu.qa.models.Post;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTests {

private String token;
//////Позитивные
    @BeforeClass
    public void beforeClass() {
        RestAssured.baseURI = "https://gorest.co.in";
       RestAssured.port = 443;
        token="?access-token=oPa_kpfb6A0yhvGdL2p39q7vhgfoTYtWV9d2";
    }

    @DataProvider(name = "testGetUsers_Data")
    public Object[][] testGetUsers_Data()
    {
        return  new Object[][]{
                {"Jane"},
                {"Neva"},
                {"Jonh"}};
    }
    @DataProvider(name = "testGetUsersUserId_Data")
    public Object[][] testGetUsersUserId_Data()
    {
        return  new Object[][]{
                {"1451"},
                {"1452"},
                {"1453"}};
    }
    @DataProvider(name = "testPostUsers_Data")
    public Object[][] testPostUsers_Data()
    {
        return  new Object[][]{
            {"Salam", "Salam", "female", "1970-01-01", Math.random()+"@example.com", "+1 (903) 946-1126"},
    //            {"Salam", "Salam", "female", "1970-01-01", "n1b8rr@example.com", "+1 (903) 946-1126"},
    //            {"Salam", "Salam", "female", "1970-01-01", "n1b8rr@example.com", "+1 (903) 946-1126"}
        };
}

    @Test
    public void testGetUsers() {

        given()
                .log().all()
        .when()
                .request("GET", "public-api/users"+token)
        .then()
                .log().all()
                .statusCode(200);
        System.out.println("////////////////////////////////////////////");
    }

    @Test(dataProvider = "testGetUsers_Data")
    public void testGetUsersFirstName(String first_name) {

        given()
                .log().all()
        .when()
                .request("GET", "/public-api/users"+token+"&first_name="+first_name)
        .then()
                .log().all()
                .statusCode(200);
        System.out.println("////////////////////////////////////////////");
    }
    @Test(dataProvider = "testGetUsersUserId_Data")
    public void testGetUsersUserId(String id) {

        given()
                .log().all()
        .when()
                .request("GET", "/public-api/users/"+id+token)
        .then()
                .log().all()
                .statusCode(200);
        System.out.println("////////////////////////////////////////////");
    }


    @Test(dataProvider = "testPostUsers_Data")
    public void testPostUsers( String first_name, String last_name, String gender, String dob, String email, String phone) {
        Post newPost = new Post( first_name, last_name,gender, dob, email, phone);
        given().auth().oauth2("oPa_kpfb6A0yhvGdL2p39q7vhgfoTYtWV9d2")
                .log().all()
                .contentType(ContentType.JSON)
                .body(newPost)
        .when()
                .post( "/public-api/users")
        .then()
                .log().all()
                .assertThat()
                .body("result.first_name", equalTo(newPost.getFirst_name()))
                .body("result.last_name", equalTo(newPost.getLast_name()))
                .body("result.gender", equalTo(newPost.getGender()))
                .body("result.dob", equalTo(newPost.getDob()))
                .body("result.email", equalTo(newPost.getEmail()))
                .body("result.phone", equalTo(newPost.getPhone()))
                 .statusCode(302);
    }

    @Test(dataProvider = "testPostUsers_Data")
    public void testPutUsersUserId(String first_name, String last_name, String gender, String dob, String email, String phone ) {
        Post newPost = new Post( first_name, last_name,gender, dob, email, phone);
        int id =1451;
        given().auth().oauth2("oPa_kpfb6A0yhvGdL2p39q7vhgfoTYtWV9d2")

                .log().all()
                .contentType(ContentType.JSON)
                .body(newPost)
        .when()
                .put( "/public-api/users/"+id)
        .then()
                .log().all()
                .assertThat()
                .body("result.first_name", equalTo(newPost.getFirst_name()))
                .body("result.last_name", equalTo(newPost.getLast_name()))
                .body("result.gender", equalTo(newPost.getGender()))
                .body("result.dob", equalTo(newPost.getDob()))
                .body("result.email", equalTo(newPost.getEmail()))
                .body("result.phone", equalTo(newPost.getPhone()))
                 .statusCode(200);
    }

    @Test()
    public void testDeleteUsersUserId() {
        int id =1468;
        given().auth().oauth2("oPa_kpfb6A0yhvGdL2p39q7vhgfoTYtWV9d2")
         .log().all()
         .contentType(ContentType.JSON)

        .when()
                .delete( "/public-api/users/"+id)
        .then()
            .log().all()
            .body("result", equalTo(null))
            .statusCode(200);
    }


}
