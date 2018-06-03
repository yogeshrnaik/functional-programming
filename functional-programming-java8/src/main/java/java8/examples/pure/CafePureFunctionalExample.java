package java8.examples.pure;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import io.vavr.Tuple2;
import io.vavr.collection.Stream;

public class CafePureFunctionalExample {

    public Coffee buyCoffee(CreditCard cc, PaymentGateway pg) {
        Coffee cup = new Coffee(50.0);
        pg.charge(cc, cup.price); // calls external service
        return cup;
    }

    public Tuple2<Coffee, Charge> buyCoffeeFunctional(CreditCard cc) {
        Coffee cup = new Coffee(50.0);
        return new Tuple2<>(cup, new Charge(cc, cup.price));
    }

    public Tuple2<List<Coffee>, Charge> buyCoffees(CreditCard cc, int noOfCoffees) {
        Stream<Tuple2<Coffee, Charge>> purchases =
            Stream.fill(noOfCoffees, () -> buyCoffeeFunctional(cc));

        Tuple2<Stream<Coffee>, Stream<Charge>> unzip =
            purchases.unzip(t -> new Tuple2<>(t._1, t._2));

        return new Tuple2<List<Coffee>, Charge>(
            unzip._1.collect(Collectors.toList()),
            unzip._2.reduce((c1, c2) -> c1.combine(c2)));
    }
}

class Coffee {

    public double price;

    public Coffee(double p) {
        price = p;
    }
}

class CreditCard {

    public void charge(double price) {
    }
}

class PaymentGateway {

    public void charge(CreditCard cc, double price) {
    }
}

class Charge {

    private CreditCard card;
    private double amount;

    public Charge(CreditCard cc, double amount) {
        this.card = cc;
        this.amount = amount;
    }

    public Charge combine(Charge other) {
        if (card == other.card)
            return new Charge(card, amount + other.amount);
        else
            throw new RuntimeException("Can't combine charges to different cards");
    }

    public static Map<CreditCard, List<Charge>> groupByCreditCard(List<Charge> charges) {
        return charges.stream().collect(groupingBy(c -> c.card, toList()));
    }
}