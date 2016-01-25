package yhzion.java8se.chap01;

import com.sun.jdi.connect.spi.Connection;
import org.junit.Test;
import yhzion.java8se.Exercise;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;

/**
 * 1장 연습문제
 * 문항 9.
 * Collection 으로부터 Collection2라는 서브클래스를 만들고, filter 가 true 를 리턴하는 각 요소를
 * 대상으로 액션(action)을 적용하는 디폴트 메서드인 void forEachIf(Consumer<T> action, Predicate<T> filter)를 추가하라.
 * 이 디폴트 메서드를 어떻게 사용할 수 있는가?
 */
public class C01E09 implements Exercise {

    @Test
    @Override
    public void perform() {
        Collection2<Integer> c = new ArrayList2<>();
        c.add(100);
        c.add(-5);
        CopyOnWriteArraySet<Integer> set = new CopyOnWriteArraySet<>();
        c.forEachIf(set::add, i -> i > 0);
        assertEquals(1, set.size());
        assertEquals(100, set.toArray()[0]);

    }
}

interface Collection2<T> extends Collection<T> {

    default void forEachIf(Consumer<T> action, Predicate<T> filter) {
        forEach(t -> {
            if(filter.test(t)) {
                action.accept(t);
            }
        });
    }
}

class ArrayList2<T> extends ArrayList<T> implements Collection2<T> {
}