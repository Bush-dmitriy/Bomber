import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class ExplosionAnimation extends Transition {

    private final ImageView imageView;
    private int offsetX;
    private int offsetY;
    private final int width;
    private final int height;

    public ExplosionAnimation(
            ImageView imageView,
            Duration duration,
            int offsetX, int offsetY,
            int width, int height
    ) {
        this.imageView = imageView;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.width = width;
        this.height = height;
        setCycleDuration(duration);
        setCycleCount(1);
        setInterpolator(Interpolator.LINEAR);
        this.imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
    }

    protected void interpolate(double frac) {
        imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
    }
}