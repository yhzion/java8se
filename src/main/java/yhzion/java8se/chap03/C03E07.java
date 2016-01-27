package yhzion.java8se.chap03;

import org.junit.Test;
import yhzion.java8se.Exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumSet;

import static org.junit.Assert.assertArrayEquals;
import static yhzion.java8se.chap03.CompareOptions.*;

enum CompareOptions {
    REVERSE,
    CASE_INSENSITIVE,
    SPACE_INSENSITIVE
}

/**
 * 3장 연습문제
 * 문항 7.
 */
public class C03E07 implements Exercise {

    @Test
    @Override
    public void perform() {
        String[] values = {
                "BBB",
                " ccc",
                "aaa"
        };
        Arrays.sort(values, comparatorGenerator(EnumSet.of(
                REVERSE,
                CASE_INSENSITIVE,
                SPACE_INSENSITIVE
        )));
        assertArrayEquals(values, new String[]{
                " ccc",
                "BBB",
                "aaa"
        });
        Arrays.sort(values, comparatorGenerator(EnumSet.noneOf(CompareOptions.class)));
        assertArrayEquals(values, new String[]{
                " ccc",
                "BBB",
                "aaa"
        });
    }

    public Comparator<String> comparatorGenerator(EnumSet<CompareOptions> options) {
        return (x, y) -> {
            if (options.contains(CASE_INSENSITIVE)) {
                x = x.toLowerCase();
                y = y.toLowerCase();
            }

            if (options.contains(SPACE_INSENSITIVE)) {
                x = x.replaceAll("\\s+", "");
                y = y.replaceAll("\\s+", "");
            }

            if (options.contains(REVERSE)) {
                return y.compareTo(x);
            } else {
                return x.compareTo(y);
            }
        };
    }
}