package com.cydeo.day09;

import com.cydeo.utilities.SpartanAuthTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class P01_SpartanXMLTest extends SpartanAuthTestBase {

    /**
     * Given accept type is application/xml
     * When send the request /api/spartans
     * Then status code is 200
     * And content type is application/xml
     *   print firstname
     *   .....
     *   ...
     */


    @Test
    public void test1() {

        given().accept(ContentType.XML)
                .auth().basic("admin","admin").
        when().get("/api/spartans").prettyPeek().
        then().statusCode(200)
                .contentType(ContentType.XML)
                .body("List.item[0].name",is("John Dan"))
                .body("List.item[0].gender",is("Male"));


    }




   @DisplayName("GET /api/spartans with using XMLPath")
    @Test
    public void test2() {

       Response response = given().accept(ContentType.XML)
               .auth().basic("admin", "admin").
               when().get("/api/spartans");


   }
}
