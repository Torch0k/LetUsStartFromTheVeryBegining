package projectiles;

import java.awt.image.BufferedImage;

public abstract class Projectile {
    private int x;
    private int y;
    private int speed;
    private int damage;
    private static BufferedImage bulletImage;

    public Projectile(int x,int y,BufferedImage bulletImage){
        this.x = x;
        this.y = y;
        this.bulletImage = bulletImage;
    }

    public void FireLeft() {
        x -= speed;
    }
}
