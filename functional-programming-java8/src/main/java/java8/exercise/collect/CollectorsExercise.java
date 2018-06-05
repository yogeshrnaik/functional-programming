package java8.exercise.collect;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectorsExercise {

    /**
     * Convert a list of students into a map that uses student Id as key and student's score as value
     */
    public Map<Integer, Integer> getStudentScoreMap(List<Student> students) {
        return new HashMap<>();
    }

    /**
     * Count the number of words by length <br/>
     * Given list of words, return a a map that uses length of a word as key and <br/>
     * value = number of words found having same length as key
     */
    public Map<Integer, Long> countWordsByLength(List<String> words) {
        return new HashMap<>();
    }

    /**
     * Convert a list of Persons into a map that uses Person's City as key and Person's name as value <br/>
     * In case of multiple persons from same city, put them in a set<br/>
     */
    public Map<String, Set<String>> groupOccupantsByCity(List<Person> persons) {
        return new HashMap<>();
    }

    /**
     * Convert a list of Persons into a map that uses Person's City as key and Person's name as value <br/>
     * In case of multiple persons from same city, concatenate their names using comma and <br/>
     * use the concatenated names as value <br/>
     */
    public Map<String, String> getOccupantsByCity(List<Person> persons) {
        return new HashMap<>();
    }
}
