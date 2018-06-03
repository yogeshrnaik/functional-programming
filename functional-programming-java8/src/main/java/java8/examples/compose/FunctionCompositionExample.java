package java8.examples.compose;

import java.util.function.Function;

public class FunctionCompositionExample {

    public static void main(String[] args) {
        System.out.println("********** doubleIt **********");
        Function<Integer, Integer> doubleIt = num -> num * 2;
        System.out.println(doubleIt.apply(10));

        System.out.println("********** tripleIt **********");
        Function<Integer, Integer> tripleIt = num -> num * 3;
        System.out.println(tripleIt.apply(10));

        System.out.println("********** sixTimes **********");
        Function<Integer, Integer> sixTimes = doubleIt.andThen(tripleIt);
        System.out.println(sixTimes.apply(10));

        System.out.println("********** compose half and addTwo **********");
        Function<Integer, Integer> half = num -> num / 2;
        System.out.println("half of 10 = " + half.apply(10));
        Function<Integer, Integer> addTwo = num -> num + 2;
        System.out.println("half.compose(addTwo) of 10 = " + half.compose(addTwo).apply(10));
        System.out.println("addTwo.compose(half) of 10 = " + addTwo.compose(half).apply(10));
    }
}
