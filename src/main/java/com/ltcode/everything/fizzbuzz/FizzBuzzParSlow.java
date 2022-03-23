package com.ltcode.everything.fizzbuzz;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Slow FizzBuzz parallel version (slower than sequential version)
 * Use for testing purpose only
 */
public class FizzBuzzParSlow extends FizzBuzzAbstractImpl {

    @Override
    protected void computeOutput() {
        FizzBuzzFiller fizzFiller = new FizzBuzzFiller(2, 3, 3, output, n -> n%5 != 0, n -> "Fizz");
        FizzBuzzFiller buzzFiller = new FizzBuzzFiller(4, 5, 5, output, n -> n%3 != 0, n -> "Buzz");
        FizzBuzzFiller fizzBuzzFiller = new FizzBuzzFiller(14, 15, 15, output, n -> true, n -> "FizzBuzz");
        FizzBuzzFiller numFiller = new FizzBuzzFiller(0, 1, 1, output, n -> (n%3 != 0) && (n%5 != 0), n -> "" + n);

        Thread fizzThread = new Thread(fizzFiller);
        Thread buzzThread = new Thread(buzzFiller);
        Thread fizzBuzzThread = new Thread(fizzBuzzFiller);
        Thread numFillerThread = new Thread(numFiller);

        fizzThread.start();
        buzzThread.start();
        fizzBuzzThread.start();
        numFillerThread.start();

        try {
            fizzThread.join();
            buzzThread.join();
            fizzBuzzThread.join();
            numFillerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class FizzBuzzFiller implements Runnable {

        final int startArrayIdx;
        final int startNumber;
        final int step;
        final String[] array;
        final Predicate<Integer> outputPredicate;
        final Function<Integer, String> outputFunction;

        public FizzBuzzFiller(int startArrayIdx, int startNumber, int step, String[] array, Predicate<Integer> outputPredicate, Function<Integer, String> outputFunction) {
            this.startArrayIdx = startArrayIdx;
            this.startNumber = startNumber;
            this.step = step;
            this.array = array;
            this.outputPredicate = outputPredicate;
            this.outputFunction = outputFunction;
        }

        @Override
        public void run() {
            for (int i = startArrayIdx, num = startNumber; i < array.length; i += step, num += step) {
                if (outputPredicate.test(num)) {
                    array[i] = outputFunction.apply(num);
                }
            }
        }
    }
}
