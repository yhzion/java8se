package yhzion.java8se.chap01;

import org.junit.Test;
import yhzion.java8se.Exercise;

import java.io.File;
import java.util.Arrays;

/**
 * 1장 연습문제
 * 문항 2.
 * java.io.File 클래스의 listFiles(FileFilter)와 isDirectory 메서드를 이용해
 * 주어진 디렉터리의 모든 서브디렉터리를 리턴하는 메서드를 작성하라.
 * FileFilter 객체 대신 람다 표현식을 사용하라 메서드 표현식을 이용해 같은 작업을 반복하라.
 */
public class C01E02 implements Exercise {

    @Test
    @Override
    public void perform() {
        Arrays.asList(getChildDirsWithLambda(".")).forEach(System.out::println);
        System.out.println("------------------------------------------------");
        Arrays.asList(getChildDirsWithMethodReference(".")).forEach(System.out::println);
    }

    private static File[] getChildDirsWithLambda(String dir) {
        return new File(dir).listFiles((file) -> file.isDirectory());
    }

    private static File[] getChildDirsWithMethodReference(String dir) {
        return new File(dir).listFiles(File::isDirectory);
    }
}
