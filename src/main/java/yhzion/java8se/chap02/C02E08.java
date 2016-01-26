package yhzion.java8se.chap02;

import org.junit.Test;
import yhzion.java8se.Exercise;

import java.util.Iterator;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * 2장 연습문제
 * 문항 8.
 * public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) 메서드를 작성하라. 이
 * 메서드는 first 와 second 스트림의 요소들을 교환하며 두 스트림 중 하나에서 요소가 바닥이 나면 작업을 중단한다.
 */
public class C02E08 implements Exercise {

    @Test
    @Override
    public void perform() {
        Stream<String> stream = zip(Stream.of("1", "2", "3"), Stream.of("a", "b"));
        assertEquals(4, stream.peek(System.out::println).count());
        stream = zip(Stream.of("1", "2", "3"), Stream.of("a", "b", "c", "d", "e"));
        assertEquals(6, stream.peek(System.out::println).count());
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {

        Iterator<T> secondAsIterator = second.iterator();
        Stream.Builder<T> builder = Stream.builder();

        first.forEach(
                (e) -> {
                    if (secondAsIterator.hasNext()) {
                        builder.accept(e);
                        builder.accept(secondAsIterator.next());
                    } else {
                        first.close();
                    }
                }
        );

        return builder.build();
    }

}
