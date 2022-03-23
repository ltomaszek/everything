package com.ltcode.everything.fizzbuzz;

public abstract class FizzBuzzAbstractImpl implements FizzBuzz {

    protected String[] output;

    @Override
    public String[] getOutput(int upTo) {
        output = new String[upTo];
        computeOutput();
        return output;
    }

    protected abstract void computeOutput();

    protected String numToOutput(int num) {
        if (num % 3 == 0 && num % 5 == 0) {
            return "FizzBuzz";
        } else if (num % 3 == 0) {
            return "Fizz";
        } else if (num % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(num);
        }
    }
}
