package com.cydeo.day15;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class P02_SpartanMock {

    // https://4c678f45-0fdd-416e-b62d-bc4b94705f56.mock.pstmn.io

    @DisplayName("GET /api/hello")
    @Test
    public void test() {

        Response response = given().log().all()
                .accept(ContentType.TEXT).
                when().get("/api/hello").prettyPeek()
                .then().statusCode(200).extract().response();


    }
}
