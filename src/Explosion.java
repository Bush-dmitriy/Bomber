
import java.util.HashMap;

public class Explosion {
    private HashMap<Fire, Boolean> fires = new HashMap<>();
    Fire leftFire;
    Fire rightFire;
    Fire upperFire;
    Fire lowerFire;
    Fire centralFire;


    public Explosion(int x, int y) {
        centralFire = new Fire(x + 2, y + 2, 28, 28);
        leftFire = new Fire(x - Main.BLOCK_SIZE + 6, y + 2, 0, 28);
        rightFire = new Fire(x + Main.BLOCK_SIZE - 6, y + 2, 56, 28);
        upperFire = new Fire(x + 2, y - Main.BLOCK_SIZE + 6, 28, 0);
        lowerFire = new Fire(x + 2, y + Main.BLOCK_SIZE - 6, 28, 56);


        fires.put(centralFire, true);
        fires.put(leftFire, true);
        fires.put(rightFire, true);
        fires.put(upperFire, true);
        fires.put(lowerFire, true);


        Main.appRoot.getChildren().add(centralFire);


        for (Block platform : Main.platforms) {
            if (leftFire.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                fires.put(leftFire, false);
                if (platform.destructibility) {
                    Main.platforms.remove(platform);
                    Main.appRoot.getChildren().add(leftFire);
                    Main.appRoot.getChildren().remove(platform);
                }
                break;
            }
        }
        if (fires.get(leftFire)) {
            Main.appRoot.getChildren().add(leftFire);
        }


        for (Block platform : Main.platforms) {
            if (rightFire.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                fires.put(rightFire, false);
                if (platform.destructibility) {
                    Main.appRoot.getChildren().add(rightFire);
                    Main.platforms.remove(platform);
                    Main.appRoot.getChildren().remove(platform);
                }
                break;
            }
        }
        if (fires.get(rightFire)) {
            Main.appRoot.getChildren().add(rightFire);
        }

        for (Block platform : Main.platforms) {
            if (upperFire.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                fires.put(upperFire, false);
                if (platform.destructibility) {
                    Main.appRoot.getChildren().add(upperFire);
                    Main.platforms.remove(platform);
                    Main.appRoot.getChildren().remove(platform);
                }
                break;
            }
        }
        if (fires.get(upperFire)) {
            Main.appRoot.getChildren().add(upperFire);
        }

        for (Block platform : Main.platforms) {
            if (lowerFire.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                fires.put(lowerFire, false);
                if (platform.destructibility) {
                    Main.appRoot.getChildren().add(lowerFire);
                    Main.platforms.remove(platform);
                    Main.appRoot.getChildren().remove(platform);
                }
                break;
            }
        }
        if (fires.get(lowerFire)) {
            Main.appRoot.getChildren().add(lowerFire);
        }
    }
}
