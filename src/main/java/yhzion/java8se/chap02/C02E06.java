package yhzion.java8se.chap02;

import org.junit.Test;
import yhzion.java8se.Exercise;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 2장 연습문제
 * 문항 6.
 * 44 페이지에 있는 "2.3 filter.map, flatMap 메서드" 절의 characterStream 메서드는 먼저
 * ArrayList 를 채운 후 스트림으로 변환하기 때문에 약간은 세련되지 못했다. 스트림에 기반을 둔 한 행짜리
 * 메서드로 작성하라. 한 가지 접근법은 0 ~ s.length() - 1 범위에서 정수 스트림을 만들어서 메서드 레퍼
 * 런스에 맵핑하는 것이다.
 */
public class C02E06 implements Exercise {

    @Test
    @Override
    public void perform() {
        getCharacterStream("Hello").forEach(System.out::println);
    }

    private Stream<Character> getCharacterStream(String s) {
        return IntStream.range(0, s.length()).mapToObj(s::charAt);
    }
}
