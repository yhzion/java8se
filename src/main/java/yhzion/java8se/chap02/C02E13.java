package yhzion.java8se.chap02;

import org.junit.Test;
import yhzion.java8se.Exercise;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

/**
 * 2장 연습문제
 * 문항 13.
 * 연습문제 12 를 다시 풀되, 이번에는 짧은 문자열을 걸러내고 collect 메서드를 Collectors.groupingBy,
 * Collectors.counting 과 조합해 사용하라.
 */
public class C02E13 implements Exercise {

    @Test
    @Override
    public void perform() {
        getWordAsList().parallelStream()
                .filter(s -> s.length() < 12)
                .collect(Collectors.groupingBy(String::length, counting()))
                .forEach((k, v) -> System.out.printf("%d\t%d\n", k, v)
        );
    }
}
