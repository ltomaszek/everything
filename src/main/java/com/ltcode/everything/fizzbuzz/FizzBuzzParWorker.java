package com.ltcode.everything.fizzbuzz;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/**
 * Very Slow and NOT Efficient FizzBuzz parallel version (much slower than sequential version) using ReentrantLock and Threads
 * Use for testing purpose only
 */
public class FizzBuzzParWorker extends FizzBuzzAbstractImpl {

    ReentrantLock lock = new ReentrantLock();
    Integer currentNumber = 1;
    /** For logging purpose */
    AtomicInteger failedToLock = new AtomicInteger(0);

    @Override
    protected void computeOutput() {
        FizzBuzzWorker fizzWorker = new FizzBuzzWorker(n -> n % 3 == 0 && n % 5 != 0);
        FizzBuzzWorker buzzWorker = new FizzBuzzWorker(n -> n % 3 != 0 && n % 5 == 0);
        FizzBuzzWorker fizzBuzzWorker = new FizzBuzzWorker(n -> n % 3 == 0 && n % 5 == 0);
        FizzBuzzWorker numberWorker = new FizzBuzzWorker(n -> n % 3 != 0 && n % 5 != 0);

        var fizzThread = new Thread(fizzWorker);
        var buzzThread = new Thread(buzzWorker);
        var fizzBuzzThread = new Thread(fizzBuzzWorker);
        var numberThread = new Thread(numberWorker);

        fizzThread.start();
        buzzThread.start();
        fizzBuzzThread.start();
        numberThread.start();

        try {
            fizzThread.join();
            buzzThread.join();
            fizzBuzzThread.join();
            numberThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class FizzBuzzWorker implements Runnable {

        final Predicate<Integer> doTaskPredicate;

        public FizzBuzzWorker(Predicate<Integer> doTaskPredicate) {
            this.doTaskPredicate = doTaskPredicate;
        }

        @Override
        public void run() {
            while (currentNumber <= output.length) {
                if (lock.tryLock()) {
                    if (doTaskPredicate.test(currentNumber)) {
                        //System.out.println(Thread.currentThread().getId() + " doing number: " + numToOutput(currentNumber));
                        output[currentNumber - 1] = numToOutput(currentNumber);
                        currentNumber++;
                    }
                    lock.unlock();
                } else {
                    failedToLock.incrementAndGet();
                }
            }
        }
    }
}
