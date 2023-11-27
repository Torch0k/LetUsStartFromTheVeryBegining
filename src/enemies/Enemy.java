package enemies;

import javax.swing.*;
import java.awt.image.BufferedImage;

public abstract class Enemy {
       public int x;
       public int y;
       public int speed;



       public int health;
       public boolean RandomSpawn;
       public boolean isSolid;

       public BufferedImage enemyTexture;

       public Enemy(int x ,int y,BufferedImage enemyTexture){

              this.enemyTexture = enemyTexture;
              this.x = x;
              this.y = y;

       }
       // геттеры и сеттеры
       public void moveLeft(){
              //System.out.println("Enemy moveLeft: speed=" + speed + ", x=" + x);
              x -= speed;
       }
       public int getX() {
              return x;
       }

       public int getY() {
              return y;
       }

       public BufferedImage getEnemyTexture() {
              return enemyTexture;
       }

}
