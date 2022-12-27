package com.cydeo.day15;

import com.cydeo.pojo.Spartan;
import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class  P02_SpartanMock extends SpartanTestBase {

    // https://4c678f45-0fdd-416e-b62d-bc4b94705f56.mock.pstmn.io

    /*

    @BeforeAll
    public static void init(){

        baseURI="https://4c678f45-0fdd-416e-b62d-bc4b94705f56.mock.pstmn.io";
    }

     */



    @DisplayName("GET /api/hello")
    @Test
    public void test() {

        Response response = given().log().all()
                .accept(ContentType.TEXT).
                when().get("/api/hello").prettyPeek()
                .then().statusCode(200).extract().response();

        // Hello from Sparta
        Assertions.assertEquals("Hello from Sparta",response.asString());

        //log.info("GET /api/hello");

    }


    @DisplayName("GET /api/spartans")
    @Test
    public void test1() {

        given().accept(ContentType.JSON).
        when().get("/api/spartans").prettyPeek()
                .then().statusCode(200)
                .body("id",everyItem(notNullValue()))
                .contentType(ContentType.JSON);

        //log.info("GET /api/spartans");
        // check status code
        // check each spartan has id


    }


    @DisplayName("POST /api/spartans")
    @Test
    public void test2() {
        Map<String,Object> spartanPost=new HashMap<>();
        spartanPost.put("name","Mike Smith");
        spartanPost.put("gender","Male");
        spartanPost.put("phone",8877445596l);

        given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(spartanPost).
        when().post("/api/spartans").prettyPeek().then()
                .statusCode(201)
                .body("data.id",notNullValue());


        // check data.id has notnullvalue
        // check success message is A Spartan is Born!

    }


}
