package projectiles;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PlayerBullet {


    public  int x;
    public  int y;
    public  int speed;
    public  BufferedImage playerBulletImage;

    public PlayerBullet(int startX, int startY) {
        x = startX;
        y = startY;
        speed = 12;
        try{ playerBulletImage = ImageIO.read(new File("src/textures/Bullet.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public  int getX() {
        return x;
    }

    public  int getY() {
        return y;
    }

    public  void playerBulletFireRight() {
        x += speed;
    }


        // геттеры и сеттеры
    public  BufferedImage getPlayerBulletImage() {
        return playerBulletImage;
    }
}
