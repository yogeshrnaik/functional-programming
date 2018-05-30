package java8.examples.stream;

import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {
        Stream<Integer> nums = Stream.of(1, 1, 1, 4, 5, 6);

        Stream<Integer> evens = nums.filter(StreamExamples::isEven);
        // Optional<Integer> firstEven = evens.findFirst();
    }

    private static boolean isEven(int i) {
        System.out.println(String.format("Checking if %d is even", i));
        return i % 2 == 0;
    }
}
