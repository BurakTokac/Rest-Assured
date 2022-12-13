package com.cydeo.day08;

import com.cydeo.utilities.SpartanAuthTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class P01_SpartanAuthTest extends SpartanAuthTestBase {

    @DisplayName("GET /api/spartans as GUEST user --> EXPECT --> 401 ")
    @Test
    public void test1() {
        // it is Negative Test Case
        given().accept(ContentType.JSON).
        when().get("/api/spartans").
        then().log().ifValidationFails().statusCode(401)
                .body("error",is("Unauthorized"));

    }


    @DisplayName("GET /api/spartans as USER  --> EXPECT --> 200 ")
    @Test
    public void test2() {

        given().accept(ContentType.JSON).log().all()
                .auth().basic("user","user"). // This is the to send basic auth credentials through REST ASSURED
                when().get("/api/spartans").prettyPeek().
                then().log().ifValidationFails().statusCode(200);

    }

}
