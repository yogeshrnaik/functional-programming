package java8.examples.curry;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class CurryingExample {

    public static void main(String[] args) {
        simpleCurrying();

        System.out.println("********** Complex currying **********");
        Function<Integer, Function<Integer, Integer>> curriedWith10AsFirstParam = addThenSubtractFunction().apply(10);
        Function<Integer, Integer> curriedWith20AsSecondParam = curriedWith10AsFirstParam.apply(20);
        System.out.println(curriedWith20AsSecondParam.apply(5));
    }

    private static void simpleCurrying() {
        // Create a function that adds 2 integers
        BiFunction<Integer, Integer, Integer> adder = (a, b) -> a + b;

        // And a function that takes an integer and returns a function
        Function<Integer, Function<Integer, Integer>> currier = a -> b -> adder.apply(a, b);

        // Call apply 4 to currier (to get a function back)
        Function<Integer, Integer> curriedToAdd4 = currier.apply(4);

        // Call apply 10 to currier (to get a function back)
        Function<Integer, Integer> curriedToAdd10 = currier.apply(10);

        System.out.printf("Curry : %d\n", curriedToAdd4.apply(3)); // ( 4 + 3 )
        System.out.printf("Curry : %d\n", curriedToAdd4.apply(10)); // ( 4 + 10 )

        System.out.printf("Curry : %d\n", curriedToAdd10.apply(3)); // ( 10 + 3 )
        System.out.printf("Curry : %d\n", curriedToAdd10.apply(5)); // ( 10 + 5 )

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(nums.stream().map(curriedToAdd4).collect(toList()));
        System.out.println(nums.stream().map(curriedToAdd10).collect(toList()));
    }

    private static int addThenSubtract(int first, int second, int third) {
        return first + second - third;
    }

    private static Function<Integer, Function<Integer, Function<Integer, Integer>>> addThenSubtractFunction() {
        return (first) -> (second) -> (third) -> first + second - third;

    }
}
