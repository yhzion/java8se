package yhzion.java8se.chap01;

import org.junit.Test;
import yhzion.java8se.Exercise;

/**
 * 1장 연습문제
 * 문항 7.
 * Runnable 인스턴스 두 개를 파라미터로 받고 첫번째 인스턴스를 실행 한 후
 * 두 번째를 실행하는 Runnable 을 리턴하는 andThen이라는 정적 메서드를 작성하라.
 * main 메서드에서 andThen 호춣에 람다 표현식 두 개를 전달하고 결과로 받은 인스턴스를 실행하라.
 */
public class C01E07 implements Exercise {

    @Test
    @Override
    public void perform() {

        new Thread(
                andThen(
                        () -> System.out.println("r1 thread"),
                        () -> System.out.println("r2 thread")
                )
        ).start();
    }

    private static Runnable andThen(Runnable r1, Runnable r2) {
        return () -> {
            r1.run();
            r2.run();
        };
    }
}