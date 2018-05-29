package java8.examples.pure;

public class PureFunctionExamples {

    public static void main(String[] args) {
        int a = add(1, 2);
        int b = add(10, 20);

        int c = add(a, b);
        System.out.println(c);
    }

    public static int add(int x, int y) {
        return x + y;
    }
}