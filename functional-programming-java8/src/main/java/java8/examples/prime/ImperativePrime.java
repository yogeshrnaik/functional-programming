package java8.examples.prime;

public class ImperativePrime {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(String.format("isPrime(%d) -> %s", i, isPrime(i)));
        }
    }

    public static boolean isPrime(int number) {
        if (number == 1)
            return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
