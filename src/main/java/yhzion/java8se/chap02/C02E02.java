package yhzion.java8se.chap02;

import org.junit.Test;
import yhzion.java8se.Exercise;

/**
 * 2장 연습문제
 * 문항 2.
 * 처음 5개 긴 단어를 요청했을 때 일단 긴 단어를 5번째 발견하고 나면 filter 메서드를 호출하지 않음을 확인
 * 하라 간단하게 각 메서드 호출을 기록하라.
 */
public class C02E02 implements Exercise {

    @Test
    @Override
    public void perform() {
        getWordAsList()
                .stream().filter((s) -> s.length() > 12).limit(5).forEach(System.out::println);
    }
}
