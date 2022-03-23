package com.ltcode.everything.fizzbuzz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FizzBuzzParFast extends FizzBuzzAbstractImpl {

    @Override
    protected void computeOutput() {
        final int WORKLOAD = output.length;
        final int CORES = Runtime.getRuntime().availableProcessors();

        if (CORES <= 2 || WORKLOAD < 2_000_000) {
            output = new FizzBuzzSeq().getOutput(output.length);
        } else {
            // min 1mln tasks pro core
            final int CORES_IN_USE = Math.min(WORKLOAD / 1_000_000, CORES - 1);
            final int WORKLOAD_PER_CORE = (output.length + CORES_IN_USE - 1) / CORES_IN_USE;
            ExecutorService executorService = Executors.newFixedThreadPool(CORES);

            for (int coreIdx = 0; coreIdx < CORES; coreIdx++) {
                int startIdx = coreIdx * WORKLOAD_PER_CORE;
                int endIdx = Math.min(startIdx + WORKLOAD_PER_CORE, output.length);

                executorService.execute(() -> compute(startIdx, endIdx));
            }

            executorService.shutdown();
            while(! executorService.isTerminated()) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void compute(int fromIdx, int toIdx) {
        int num;
        for (int i = fromIdx; i < toIdx; i = num) {
            num = i + 1;
            output[i] = numToOutput(num);
        }
    }
}
