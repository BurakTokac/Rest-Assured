package com.cydeo.day08;

import com.cydeo.utilities.BookitTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
public class P02_BookITTest extends BookitTestBase {

    String accessToken="Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTMxMiIsImF1ZCI6InN0dWRlbnQtdGVhbS1sZWFkZXIifQ.ZIHJuDh19eLga3bLP7udnvNtEA0DM_W1H67ah2Zu3Lc";

    @DisplayName("GET /api/campuses ")
    @Test
    public void test1() {

        given().accept(ContentType.JSON)
                .header("Authorization",accessToken).
        when().get("/api/campuses").prettyPeek()
                .then().statusCode(200);


    }
}
