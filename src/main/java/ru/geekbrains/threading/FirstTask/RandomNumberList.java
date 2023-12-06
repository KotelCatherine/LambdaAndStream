package ru.geekbrains.threading.FirstTask;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class RandomNumberList {
    private static final List<Integer> randomNum = Stream.generate(() -> ThreadLocalRandom.current().nextInt(1_000_000))
            .limit(1000)
            .toList();

    public RandomNumberList() {
        max();
        mathOperation();
        numberCounter();
    }

    private void numberCounter() {
        long numCounter = randomNum.stream()
                .filter(it -> it * it < 100_000)
                .count();

        System.out.println("The number of numbers is less than 100_000: " + numCounter);
    }

    private void mathOperation() {
        long multiplyMinusSum = randomNum.stream()
                .filter(it -> it > 500_000)
                .mapToLong(it -> it * 5L - 150)
                .sum();

        System.out.println("All numbers greater than 500_000 are multiplied by 5, subtracted by 150 and summed: " + multiplyMinusSum);
    }

    private void max() {
        int maxNum = randomNum.stream()
                .max(Integer::compareTo)
                .get();

        System.out.println("Maximum number: " + maxNum);
    }
}
