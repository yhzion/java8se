package yhzion.java8se.chap03;

import org.junit.Test;
import yhzion.java8se.Exercise;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 3장 연습문제
 * 문항 2.
 * 문항 설명은 책 참조
 */
public class C03E02 implements Exercise {

    @Test
    @Override
    public void perform() {

        withLock(new ReentrantLock(), () -> System.out.println("some locked action"));
    }

    private void withLock(ReentrantLock lock, Runnable action) {
        lock.lock();
        try {
            action.run();
        } finally {
            lock.unlock();
        }
    }
}
