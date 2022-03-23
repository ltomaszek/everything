package com.ltcode.everything.fizzbuzz;

public class FizzBuzzSeq extends FizzBuzzAbstractImpl {

    @Override
    protected void computeOutput() {
        for (int i = 0; i < output.length; i++) {
            int num = i+1;
            output[i] = numToOutput(num);
        }
    }
}
