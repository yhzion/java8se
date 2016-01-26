package yhzion.java8se.chap02;

import org.junit.Test;
import yhzion.java8se.Exercise;

import java.util.stream.Stream;

/**
 * 2장 연습문제
 * 문항 5.
 * Stream.iterate 를 사용해 난수의 무한 스트림을 만들어라. 이때 Math.random 을 호출하지 말고 선
 * 형 적합 발생기(linear congruential generator)를 직접 구현해서 사용한다. 이와 같은 발생기에서는 x0 = seed 로
 * 시작해 적합한 a,c,m 값에 대해 xn + 1 = (axn + c) % m을 생산한다. 파라미터로 a, c, m, seed 를 받고
 * Stream<Long>을 리턴하는 메서드를 구현해야 한다. a = 25214903917, c = 11, m = 2 48 값으로 난수의
 * 무한 스트림을 만들어본다.
 */
public class C02E05 implements Exercise {

    @Test
    @Override
    public void perform() {
        getStream(25214903917L, 11, (long) Math.pow(2, 48), System.currentTimeMillis())
                .limit(10)
                .forEach(System.out::println);
    }

    private static Stream<Long> getStream(long a, long c, long m, long seed) {
        return Stream.iterate(seed, e -> (a * e + c) % m);
    }
}
