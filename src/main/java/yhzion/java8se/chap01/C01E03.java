package yhzion.java8se.chap01;

import org.apache.commons.io.FilenameUtils;
import org.junit.Test;
import yhzion.java8se.Exercise;

import java.io.File;
import java.util.Arrays;

/**
 * 1장 연습문제
 * 문항 3.
 * java.io.File 클래스의 list(FilenameFilter) 메서드를 이용해 주어진 디렉터리에서
 * 주어진 확장자를 지닌 모든 파일을 리턴하는 메서드를 작성하라 FilenameFilter 가 아닌
 * 람다 표현식을 사용하라. 이 람다 표현식이 자신을 감싸는 유효 범위에 있는 어느 변수를 캡처하는가?
 */
public class C01E03 implements Exercise {

    @Test
    @Override
    public void perform() {
        Arrays.asList(list("./src/main/java/yhzion/java8se/chap01", "java"))
                .forEach(System.out::println);
    }

    public static File[] list(String dir, String ext) {
        return new File(dir).listFiles(
                (f) ->
                        FilenameUtils.getExtension(
                                f.getName()).toLowerCase().equals(ext.toLowerCase()
                        )
        );
    }
}