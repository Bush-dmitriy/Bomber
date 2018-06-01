
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;


import java.util.ArrayList;
import java.util.HashMap;

public class Main extends Application {
    private HashMap<KeyCode, Boolean> keys = new HashMap<>();
    public static ArrayList<Block> platforms = new ArrayList<>();

    Image backgroundImage = new Image(getClass().getResourceAsStream("background.png"));
    Image backgroundImage2 = new Image(getClass().getResourceAsStream("Player 1 Wins.png"));
    Image backgroundImage3 = new Image(getClass().getResourceAsStream("Player 2 Wins.png"));

    public Character player;
    public Character player2;
    public Bomb bomb;
    public Bomb bomb2;
    static Pane appRoot = new Pane();
    public static final int BLOCK_SIZE = 30;
    int levelNumber = 0;
    boolean bombCount = true;
    boolean bombCount2 = true;
    boolean animationCount = true;
    boolean animationCount2 = true;
    Explosion explosion;

    private void initContent() {
        ImageView backgroundIV = new ImageView(backgroundImage);
        backgroundIV.setFitHeight(330);
        backgroundIV.setFitWidth(660);
        appRoot.getChildren().add(backgroundIV);
        player = new Character();
        player2 = new Character();
        for (int i = 0; i < LevelData.levels[levelNumber].length; i++) {
            String line = LevelData.levels[levelNumber][i];
            for (int j = 0; j < line.length(); j++) {
                switch (line.charAt(j)) {
                    case '0':
                        break;
                    case '1':
                        Block stone = new Block(Block.BlockType.STONE, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case '2':
                        Block brick = new Block(Block.BlockType.BRICK, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                }
            }
        }
        appRoot.getChildren().addAll(player, player2);
    }

    public void bombUpdate() {
        if (isPressed(KeyCode.ENTER)) {
            if (bombCount) {
                bomb = new Bomb((int) player.getTranslateX(), (int) player.getTranslateY());
                bombCount = false;
                appRoot.getChildren().add(bomb);
            }
        }
        if (appRoot.getChildren().contains(bomb) && animationCount) {
            bomb.animation.setCycleCount(2);
            bomb.animation.setOnFinished(event -> {
                bombCount = true;
                animationCount = true;
                appRoot.getChildren().remove(bomb);
                explosion = new Explosion((int) (bomb.getTranslateX() - bomb.getTranslateX() % 30),
                        (int) (bomb.getTranslateY() - bomb.getTranslateY() % 30));
                if (explosion.lowerFire.getBoundsInParent().intersects(player.getBoundsInParent()) ||
                        explosion.centralFire.getBoundsInParent().intersects(player.getBoundsInParent()) ||
                        explosion.leftFire.getBoundsInParent().intersects(player.getBoundsInParent()) ||
                        explosion.upperFire.getBoundsInParent().intersects(player.getBoundsInParent()) ||
                        explosion.rightFire.getBoundsInParent().intersects(player.getBoundsInParent())) {
                    appRoot.getChildren().remove(player);
                    appRoot.getChildren().clear();
                    ImageView winner = new ImageView(backgroundImage2);
                    winner.setFitHeight(330);
                    winner.setFitWidth(660);
                    appRoot.getChildren().add(winner);
                }
                if (explosion.lowerFire.getBoundsInParent().intersects(player.getBoundsInParent()) ||
                        explosion.centralFire.getBoundsInParent().intersects(player2.getBoundsInParent()) ||
                        explosion.leftFire.getBoundsInParent().intersects(player2.getBoundsInParent()) ||
                        explosion.upperFire.getBoundsInParent().intersects(player2.getBoundsInParent()) ||
                        explosion.rightFire.getBoundsInParent().intersects(player2.getBoundsInParent())) {
                    appRoot.getChildren().remove(player2);
                    appRoot.getChildren().clear();
                    ImageView winner = new ImageView(backgroundImage3);
                    winner.setFitHeight(330);
                    winner.setFitWidth(660);
                    appRoot.getChildren().add(winner);
                }
            });
            bomb.animation.play();
            animationCount = false;
        }
    }

    public void bombUpdate2() {
        if (isPressed(KeyCode.SPACE)) {
            if (bombCount2) {
                bomb2 = new Bomb((int) player2.getTranslateX(), (int) player2.getTranslateY());
                bombCount2 = false;
                appRoot.getChildren().add(bomb2);
            }
        }
        if (appRoot.getChildren().contains(bomb2) && animationCount) {
            bomb2.animation.setCycleCount(2);
            bomb2.animation.setOnFinished(event -> {
                bombCount2 = true;
                animationCount2 = true;
                appRoot.getChildren().remove(bomb2);
                explosion = new Explosion((int) (bomb2.getTranslateX() - bomb2.getTranslateX() % 30),
                        (int) (bomb2.getTranslateY() - bomb2.getTranslateY() % 30));
                explosion.centralFire.animation.play();
                explosion.rightFire.animation.play();
                explosion.upperFire.animation.play();
                explosion.leftFire.animation.play();
                explosion.lowerFire.animation.play();
                if (explosion.lowerFire.getBoundsInParent().intersects(player.getBoundsInParent()) ||
                        explosion.centralFire.getBoundsInParent().intersects(player.getBoundsInParent()) ||
                        explosion.leftFire.getBoundsInParent().intersects(player.getBoundsInParent()) ||
                        explosion.upperFire.getBoundsInParent().intersects(player.getBoundsInParent()) ||
                        explosion.rightFire.getBoundsInParent().intersects(player.getBoundsInParent())) {
                    appRoot.getChildren().remove(player);
                    appRoot.getChildren().clear();
                    ImageView winner = new ImageView(backgroundImage2);
                    winner.setFitHeight(330);
                    winner.setFitWidth(660);
                    appRoot.getChildren().add(winner);
                }
                if (explosion.lowerFire.getBoundsInParent().intersects(player.getBoundsInParent()) ||
                        explosion.centralFire.getBoundsInParent().intersects(player2.getBoundsInParent()) ||
                        explosion.leftFire.getBoundsInParent().intersects(player2.getBoundsInParent()) ||
                        explosion.upperFire.getBoundsInParent().intersects(player2.getBoundsInParent()) ||
                        explosion.rightFire.getBoundsInParent().intersects(player2.getBoundsInParent())) {
                    appRoot.getChildren().remove(player2);
                    appRoot.getChildren().clear();
                    ImageView winner = new ImageView(backgroundImage3);
                    winner.setFitHeight(330);
                    winner.setFitWidth(660);
                    appRoot.getChildren().add(winner);
                }
            });
            bomb2.animation.play();
            animationCount2 = false;
        }
    }

    public void update() {
        if (isPressed(KeyCode.UP)) {
            player.animation.play();
            player.animation.setOffsetX(60);
            player.moveY(-3);

        } else if (isPressed(KeyCode.DOWN)) {
            player.animation.play();
            player.animation.setOffsetX(0);
            player.moveY(3);

        } else if (isPressed(KeyCode.RIGHT)) {
            player.animation.play();
            player.animation.setOffsetX(90);
            player.moveX(3);

        } else if (isPressed(KeyCode.LEFT)) {
            player.animation.play();
            player.animation.setOffsetX(30);
            player.moveX(-3);
        } else {
            player.animation.stop();
        }
    }

    public void update2() {
        if (isPressed(KeyCode.W)) {
            player2.animation.play();
            player2.animation.setOffsetX(60);
            player2.moveY(-3);

        } else if (isPressed(KeyCode.S)) {
            player2.animation.play();
            player2.animation.setOffsetX(0);
            player2.moveY(3);

        } else if (isPressed(KeyCode.D)) {
            player2.animation.play();
            player2.animation.setOffsetX(90);
            player2.moveX(3);

        } else if (isPressed(KeyCode.A)) {
            player2.animation.play();
            player2.animation.setOffsetX(30);
            player2.moveX(-3);
        } else {
            player2.animation.stop();
        }
    }

    public boolean isPressed(KeyCode key) {
        return keys.getOrDefault(key, false);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initContent();
        player.setTranslateX(40);
        player.setTranslateY(40);
        player2.setTranslateX(570);
        player2.setTranslateY(270);
        Scene scene = new Scene(appRoot, 630, 330);
        scene.setOnKeyPressed(event -> keys.put(event.getCode(), true));
        scene.setOnKeyReleased(event -> {
            keys.put(event.getCode(), false);
        });
        primaryStage.setTitle("Game");
        primaryStage.setScene(scene);
        primaryStage.show();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                bombUpdate();
                bombUpdate2();
                update();
                update2();
            }
        };
        timer.start();

    }

    public static void main(String[] args) {
        launch(args);
    }

}