package enemies;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BombJet extends Enemy{
    public static BufferedImage enemyTexture;
    static {
        try{ enemyTexture = ImageIO.read(new File("src/textures/BobmFU.png"));

    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    }
    public BombJet( int x, int y) {
        super( x, y, enemyTexture);
        health = 5;
        speed = 6;

    }
}
