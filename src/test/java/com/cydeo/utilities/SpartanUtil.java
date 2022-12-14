package com.cydeo.utilities;

import com.cydeo.pojo.Spartan;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SpartanUtil {


    public static Spartan createSpartan() {
        Spartan spartan=new Spartan();
        Faker faker=new Faker();
        spartan.setName(faker.name().firstName());
        //"1234545363463"                  method is giving me the String then I need to convert into te long
        spartan.setPhone(Long.parseLong(faker.numerify("###########")));

        int i = faker.number().numberBetween(0, 1);
        if (i==0){
            spartan.setGender("Female");
        }else {
            spartan.setGender("Male");
        }

        return spartan;
    }

    public static Response postSpartan(Spartan spartan) {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(spartan)
                .when()
                .post("/api/spartans");
        return response;


    }
}
