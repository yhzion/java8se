package yhzion.java8se.chap03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 3장 연습문제
 * 문항 .
 */
public class C03E08 extends Application {


    public static ColorTransformer transformer(Image image, int argX, int argY, Color argC) {
        return (x, y, c) ->
                (x <= argX || x >= image.getWidth() - argX
                        || y <= argY || y >= image.getHeight() - argY) ? argC : c;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("https://www.petfinder.com/wp-content/uploads/2012/11/140272627-grooming-needs-senior-cat-632x475.jpg");
        Image newImage = C03E05.transform(image, transformer(image, 40, 20, Color.WHITE));

        stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(newImage))));
        stage.show();
    }
}