package yhzion.java8se.chap03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

@FunctionalInterface
interface ColorTransformer {
    Color apply(int x, int y, Color colorAtXY);
}

/**
 * 3장 연습문제
 * 문항 5.
 */
public class C03E05 extends Application {


    public static Image transform(Image in, ColorTransformer t) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                out.getPixelWriter().setColor(x, y, t.apply(x, y, in.getPixelReader().getColor(x, y)));
            }
        }

        return out;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("https://www.petfinder.com/wp-content/uploads/2012/11/140272627-grooming-needs-senior-cat-632x475.jpg");
        Image newImage = transform(image,
                (x, y, c) -> (
                        x <= 10 || x >= image.getWidth() - 10
                                || y <= 10 || y >= image.getHeight() - 10) ? Color.GREY : c);
        stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(newImage))));
        stage.show();
    }
}
