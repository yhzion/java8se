package yhzion.java8se.chap01;

import org.junit.Test;
import yhzion.java8se.Exercise;

/**
 * 1장 연습문제
 * 문항 6.
 * Runnable에서 검사 예외를 다뤄야 하는 점이 싫지 않은가 모든 검사 예외를 잡아내서
 * 비검사 예외로 바꾸는 uncheck 메서드를 작성하라 예를 들면, 다음과 같이 사용할 것이다.
 */
public class C01E06 implements Exercise {

    @Test
    @Override
    public void perform() {

        new Thread(
            uncheck(
                    () -> {
                        System.out.println("Zzz");
                        Thread.sleep(1000);
                    }
            )
        ).start();

    }

    public static Runnable uncheck(RunnableEx runner) {
        return () -> {
            try {
                runner.run();
            } catch(Exception ignored) {}
        };
    }
}


interface RunnableEx {

    void run() throws Exception;
}