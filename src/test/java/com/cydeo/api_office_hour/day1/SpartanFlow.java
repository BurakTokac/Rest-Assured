package com.cydeo.api_office_hour.day1;

import com.cydeo.pojo.Spartan;
import com.cydeo.utilities.SpartanTestBase;
import com.cydeo.utilities.SpartanUtil;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpartanFlow extends SpartanTestBase {

    /*

   - POST     /api/spartans
            Create a spartan Map
                name = "API Flow POST"
                gender="Male"
                phone=1231231231l

            - verify status code 201
            - message is "A Spartan is Born!"
            - take spartanID from response and save as a global variable

     */
    static int createdSpartanId;
  static   String createdSpartanName;

    @Order(value = 1)
    @Test
    void post() {
        Spartan spartan = SpartanUtil.createSpartan();
        Response response = SpartanUtil.postSpartan(spartan);
        Assertions.assertEquals(201, response.statusCode());
        Assertions.assertEquals("A Spartan is Born!", response.jsonPath().getString("success"));
        createdSpartanName = spartan.getName();
        createdSpartanId = response.jsonPath().getInt("data.id");

    }

    /*
    - GET  Spartan with spartanID     /api/spartans/{id}


                 - verify status code 200
                 - verfiy name is API Flow POST
     */
    @Order(value = 2)
    @Test
    void getCreatedSpartan() {
        Response response = SpartanUtil.getSpartan(createdSpartanId);
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(createdSpartanName, response.jsonPath().getString("name"));

    }


    /*
    - PUT  Spartan with spartanID    /api/spartans/{id}

             Create a spartan Map
                name = "API PUT Flow"
                gender="Female"
                phone=3213213213l

             - verify status code 204
     */

    @Test
    void put() {
        Spartan updatedSpartan=new Spartan();


        SpartanUtil.updateSpartan(createdSpartanId,updatedSpartan);





    }
}
