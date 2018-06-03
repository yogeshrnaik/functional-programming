package java8.examples.higherorder;

import java.util.function.BiFunction;
import java.util.function.Function;

public class HigherOrderFunctionExample {

    public static void main(String[] args) {
        printSquare(10);
        printFactorial(5);

        applyFunction("square", 10, num -> num * num);
        applyFunction("factorial", 5, num -> factorial(num));

        applyFunction("addition", 5, 10, (Integer num1, Integer num2) -> num1 + num2);
        applyFunction("multiplication", 5, 10, (num1, num2) -> num1 * num2);

        genericApply("addition", 2, 3, (num1, num2) -> num1 + num2);
        genericApply("addition", 2.5f, 3.5f, (num1, num2) -> num1 + num2);

        genericApply("average age", new Employee("John", 25), new Employee("Jane", 30),
            (e1, e2) -> (e1.age + e2.age) / 2.0f);
    }

    private static void printSquare(int num) {
        System.out.println(String.format("square of %d is %d", num, num * num));
    }

    private static void printFactorial(int num) {
        System.out.println(String.format("factorial of %d is %d", num, factorial(num)));
    }

    private static int factorial(int num) {
        return (num == 0 || num == 1) ? 1 : num * factorial(num - 1);
    }

    public static void applyFunction(String funcDesc, int num, Function<Integer, Integer> func) {
        System.out.println(String.format("%s of %d is %d", funcDesc, num, func.apply(num)));
    }

    public static void applyFunction(String funcDesc, int num1, int num2, BiFunction<Integer, Integer, Integer> func) {
        System.out.println(String.format("%s of %d and %d is %d", funcDesc, num1, num2, func.apply(num1, num2)));
    }

    public static <T, R> void genericApply(String funcDesc, T t1, T t2, BiFunction<T, T, R> func) {
        System.out.println(String.format("%s of %s and %s is %s", funcDesc, t1, t2, func.apply(t1, t2)));
    }
}

class Employee {

    final String name;
    final int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + "]";
    }
}
