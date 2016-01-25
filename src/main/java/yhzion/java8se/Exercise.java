package yhzion.java8se;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public interface Exercise {

    void perform();

    default List<String> getWordAsList() {
        String content;
        try {
            content = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("/pg2600.txt").toURI())), StandardCharsets.UTF_8);
            return Arrays.asList(content.split("[\\P{L}]+"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    default String[] getWordAsArray() {
        String content;
        try {
            content = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("/pg2600.txt").toURI())), StandardCharsets.UTF_8);
            return content.split("[\\P{L}]+");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}