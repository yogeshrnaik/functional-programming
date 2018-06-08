package java8.examples.find.mapfilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImperativeMapAndFilter {

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java7", "Clojure", "Scala", "Java8", "Groovy");
        findJavaVersions(languages);
        findJavaVersionsWithForEach(languages);
    }

    public static void findJavaVersions(List<String> languages) {
        List<String> javaVersions = new ArrayList<>();

        for (String lang : languages) {
            if (lang.startsWith("Java")) {
                javaVersions.add(lang.toUpperCase());
            }
        }

        System.out.println("Java versions: " + javaVersions);
    }

    public static void findJavaVersionsWithForEach(List<String> languages) {
        List<String> javaVersions = new ArrayList<>();

        languages.forEach(lang -> {
            if (lang.startsWith("Java")) {
                javaVersions.add(lang);
            }
        });

        System.out.println("Java versions: " + javaVersions);
    }

}
