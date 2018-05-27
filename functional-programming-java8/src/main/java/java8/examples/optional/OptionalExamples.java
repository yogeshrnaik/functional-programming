package java8.examples.optional;

import java.util.Optional;

public class OptionalExamples {

    public static void main(String[] args) {
        Object x = null;
        print(x);
        printOptional(Optional.ofNullable(x));

        String str = "abc";
        filterAndPrint(str);
        filterAndPrintOptional(Optional.ofNullable(str));

        mapAndPrint(str);
        mapAndPrintOptional(Optional.ofNullable(str));
    }

    private static void print(Object x) {
        if (x != null) {
            System.out.println(x);
        }
    }

    private static void printOptional(Optional<Object> optionalOfX) {
        optionalOfX.ifPresent(OptionalExamples::print);
    }

    private static void filterAndPrint(String x) {
        if (x != null && x.contains("a")) {
            print(x);
        }
    }

    private static void filterAndPrintOptional(Optional<String> optionalOfX) {
        optionalOfX.filter(x -> x.contains("a")).ifPresent(OptionalExamples::print);
    }

    private static void mapAndPrint(String x) {
        if (x != null) {
            String t = x.trim();
            if (t.length() > 0)
                print(t);
        }
    }

    private static void mapAndPrintOptional(Optional<String> optionalOfX) {
        optionalOfX.map(String::trim)
            .filter(t -> t.length() > 0)
            .ifPresent(OptionalExamples::print);
    }
}

class GPSDataHelper {

    public String getDirection(GPSData gps) {
        // return gps.getPosition().getLatitude().getDirection();

        /**
         * <pre>
         * String direction = "UNKNOWN";
         * if (gps != null) {
         *     Position p = gps.getPosition();
         *     if (p != null) {
         *         Latitude l = p.getLatitude();
         *         if (l != null) {
         *             direction = l.getDirection();
         *         }
         *     }
         * }
         * </pre>
         */

        return Optional.ofNullable(gps)
            .flatMap(GPSData::getPosition)
            .flatMap(Position::getLatitude)
            .map(Latitude::getDirection)
            .orElse("UNKNOWN");
    }
}

class GPSData {

    public Optional<Position> getPosition() {
        return Optional.empty();
    }
}

class Position {

    public Optional<Latitude> getLatitude() {
        return Optional.empty();
    }
}

class Latitude {

    private String direction;

    public String getDirection() {
        return direction;
    }
}
