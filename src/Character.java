import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Character extends Pane {
    Image image = new Image(getClass().getResourceAsStream("bomber.png"));
    ImageView imageView = new ImageView(image);
    int count = 3;
    int columns = 4;
    int offsetX = 0;
    int offsetY = 12;
    int width = 18;
    int height = 20;
    public SpriteAnimation animation;

    public Character() {
        imageView.setFitHeight(16);
        imageView.setViewport(new Rectangle2D(20, 20, width, height));
        animation = new SpriteAnimation(this.imageView, Duration.millis(200), count, columns, offsetX, offsetY, width, height);
        getChildren().addAll(this.imageView);
    }

    public void moveX(int x) {
        boolean movingRight = x > 0;
        for (int i = 0; i < Math.abs(x); i++) {
            for (Node platform : Main.platforms) {
                if (this.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                    if (movingRight) {
                        if (this.getTranslateX() + 18 == platform.getTranslateX()) {
                            this.setTranslateX(this.getTranslateX() - 1);
                            return;
                        }
                    } else {
                        if (this.getTranslateX() == platform.getTranslateX() + Main.BLOCK_SIZE) {
                            this.setTranslateX(this.getTranslateX() + 1);
                            return;
                        }
                    }
                }
            }
            this.setTranslateX(this.getTranslateX() + (movingRight ? 1 : -1));
        }
    }

    public void moveY(int y) {
        boolean movingDown = y > 0;
        for (int i = 0; i < Math.abs(y); i++) {
            for (Node platform : Main.platforms) {
                if (this.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                    if (movingDown) {
                        if (this.getTranslateY() + 16 == platform.getTranslateY()) {
                            this.setTranslateY(this.getTranslateY() - 1);
                            return;
                        }
                    } else {
                        if (this.getTranslateY() == platform.getTranslateY() + Main.BLOCK_SIZE) {
                            this.setTranslateY(this.getTranslateY() + 1);
                            return;
                        }
                    }
                }
            }
            this.setTranslateY(this.getTranslateY() + (movingDown ? 1 : -1));
        }
    }
}