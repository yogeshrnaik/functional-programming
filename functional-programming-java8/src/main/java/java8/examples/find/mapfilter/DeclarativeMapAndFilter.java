package java8.examples.find.mapfilter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DeclarativeMapAndFilter {

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java7", "Clojure", "Scala", "Java8", "Groovy");
        findJavaVersions(languages);
    }

    public static void findJavaVersions(List<String> languages) {
        List<String> javaVersions = languages.stream()
            .filter(l -> l.startsWith("Java"))
            .map(s -> s.toUpperCase())
            .collect(Collectors.toList());
        System.out.println("Java versions: " + javaVersions);
    }

}
