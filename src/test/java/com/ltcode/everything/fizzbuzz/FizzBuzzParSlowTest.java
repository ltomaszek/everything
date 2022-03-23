package com.ltcode.everything.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FizzBuzzParSlowTest extends FizzBuzzTest {

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzzParSlow();
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