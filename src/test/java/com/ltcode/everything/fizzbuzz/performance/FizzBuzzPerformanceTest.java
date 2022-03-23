package com.ltcode.everything.fizzbuzz.performance;

import com.ltcode.everything.fizzbuzz.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FizzBuzzPerformanceTest {

    FizzBuzz seqFizzBuzz;
    FizzBuzz slowParFizzBuzz;
    FizzBuzz fastParFizzBuzz;
    FizzBuzz workerParFizzBuzz;

    @BeforeEach
    void setUp() {
        seqFizzBuzz = new FizzBuzzSeq();
        slowParFizzBuzz = new FizzBuzzParSlow();
        fastParFizzBuzz = new FizzBuzzParFast();
        workerParFizzBuzz = new FizzBuzzParWorker();
    }

    @ParameterizedTest
    @ValueSource(ints = {1_000, 1_000_000, 10_000_000})
    void test(final int UP_TO) {
        System.out.println("FizzBuzz performance test N= " + UP_TO);
        final long seqTime = getRunningTime(() -> seqFizzBuzz.getOutput(UP_TO));
        System.out.println("Seq time=        " + seqTime);

        final long slowParTime = getRunningTime(() -> slowParFizzBuzz.getOutput(UP_TO));
        System.out.println("Slow par time=   " + slowParTime);

        final long fastParTime = getRunningTime(() -> fastParFizzBuzz.getOutput(UP_TO));
        System.out.println("Fast par time=   " + fastParTime);

        /** TO SLOW TO TEST for bigger N */
        if (UP_TO <= 10_000) {
            final long workerParTime = getRunningTime(() -> workerParFizzBuzz.getOutput(UP_TO));
            System.out.println("Worker par time= " + workerParTime);
        }

        // expected speed difference > 1.5
        double difference = (double) seqTime / fastParTime;
        assertTrue(difference > 1.5, () -> "Expected speed improvement difference smaller than 1.5");
    }

    long getRunningTime(Runnable runnable) {
        long timeStart = System.currentTimeMillis();
        runnable.run();
        return System.currentTimeMillis() - timeStart;
    }
}
