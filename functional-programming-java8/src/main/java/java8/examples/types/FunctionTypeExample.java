package java8.examples.types;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionTypeExample {

    public static void main(String[] args) {
        System.out.println("********** doubleIt **********");
        Function<Integer, Integer> doubleIt = num -> num * 2;
        System.out.println(doubleIt.apply(10));

        Supplier<Boolean> alwaysSayYes = () -> true;

        System.out.println("********** predicates **********");
        Function<String, Boolean> isJava = lang -> lang.startsWith("Java");
        System.out.println(isJava.apply("Java8"));
        Predicate<String> isJava8 = lang -> lang.equals("Java8");
        System.out.println(isJava8.test("Java8"));

        System.out.println("********** BiFunction **********");
        BiFunction<Integer, Integer, Integer> add = (num1, num2) -> num1 + num2;
        System.out.println(add.apply(10, 20));

        IntBinaryOperator addInts = (num1, num2) -> num1 + num2;
        System.out.println(addInts.applyAsInt(10, 20));

    }
}
