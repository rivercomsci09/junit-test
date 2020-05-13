package com.river.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    @Test
    void testAdd(){
        MathUtils mathUtils = new MathUtils();
        int expectd = 2;
        int actual = mathUtils.add(1,1);
        assertEquals(expectd,actual,"The add method should add two numbers");
    }

    @Test
    void testDivide(){
        MathUtils mathUtils = new MathUtils();
        assertThrows(NullPointerException.class, () -> mathUtils.divide(1,0), "Divide by zero should throw");
    }

    @Test
    void testComputeCircleArea(){
        MathUtils mathUtils = new MathUtils();
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Shoud return ...");
    }
}
