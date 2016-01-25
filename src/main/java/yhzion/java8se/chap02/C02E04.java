package yhzion.java8se.chap02;

import org.junit.Test;
import yhzion.java8se.Exercise;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 2장 연습문제
 * 문항 4.
 * int[] values = { 1, 4, 9, 16 } 배열이 있다고 하자 Stream.of(values) 의 결과는 무엇인가? int
 * 스트림은 어떻게 얻을 수 있는가?
 */
public class C02E04 implements Exercise {

    @Test
    @Override
    public void perform() {
        int[] values = {1, 4, 9, 16};
        IntStream.of(values).forEach(System.out::println);
        Arrays.stream(values).forEach(System.out::println);
    }
}
