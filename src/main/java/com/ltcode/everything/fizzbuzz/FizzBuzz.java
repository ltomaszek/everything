package com.ltcode.everything.fizzbuzz;

/**
 * 1 -> "1"
 * 2 -> "2"
 * %3 -> "Fizz"
 * %5 -> "Buzz"
 * %3 & %5 -> "FizzBuzz"
 */
public interface FizzBuzz {

    String[] getOutput(int upTo);
}
