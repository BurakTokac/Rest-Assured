package com.cydeo.day12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class P03_ValueSourceTest {

    @ParameterizedTest
    @ValueSource(ints = {10,20,30,40,50} )
    public void test1(int number) {

        System.out.println(number);
        Assertions.assertTrue(number<40);

    }


    @ParameterizedTest
    @ValueSource(strings = {"Mike","Rose","Caberly","Kimberly","TJ","King"})
    public void test2(String name) {

        System.out.println("name = " + name);


    }
}
