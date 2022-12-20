package com.cydeo.day12;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class P06_MethodSourceTest {




    @ParameterizedTest
    @MethodSource("getNames")
    public void test1(String name) {

        System.out.println("name = " + name);

    }


    public static List<String> getNames(){

        List<String> nameList= Arrays.asList("Kimberly","King","TJ","Bond");

        return nameList;

        /*
          - Can we read data from database
               - Create conn / run query / store them and feed Parameterized

          - Can we get data from 3rd party APIs (that we consume to get data and use into our API )
                - use Java knowledge + RestAssured

           - This makes method source more power than other

         */

    }
}
