
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class Fire extends Pane {
    Image fireImg = new Image(getClass().getResourceAsStream("fire.png"));
    ImageView fire;
    public ExplosionAnimation animation;


    public Fire(int x, int y, int offsetX, int offsetY) {
        fire = new ImageView(fireImg);
        fire.setFitWidth(Main.BLOCK_SIZE - 4);
        fire.setFitHeight(Main.BLOCK_SIZE - 4);
        setTranslateX(x);
        setTranslateY(y);
        fire.setViewport(new Rectangle2D(offsetX, offsetY, 14, 14));
        animation = new ExplosionAnimation(this.fire, Duration.millis(800), offsetX, offsetY, 14, 14);
        getChildren().add(fire);
    }

}