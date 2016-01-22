package yhzion.java8se.chap01;

import org.junit.Test;
import yhzion.java8se.Exercise;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class C01E01 implements Exercise {

    @Test
    @Override
    public void perform() {
        final long currentThreadId = Thread.currentThread().getId();
        String[] array = getWordAsArray();

        Set<Long> threadIds = new CopyOnWriteArraySet<>();

        Arrays.sort(array, (first, second) -> {
            threadIds.add(Thread.currentThread().getId());
            return first.compareTo(second);
        });

        assertEquals(1, threadIds.size());
        assertEquals(currentThreadId, threadIds.toArray()[0]);

        threadIds.clear();
        Arrays.parallelSort(array, (first, second) -> {
            threadIds.add(Thread.currentThread().getId());
            return first.compareTo(second);
        });

        assertTrue(threadIds.size() > 1);
    }

}
