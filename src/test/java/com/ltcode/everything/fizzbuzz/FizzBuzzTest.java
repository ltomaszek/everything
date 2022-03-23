package com.ltcode.everything.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static org.junit.jupiter.api.Assertions.*;

abstract class FizzBuzzTest {

    protected FizzBuzz fizzBuzz;

    @Test
    void getOutput_test1() {
        int UP_TO = 16;
        String[] output = fizzBuzz.getOutput(UP_TO);
        assertAll(
                () -> assertEquals("1", output[0]),
                () -> assertEquals("2", output[1]),
                () -> assertEquals("Fizz", output[2]),
                () -> assertEquals("4", output[3]),
                () -> assertEquals("Buzz", output[4]),
                () -> assertEquals("Fizz", output[5]),
                () -> assertEquals("7", output[6]),
                () -> assertEquals("8", output[7]),
                () -> assertEquals("Fizz", output[8]),
                () -> assertEquals("Buzz", output[9]),
                () -> assertEquals("11", output[10]),
                () -> assertEquals("Fizz", output[11]),
                () -> assertEquals("13", output[12]),
                () -> assertEquals("14", output[13]),
                () -> assertEquals("FizzBuzz", output[14]),
                () -> assertEquals("16", output[15]),
                () -> assertThrows(ArrayIndexOutOfBoundsException.class, () -> {System.out.println(output[16]);})
        );
    }

    @Test
    void getOutput_test2() {
        int UP_TO = 1_000;
        String[] output = fizzBuzz.getOutput(UP_TO);

        for (int i = 0; i < UP_TO; i++) {
            int num = i + 1;
            String expected;

            if (num % 3 == 0) {
                if (num % 5 == 0) {
                    expected = "FizzBuzz";
                } else {
                    expected = "Fizz";
                }
            } else if (num % 5 == 0) {
                expected = "Buzz";
            } else {
                expected = "" + num;
            }

            assertEquals(expected, output[i], String.format("For num=%d", num));
        }
    }
}