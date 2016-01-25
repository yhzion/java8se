package yhzion.java8se.chap02;

import junit.framework.Assert;
import org.junit.Test;
import yhzion.java8se.Exercise;

import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 * 2장 연습문제
 * 문항 3.
 * stream 대신 parallelStream 을 이용해 긴 단어 개수를 셀 때 차이를 측정하라 각 호출 이전과 이후에
 * System.currentTimeMillis 를 호출하고 차이를 출력한다 빠른 컴퓨터를 보유하고 있다면 전쟁과 평화
 * War and Peace 처럼 더 큰 문서로 바꿔서 측정한다.
 */
public class C02E03 implements Exercise {

    @Test
    @Override
    public void perform() {

        List<String> words = getWordAsList();

        long startTime = System.nanoTime();
        long count1 = words.stream().filter((s) -> s.length() > 1).count();
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        long count2 = words.parallelStream().filter((s) -> s.length() > 1).count();
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        assertEquals(count1, count2);
    }
}
