package yhzion.java8se.chap02;

import org.junit.Test;
import yhzion.java8se.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * 2장 연습문제
 * 문항 11.
 * 단일 ArrayList 를 스트림의 크기로 생성했다면 여러 ArrayList 를 병합하는 대신 단일 리스트 안에
 * 스트림 결과들을 동시에 모을 수 있어야 한다 이는 떨어진 위치에서 병행 set 연산은 스레드에 안전하기 때문이다.
 * 이 작업을 어떻게 할 수 있는가?
 */
public class C02E11 implements Exercise {

    @Test
    @Override
    public void perform() {
        List<ArrayList<String>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList("01", "02", "03")));
        list.add(new ArrayList<>(Arrays.asList("04", "05")));
        list.add(new ArrayList<>(Arrays.asList("06", "07", "08", "09", "10")));

        assertEquals(10, collect(list.stream()).size());
    }

    public List<String> collect(Stream<ArrayList<String>> stream) {
        String[] arr = stream.flatMap(Collection::stream).toArray(String[]::new);
        IntStream range = IntStream.range(0, arr.length);
        List<String> result = new ArrayList<>(Arrays.asList(new String[arr.length]));
        range.parallel().forEach(e -> result.set(e, arr[e]));

        return result;

    }
}
