import enemies.BombJet;
import enemies.Enemy;
import enemies.EnemyJetViolet;
import projectiles.PlayerBullet;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

public class Level1 extends JFrame {

        private static Level1 instance;
        private Level1 getInstance(){
            if(instance ==  null){
            instance = new Level1();
            }
            return instance;
    }
        public static LinkedList<Enemy> enemies;
        public static LinkedList<PlayerBullet> playerBullets;

       // private KeyBoardListener keyBoardListener = KeyBoardListener.getInstance();
       // private JetShip jetShip = JetShip.getInstance();
        private Renderer renderer = Renderer.getInstance();





        Spawner spawner = new Spawner();
        public Level1(){



            enemies = new LinkedList<>();
            // добавить врагов ручками
            enemies.add(new EnemyJetViolet(500,360));
            enemies.add(new BombJet(700,420));

            //спавнер
                spawner.enemySpawn();

            //добавляем пули на уровень
            playerBullets = new LinkedList<>();


            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(renderer.ScreenWidth, renderer.ScreenHeight);
            setLocationRelativeTo(null);






            add(renderer);
           // renderer.requestFocusInWindow();



            setVisible(true);

            renderer.startGameThread();

        }

}
