package yhzion.java8se.chap02;

import org.junit.Test;
import yhzion.java8se.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * 2장 연습문제
 * 문항 9.
 * Stream<ArrayList<T>> 에 있는 모든 요소들을 ArrayList<T> 하나로 결합하라. reduce 의 세 가지 형
 * 태를 이용해 이 작업을 수행하는 방법을 보여라.
 */
public class C02E09 implements Exercise {

    @Test
    @Override
    public void perform() {

        List<ArrayList<String>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList("I ", "am ", "a ", "boy, ")));
        list.add(new ArrayList<>(Arrays.asList("You ", "are ", "a ", "girl")));

        assertEquals(8, join(list.stream()).size());
        assertEquals(8, joinUsingReduce1(list.stream()).size());
        assertEquals(8, joinUsingReduce2(list.stream()).size());
        assertEquals(8, joinUsingReduce3(list.stream()).size());
    }

    private List<String> join(Stream<ArrayList<String>> stream) {
        return stream.flatMap(e -> e.stream()).collect(Collectors.toList());
    }

    private <T> ArrayList<T> joinUsingReduce1(Stream<ArrayList<T>> stream) {
        return stream.reduce((x, y) -> {
            ArrayList<T> list = new ArrayList<T>(x);
            list.addAll(y);
            return list;
        }).orElse(new ArrayList<T>());
    }

    private <T> ArrayList<T> joinUsingReduce2(Stream<ArrayList<T>> stream) {
        return stream.reduce(new ArrayList<T>(), (x, y) -> {
            ArrayList<T> list = new ArrayList<T>(x);
            list.addAll(y);
            return list;
        });
    }

    private <T> ArrayList<T> joinUsingReduce3(Stream<ArrayList<T>> stream) {
        return stream.reduce(new ArrayList<T>(),
                (x, y) -> {
                    ArrayList<T> list = new ArrayList<T>(x);
                    list.addAll(y);

                    return list;
                },
                (x, y) -> {
                    ArrayList<T> list = new ArrayList<T>(x);
                    list.addAll(y);

                    return list;
                }
        );
    }
}
