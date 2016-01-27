package yhzion.java8se.chap03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.function.BiFunction;

/**
 * 3장 연습문제
 * 문항 6.
 * 79 페이지에 있는 "3.4 함수 리턴" 절의 다음 메서드를 완성하라.
 */
public class C03E06 extends Application {

    public static <T> Image transform(Image in, BiFunction<Color, T, Color> f, T arg) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage newImage = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                newImage.getPixelWriter().setColor(x, y, f.apply(
                        in.getPixelReader().getColor(x, y), arg));
            }
        }

        return newImage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("https://www.petfinder.com/wp-content/uploads/2012/11/140272627-grooming-needs-senior-cat-632x475.jpg");
        Image newImage = transform(image, (c, factor) -> c.deriveColor(0, 1, factor, 1), 1.2);

        stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(newImage))));
        stage.show();
    }
}
