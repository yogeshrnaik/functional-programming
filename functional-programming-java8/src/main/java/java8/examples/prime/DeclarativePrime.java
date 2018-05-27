package java8.examples.prime;

import java.util.stream.IntStream;

public class DeclarativePrime {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(String.format("isPrime(%d) -> %s", i, isPrime(i)));
        }
    }

    public static boolean isPrime(int number) {
        return (number != 1) &&
            IntStream.rangeClosed(2, (int)Math.sqrt(number))
                .noneMatch(i -> number % i == 0);
    }
}
