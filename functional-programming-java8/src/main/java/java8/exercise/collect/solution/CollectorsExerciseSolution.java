package java8.exercise.collect.solution;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import java8.exercise.collect.CollectorsExercise;
import java8.exercise.collect.Person;
import java8.exercise.collect.Student;

public class CollectorsExerciseSolution extends CollectorsExercise {

    /**
     * Convert a list of students into a map that uses student Id as key and student's score as value
     */
    @Override
    public Map<Integer, Integer> getStudentScoreMap(List<Student> students) {
        return students.stream()
            .collect(Collectors.toMap(Student::getId, Student::getScore));
    }

    /**
     * Convert a list of Persons into a map that uses Person's City as key and Person's name as value <br/>
     * In case of multiple persons from same city, put them in a set<br/>
     */
    @Override
    public Map<String, Set<String>> groupOccupantsByCity(List<Person> persons) {
        return persons.stream()
            .collect(Collectors.groupingBy(Person::getCity,
                Collectors.mapping(Person::getName, Collectors.toSet())));
    }

    /**
     * Convert a list of Persons into a map that uses Person's City as key and Person's name as value <br/>
     * In case of multiple persons from same city, concatenate their names using comma and <br/>
     * use the concatenated names as value <br/>
     */
    @Override
    public Map<String, String> getOccupantsByCity(List<Person> persons) {
        return persons.stream()
            .collect(Collectors.toMap(Person::getCity, Person::getName, (n1, n2) -> n1 + "," + n2));
    }
}
