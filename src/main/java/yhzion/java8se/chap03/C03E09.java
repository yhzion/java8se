package yhzion.java8se.chap03;

import org.junit.Test;
import yhzion.java8se.Exercise;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

/**
 * 3장 연습문제
 * 문항 9.
 */
public class C03E09 implements Exercise {

    @Test
    @Override
    public void perform() {
        Person[] persons = {
                new Person("John", "Green"),
                new Person(null, "Black"),
                new Person("Adam", "White")
        };
        Arrays.sort(persons, lexicographicComparator("lastname", "firstname"));
        assertEquals("Black", persons[0].lastname);
        Arrays.sort(persons, lexicographicComparator("firstname", "lastname"));
        assertEquals("White", persons[0].lastname);
    }

    public <T> Comparator<T> lexicographicComparator(String... fieldNames) {
        return (x, y) -> {
            for (String fieldName : fieldNames) {
                try {
                    Field field = x.getClass().getDeclaredField(fieldName);
                    field.setAccessible(true);
                    Object valueX = field.get(x);
                    Object valueY = field.get(y);
                    if (valueX == null && valueY == null) continue;
                    if (valueX == null || valueY == null) return valueX == null ? 1 : -1;
                    int compareResult = field.get(x).toString().compareTo(field.get(y).toString());
                    if (compareResult != 0) {
                        return compareResult;
                    }
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            return 0;
        };
    }

    class Person {

        private String firstname;
        private String lastname;

        Person(String firstname, String lastname) {
            this.firstname = firstname;
            this.lastname = lastname;
        }
    }
}
