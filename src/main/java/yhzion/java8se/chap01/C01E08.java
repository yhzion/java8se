package yhzion.java8se.chap01;

import org.junit.Test;
import yhzion.java8se.Exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 1장 연습문제
 * 문항 8.
 * 람다 표현식이 다음과 같은 향상된 for 루프에 있는 변수를 캡처할 때 무슨 일이 일어나는가?
 */
public class C01E08 implements Exercise {

    @Test
    @Override
    public void perform() {
        String[] names = {"Peter", "Paul", "Mary"};
        List<Runnable> runners = new ArrayList<>();
        for (String name : names) {
            runners.add(() -> System.out.println(name));
        }
        for (Runnable runner : runners) {
            new Thread(runner).start();
        }

        runners.clear();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            runners.add(() -> System.out.println(name));
        }
        for (Runnable runner : runners) {
            new Thread(runner).start();
        }
    }
}