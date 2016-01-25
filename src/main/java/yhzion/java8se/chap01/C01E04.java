package yhzion.java8se.chap01;

import org.junit.Test;
import yhzion.java8se.Exercise;

import java.io.File;
import java.util.Arrays;

/**
 * 1장 연습문제
 * 문항 4.
 * File 객체 배열이 주어졌을 때 디렉터리가 파일보다 앞에 위치하고
 * 각 그룹 안에서 요소들이 경로 이름에 따라 정렬되도록 정렬하라.
 * Comparator가 아닌 람다 표현식을 사용하라.
 */
public class C01E04 implements Exercise {

    @Test
    @Override
    public void perform() {
        Arrays.asList(sort("./src/main/java/yhzion/java8se/chap01"))
                .forEach(System.out::println);
    }

    private static File[] sort(String dir) {

        File[] files = new File(dir).listFiles();

        Arrays.sort(files, (f1, f2) -> {
            if (f1.isDirectory() && !f2.isDirectory()) {
                return -1;
            } else if (!f1.isDirectory() && f2.isDirectory()) {
                return 1;
            } else {
                return f1.getName().toLowerCase().compareTo(f2.getName().toLowerCase());
            }
        });

        return files;
    }
}