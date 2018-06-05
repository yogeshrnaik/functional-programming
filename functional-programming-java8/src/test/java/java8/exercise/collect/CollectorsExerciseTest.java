package java8.exercise.collect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class CollectorsExerciseTest {

    private static final List<Person> LIST_OF_PERSONS = Arrays.asList(
        new Person("John", "Amsterdam"),
        new Person("Peter", "Ghent"),
        new Person("Mike", "Amsterdam"),
        new Person("Jake", "Lodz"),
        new Person("Pam", "Ghent"));

    private final CollectorsExercise exercise = new CollectorsExercise();

    @Test
    public void testGetStudentScoreMap() {
        Map<Integer, Integer> result = exercise.getStudentScoreMap(
            Arrays.asList(new Student(1, 90),
                new Student(2, 50),
                new Student(3, 80),
                new Student(4, 95),
                new Student(5, 65)));

        assertTrue(result.keySet().containsAll(Arrays.asList(1, 2, 3, 4, 5)));
        assertTrue(result.values().containsAll(Arrays.asList(90, 50, 80, 95, 65)));
    }

    @Test
    public void testGroupOccupantsByCity() {
        Map<String, Set<String>> result = exercise.groupOccupantsByCity(LIST_OF_PERSONS);

        // {Ghent=Peter,Pam, Amsterdam=John,Mike, Lodz=Jake}
        assertTrue(result.get("Amsterdam").containsAll(Arrays.asList("John", "Mike")));
        assertTrue(result.get("Ghent").containsAll(Arrays.asList("Peter", "Pam")));
        assertTrue(result.get("Lodz").containsAll(Arrays.asList("Jake")));
    }

    @Test
    public void testGetOccupantsByCity() {
        Map<String, String> result = exercise.getOccupantsByCity(LIST_OF_PERSONS);

        // {Ghent=Peter,Pam, Amsterdam=John,Mike, Lodz=Jake}
        assertEquals("John,Mike", result.get("Amsterdam"));
        assertEquals("Peter,Pam", result.get("Ghent"));
        assertEquals("Jake", result.get("Lodz"));
    }
}
