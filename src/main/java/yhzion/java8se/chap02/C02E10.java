package yhzion.java8se.chap02;

import org.junit.Test;
import yhzion.java8se.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.assertEquals;

/**
 * 2장 연습문제
 * 문항 10.
 * Stream<Double> 의 평균을 계산하는 데 사용할 수 있는 reduce 호출을 작성하라 단순히 합계를 계산해
 * count() 로 나눌 수 없는 이유는 무엇인가?
 */
public class C02E10 implements Exercise {

    @Test
    @Override
    public void perform() {
        List<Double> list = new ArrayList<>(Arrays.asList(3.0, 3.0));
        assertEquals(new Double(3.0), avg(list.stream()));
    }

    private Double avg(Stream<Double> stream) {

        DoubleSummaryStatistics stat = stream.collect(Collectors.summarizingDouble(Double::new));
        return stat.getAverage();
    }
}
