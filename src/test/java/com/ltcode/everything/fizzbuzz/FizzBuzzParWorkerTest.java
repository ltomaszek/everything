package com.ltcode.everything.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzParWorkerTest extends FizzBuzzTest {

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzzParWorker();
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