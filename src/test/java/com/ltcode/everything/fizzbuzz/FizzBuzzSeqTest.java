package com.ltcode.everything.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzSeqTest extends FizzBuzzTest {

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzzSeq();
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