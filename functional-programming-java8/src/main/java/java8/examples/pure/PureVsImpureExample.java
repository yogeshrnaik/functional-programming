package java8.examples.pure;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PureVsImpureExample {

    private static final int INTEREST_RATE = 10;

    public static void main(String[] args) {
        new PureVsImpureExample().add_1(10, 20);
    }

    public List<Integer> doubleIt_1(List<Integer> nums) {
        List<Integer> doubles = new ArrayList<>();
        for (Integer i : nums) {
            doubles.add(i * 2);
        }
        nums.clear();
        nums.addAll(doubles);
        return nums;
    }

    public List<Integer> doubleIt_2(List<Integer> nums) {
        List<Integer> doubles = new ArrayList<>();
        for (Integer i : nums) {
            doubles.add(i * 2);
        }
        return doubles;
    }

    public List<Integer> doubleIt_3(List<Integer> nums) {
        return nums.stream().map(i -> i * 2).collect(Collectors.toList());
    }

    public int add_1(int a, int b) {
        System.out.printf("Adding %d and %d", a, b);
        return a + b;
    }

    public int add_2(int a, int b) {
        return a + b;
    }

    public double calcInterest_1(int principal) {
        return principal * INTEREST_RATE / 100;
    }

    public double calcInterest_2(int principal, int interestRate) {
        return principal * interestRate / 100;
    }
}
