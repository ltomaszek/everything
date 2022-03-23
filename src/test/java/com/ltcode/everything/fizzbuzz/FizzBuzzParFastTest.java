package com.ltcode.everything.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzParFastTest extends FizzBuzzTest {

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzzParFast();
    }

    @Test
    @Override
    void getOutput_test1() {
        super.getOutput_test1();
    }

    @Test
    @Override
    void getOutput_test2() {
        super.getOutput_test2();
    }

}