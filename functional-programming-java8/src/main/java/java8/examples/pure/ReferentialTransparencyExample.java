package java8.examples.pure;

public class ReferentialTransparencyExample {

    public static void main(String[] args) {
        final int a = add(1 + 1, 2);
        final int b = add(10, 20);

        final int c = add(a, b);
        System.out.println(c);

        System.out.println(add(a, b));

        System.out.println(add(add(1 + 1, 2), add(10, 20)));

        System.out.println(add(4, add(10, 20)));
        System.out.println(add(4, 30));
        System.out.println(34);
    }

    public static int add(int x, int y) {
        return x + y;
    }
}