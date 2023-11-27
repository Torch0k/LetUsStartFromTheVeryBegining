package enemies;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EnemyJetViolet extends Enemy{


    public static BufferedImage enemyTexture;
    static {
        try {
            enemyTexture = ImageIO.read(new File("src/textures/VioletJet.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public EnemyJetViolet(int x, int y) {
        super(x, y, enemyTexture);
        health = 10;
        speed = 3;
    }


}
