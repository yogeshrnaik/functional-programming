package java8.examples.prime;

import java.util.stream.IntStream;

public class DeclarativePrime {

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100)
            .filter(i -> isPrime(i))
            .forEach(i -> System.out.println(i));

        System.out.println("*******************************************");

        IntStream.rangeClosed(1, 100)
            .filter(DeclarativePrime::isPrime)
            .forEach(System.out::println);
    }

    public static boolean isPrime(int number) {
        return (number != 1) &&
            IntStream.rangeClosed(2, (int)Math.sqrt(number))
                .noneMatch(i -> number % i == 0);
    }
}
