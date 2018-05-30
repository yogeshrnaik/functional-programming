package java8.examples.higherorder;

import java.util.function.Function;

public class HigherOrderFunctionExample {

    public static void main(String[] args) {
        applyFunction("square", 10, num -> num * num);
        applyFunction("factorial", 5, num -> factorial(num));
    }

    private static int factorial(int num) {
        return (num == 0 || num == 1) ? 1 : num * factorial(num - 1);
    }

    public static void applyFunction(String funcDesc, int num, Function<Integer, Integer> func) {
        System.out.println(String.format("%s of %d is %d", funcDesc, num, func.apply(num)));
    }
}
