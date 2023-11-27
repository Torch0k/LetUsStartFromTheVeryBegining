import projectiles.PlayerBullet;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JetShip {

    private static JetShip instance;
    public static JetShip getInstance(){
        if(instance == null){
            instance = new JetShip();
        }
        return instance;
    }

    public int ShipX;
    public int ShipY;
    public int health;
    public int speed;
    public BufferedImage JetShipTexture;
    Renderer renderer;
    private KeyBoardListener keyBoardListener = KeyBoardListener.getInstance();


    private Timer fireTimer;
    private static final int FIRE_DELAY = 500;




    public JetShip(){




        ShipX = 100;
        ShipY = 100;
        speed = 3;
        health = 100;


        try{ JetShipTexture = ImageIO.read(new File("src/textures/JetShip.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        fireTimer = new Timer(FIRE_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keyBoardListener.fire = false;
            }
        });
        fireTimer.setRepeats(false); // Остановить таймер после первого срабатывания
    }


    public void moveBy(){
        if (keyBoardListener.up ==  true){
            ShipY -=   speed;
        }
         else if (keyBoardListener.down ==  true){
            ShipY += speed;
        }
        else if (keyBoardListener.left ==  true){
            ShipX -= speed;
        }
        else if (keyBoardListener.right ==  true){
            ShipX += speed;
        }

    }

    public void fire() {
        if (keyBoardListener.fire && !fireTimer.isRunning()) {
            PlayerBullet bullet = new PlayerBullet(ShipX + 50, ShipY + 16);
            Level1.playerBullets.add(bullet);
            fireTimer.start(); // Запустить таймер после каждого выстрела
        }
    }

}
