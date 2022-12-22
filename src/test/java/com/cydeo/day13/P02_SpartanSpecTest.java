package com.cydeo.day13;

import com.cydeo.utilities.SpartanNewTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;

import javax.swing.text.AbstractDocument;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class P02_SpartanSpecTest extends SpartanNewTestBase {

    @Test
    public void getAllSpartans() {

        given().log().all().accept(ContentType.JSON)
                .auth().basic("admin","admin").
        when().get("/spartans").
        then().
                statusCode(200)
                .contentType(ContentType.JSON);

    }

    @Test
    public void getAllSpartansWithReqResSpec() {

        given().spec(reqSpec).
        when().get("/spartans").
        then().spec(resSpec);

    }


    @Test
    public void getSingleSpartansWithReqResSpec() {


                given().spec(reqSpec).
                        pathParam("id",3).
                when().get("/spartans/{id}").prettyPeek().
                then().spec(resSpec)
                        .body("id",is(3));

    }

    @Test
    public void getSingleSpartanAsUser(){

        given().spec(dynamicReqSpec("user","user"))
                .pathParam("id",3).
        when().get("/spartans/{id}").prettyPeek().
        then().spec(dynamicResSpec(200));

    }


    /**
     *  Create GET_RBAC.csv
     *   username,password,id,statuscode
     *    admin,admin,3,200
     *    editor,editor,3,200
     *    user,user,3,200
     *
     *  Create a parameterized test to check RBAC for GET method
     *
     *
     */

    /**
     *  Create DELETE_RBAC.csv
     *   username,password,id,statuscode
     *
     *    editor,editor,3,403
     *    user,user,3,403
     *    admin,admin,3,204
     *
     *  Create a parameterized test to check RBAC for GET method
     *
     *
     */





}
