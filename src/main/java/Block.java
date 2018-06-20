
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class Block extends Pane {
    Image blocksImg = new Image(getClass().getResourceAsStream("block.png"));
    ImageView block;
    boolean destructibility = false;

    public enum BlockType {
        BRICK, STONE
    }

    public Block(BlockType blockType, int x, int y) {
        block = new ImageView(blocksImg);
        block.setFitWidth(Main.BLOCK_SIZE);
        block.setFitHeight(Main.BLOCK_SIZE);
        setTranslateX(x);
        setTranslateY(y);

        switch (blockType) {
            case STONE:
                block.setViewport(new Rectangle2D(0, 0, 16, 16));
                break;
            case BRICK:
                block.setViewport(new Rectangle2D(21, 0, 16, 16));
                destructibility = true;
                break;
        }
        getChildren().add(block);
        Main.platforms.add(this);
        Main.appRoot.getChildren().add(this);
    }
}
