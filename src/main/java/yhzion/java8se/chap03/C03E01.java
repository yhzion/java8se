package yhzion.java8se.chap03;

import org.junit.Test;
import yhzion.java8se.Exercise;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 * 3장 연습문제
 * 문항 1.
 * 조건부 로깅을 제공해 지연 로깅 기법을 개선하라. 일반적으로 logIf(level.FINEST, () -> i == 10,
 * () -> "a[10] = " + a[10]) 과 같이 호출 할 것이다. 로거에서 메시지를 로그로 남길 수 없을 때는 조건을
 * 평가하지 않아야 한다.
 */
public class C03E01 implements Exercise {

    @Test
    @Override
    public void perform() {
        Logger.getGlobal().setLevel(Level.OFF);
        logIf(Level.INFO, () -> true, () -> "You'll never see it");
        Logger.getGlobal().setLevel(Level.ALL);
        int[] a = IntStream.rangeClosed(0, 10).toArray();
        for (int i = 0; i < a.length; i++) {
            log(i, a);
        }
    }

    private void log(int i, int[] a) {
        logIf(Level.INFO, () -> i == 10, () -> "a[10]" + a[10]);
    }

    public void logIf(Level level, Supplier<Boolean> condition, Supplier<String> message) {
        Logger logger = Logger.getGlobal();
        if (logger.isLoggable(level) && condition.get()) {
            logger.log(level, message.get());
        }
    }
}
