import enemies.Enemy;
import projectiles.PlayerBullet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Renderer extends JPanel implements Runnable {

    private static Renderer instance;
    public static Renderer getInstance(){
        if (instance == null) {
            instance = new Renderer();
        }
        return instance;
    }
    private int FPS = 60;
    Thread gameThread;


    BackGroundImage backGroundImage;
    private JetShip jetShip = JetShip.getInstance();
    private KeyBoardListener keyBoardListener = KeyBoardListener.getInstance();
    private CollisionChecker collisionChecker = CollisionChecker.getInstance();


    public Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public int ScreenHeight = ScreenSize.height;
    public int ScreenWidth = ScreenSize.width;

    public int getScreenWidth() {
        return ScreenWidth;
    }

    public Renderer() {    //todo добавить ссылку на текущий левл и  в методе пейнт пройтись по всем обьектам ищ уровня и отрисовавть его
        startGameThread();


        backGroundImage = new BackGroundImage();
        setFocusable(true);
        addKeyListener(keyBoardListener);


    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void run(){
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while (gameThread != null){
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                if (remainingTime <  0){
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;


        backGroundImage.update();
        g.drawImage(backGroundImage.bgImage, backGroundImage.x, 0, backGroundImage.bgImage.getWidth(), ScreenHeight, null);


        //отрисовка корабля игрока
        jetShip.moveBy();
        g.drawImage(jetShip.JetShipTexture, jetShip.ShipX, jetShip.ShipY, null );



        // отрисовка пули игрока
        jetShip.fire();
        //заставляем все пули двигаться
        for (int i = 0; i < Level1.playerBullets.size(); i++) {
            PlayerBullet bullet = Level1.playerBullets.get(i);
            bullet.playerBulletFireRight();
            // отрисовываем все  пули
            g.drawImage(bullet.getPlayerBulletImage(), bullet.getX(), bullet.getY(), null);
        }



        // отрисовка всех врагов из списка врагов в левел
        for(int i = 0;i< Level1.enemies.size();i++){
            Enemy e = Level1.enemies.get(i);
            e.moveLeft();
            g.drawImage(e.getEnemyTexture(),e.getX(),e.getY(),null);

        }


        collisionChecker.CheckBulletCollision(Level1.playerBullets);


        graphics2D.dispose();

    }

}
