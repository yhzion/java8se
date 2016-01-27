package yhzion.java8se.chap03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.function.UnaryOperator;

/**
 * 3장 연습문제
 * 문항 11.
 */
public class C03E11 extends Application {

    public static ColorTransformer compose(ColorTransformer... transformers) {

        return (x, y, c) -> {
            for (ColorTransformer t : transformers) c = t.apply(x, y, c);
            return c;
        };
    }

    public static ColorTransformer map(UnaryOperator<Color> op) {
        return (x, y, c) -> op.apply(c);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("https://www.petfinder.com/wp-content/uploads/2012/11/140272627-grooming-needs-senior-cat-632x475.jpg");
        Image newImage = C03E05.transform(image, compose(
                map(Color::grayscale),
                map(Color::brighter),
                (x, y, c) -> (
                        x <= 10 || x >= image.getWidth() - 10
                                || y <= 10 || y >= image.getHeight() - 10) ? Color.YELLOW : c));
        stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(newImage))));
        stage.show();
    }
}
