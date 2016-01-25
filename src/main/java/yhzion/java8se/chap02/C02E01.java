package yhzion.java8se.chap02;

import org.junit.Test;
import yhzion.java8se.Exercise;

import java.util.List;

/**
 * 2장 연습문제
 * 문항 1.
 * 41페이지에 있는 "2.1 반복에서 스트림 연산으로" 절의 for 루프를 병렬 버전으로 작성하라 먼저 프로세서의
 * 개수를 얻는다 다수의스레드를 생성해 각 스레드가 리스트의 각 세그먼트를 대상으로 작업하게 하고, 결과들
 * 이 나오면 합산한다(여러분은 스레드들이 단일 카운터를 업데이트 하는 상황을 원치 않을 것이다. 그 이유는
 * 무엇인가?)
 */
public class C02E01 implements Exercise {

    @Test
    @Override
    public void perform() {

        List<String> words = getWordAsList();

        long count = words.parallelStream().filter((s) -> s.length() > 10).count();
    }
}
