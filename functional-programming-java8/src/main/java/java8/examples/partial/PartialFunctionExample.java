package java8.examples.partial;

import io.vavr.Function2;
import io.vavr.control.Option;

public class PartialFunctionExample {

    public static void main(String[] args) {
        divideByZero();
        sumPositiveNumbers();
    }

    private static void divideByZero() {
        Function2<Integer, Integer, Integer> divide = (a, b) -> a / b;
        divide.apply(1, 0);

        Function2<Integer, Integer, Option<Integer>> safeDivide = Function2.lift(divide);

        // = None
        Option<Integer> i1 = safeDivide.apply(1, 0);
        System.out.println(i1);

        // = Some(2)
        Option<Integer> i2 = safeDivide.apply(4, 2);
        System.out.println(i2);
    }

    private static int sum(int first, int second) {
        if (first < 0 || second < 0) {
            throw new IllegalArgumentException("Only positive integers are allowed");
        }
        return first + second;
    }

    private static void sumPositiveNumbers() {
        Function2<Integer, Integer, Option<Integer>> sum = Function2.lift(PartialFunctionExample::sum);
        // = None
        Option<Integer> optionalResult = sum.apply(-1, 2);
        System.out.println(optionalResult);
    }

}
