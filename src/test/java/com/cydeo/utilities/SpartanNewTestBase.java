package com.cydeo.utilities;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;
public abstract class SpartanNewTestBase {


    @BeforeAll
    public static void init(){

        baseURI="http://44.212.37.188";
        port = 7000;
        basePath="/api";
        // baseURI+port+basePath
    }
}
