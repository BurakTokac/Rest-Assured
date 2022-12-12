package com.cydeo.day07;

import com.cydeo.utilities.SpartanTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
public class P02_SpartanPOST extends SpartanTestBase {

    /**
     Given accept type and Content type is JSON
     And request json body is:
     {
     "gender":"Male",
     "name":"John Doe",
     "phone":8877445596
     }
     When user sends POST request to '/api/spartans'
     Then status code 201
     And content type should be application/json
     And json payload/response/body should contain:
     verify the success value is A Spartan is Born!
     "name": "John Doe",
     "gender": "Male",
     "phone": 1231231231
     */
    @DisplayName("POST spartan with String body")
    @Test
    public void test1() {
    }
}
