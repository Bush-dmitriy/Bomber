import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Bomb extends Pane {
    Image image = new Image(getClass().getResourceAsStream("bomb.png"));
    ImageView imageView = new ImageView(image);
    int count = 3;
    int columns = 1;
    int offsetX = 0;
    int offsetY = 25;
    int width = 16;
    int height = 20;
    public SpriteAnimation animation;


    public Bomb(int x, int y) {
        imageView.setViewport(new Rectangle2D(20, 20, width, height));
        animation = new SpriteAnimation(imageView, Duration.millis(800), count, columns, offsetX, offsetY, width, height);
        setTranslateX(x);
        setTranslateY(y);
        getChildren().add(imageView);
    }
}
