package java8.examples.lazy;

import java.util.function.Supplier;

public class LazyEvaluationExample {

    public static void main(String[] args) {
        System.out.println(product(true, 10 / 0));

        System.out.println(lazyProduct(true, () -> 10 / 0));
        System.out.println(lazyProduct(false, () -> 10 / 0));
    }

    private static int product(boolean flag, int num) {
        return flag ? 100 : 5 * num;
    }

    private static int lazyProduct(boolean flag, Supplier<Integer> num) {
        return flag ? 100 : 5 * num.get();
    }
}
