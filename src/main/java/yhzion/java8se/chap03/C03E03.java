package yhzion.java8se.chap03;

import org.junit.Test;
import yhzion.java8se.Exercise;

import java.util.function.BooleanSupplier;

/**
 * 3장 연습문제
 * 문항 3.
 * 자바 1.4 는 언어에 assert 키워드를 이용한 단정 기능을 추가했다. 단정이 라이브러리 기능으로
 * 제공되지 않은 이유는 무엇인가? 자바 8에서는 단정을 라이브러리 기능으로 구현할 수 있는가?
 */
public class C03E03 implements Exercise {

    @Test
    @Override
    public void perform() {
        assertThat(() -> 2 * 2 == 4);
    }

    public void assertThat(BooleanSupplier assertion) {
        if (!assertion.getAsBoolean()) {
            throw new AssertionError();
        }
    }


}
