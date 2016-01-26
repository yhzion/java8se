package yhzion.java8se.chap02;

import org.junit.Test;
import yhzion.java8se.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 2장 연습문제
 * 문항 12.
 * 64 페이지에 있는 "2.13 병렬 스트림" 장에서 설명한 것처럼 AtomicInteger 배열을 업데이트하는 방법으로
 * 병렬 Stream<String> 에 있는 모든 짧은 단어의 개수를 세라. 각 카운터를 안전하게 증가시키기 위해 원자적
 * 메서드인 getAndIncrement 를 사용한다.
 */
public class C02E12 implements Exercise {

    @Test
    @Override
    public void perform() {
        List<String> words = getWordAsList();

        AtomicInteger[] shortWords = new AtomicInteger[12];

        words.parallelStream()
                .filter(s -> s.length() < 12)
                .forEach(s -> {
                            AtomicInteger ai = shortWords[s.length()];
                            if (ai == null) {
                                ai = new AtomicInteger();
                                shortWords[s.length()] = ai;
                            }
                            ai.getAndIncrement();
                        }
                );

        Arrays.asList(shortWords).forEach(System.out::println);
    }
}
