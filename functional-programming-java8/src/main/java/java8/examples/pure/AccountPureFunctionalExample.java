package java8.examples.pure;

import io.vavr.control.Try;

public class AccountPureFunctionalExample {

    public static void main(String[] args) {
        impureDepositeExample();
        pureDepositExample();
        pureWithdrawExample();
    }

    private static void pureWithdrawExample() {
        System.out.println("******************** Pure Function - Withdraw ***************** ");
        AccountPure currAcct = new AccountPure(1000);
        // currAcct.withdraw(2000);

        Double balance = currAcct.tryWithdraw(2000)
            .map(AccountPure::getBalance)
            .getOrElseThrow(t -> new RuntimeException(t));
        System.out.println(balance);
    }

    private static void impureDepositeExample() {
        Account acc = new Account(1000);
        System.out.println(acc.balance);
        acc.deposit(500);
        System.out.println(acc.balance);
    }

    private static void pureDepositExample() {
        System.out.println("******************** Pure Function - Deposit ***************** ");
        AccountPure currAcct = new AccountPure(1000);
        AccountPure newAccState = currAcct.deposit(500);
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
        balance += amount;
        return balance;
    }
}

class AccountPure {

    double balance;

    public AccountPure(double balance) {
        this.balance = balance;
    }

    public AccountPure deposit(double amount) {
        // state of Account object is not changed. we create Account with new balance
        return new AccountPure(balance + amount);
    }

    public AccountPure withdraw(double amount) {
        if (balance - amount < 0)
            throw new InsufficientBalance(String.format("Cannot withdraw %.2f. Current balance: %.2f", amount, balance));
        return new AccountPure(balance - amount);
    }

    public Try<AccountPure> tryWithdraw(double amount) {
        if (balance - amount < 0)
            return Try.failure(new InsufficientBalance(String.format("Cannot withdraw %.2f. Current balance: %.2f", amount, balance)));
        return Try.success(new AccountPure(balance - amount));
    }

    public static double getBalance(AccountPure acc) {
        return acc.balance;
    }
}

class InsufficientBalance extends RuntimeException {

    private static final long serialVersionUID = -2106051575900723379L;

    public InsufficientBalance(String message) {
        super(message);
    }
}
