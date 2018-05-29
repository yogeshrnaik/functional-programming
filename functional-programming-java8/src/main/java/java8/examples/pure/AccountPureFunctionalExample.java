package java8.examples.pure;

public class AccountPureFunctionalExample {

    public static void main(String[] args) {
        Account acc = new Account(1000);
        System.out.println(acc.balance);
        acc.deposit(500);
        System.out.println(acc.balance);

        System.out.println("******************** Pure Function ***************** ");
        AccountPure currAcct = new AccountPure(1000);
        Account newAccState = currAcct.deposit(500);
        System.out.println(currAcct.balance);
        System.out.println(newAccState.balance);
    }
}

class Account {

    double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double deposit(double amount) {
        // state changes hence not pure
        balance += amount;
        return balance;
    }

}

class AccountPure {

    double balance;

    public AccountPure(double balance) {
        this.balance = balance;
    }

    public Account deposit(double amount) {
        // state of Account object is not changed. we create Account with new balance
        return new Account(balance + amount);
    }
}
