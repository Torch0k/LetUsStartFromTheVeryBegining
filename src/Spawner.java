import enemies.Enemy;
import enemies.EnemyJetViolet;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Spawner {

    private Timer timer;
    public Spawner() {
        // Создаем таймер
        timer = new Timer();

        // Запускаем таймер, чтобы каждую секунду вызывался метод enemySpawn()
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                enemySpawn();
            }
        }, 0, 1000); // 1000 миллисекунд = 1 секунда
    }

    public void enemySpawn(){
        Random random = new Random();

        // Генерируем орандомные значения x и y в заданных диапазонах
        int x = random.nextInt(1001) + 2000;  // Значения от 2000 до 3000 (включительно)
        int y = random.nextInt(1201);         // Значения от 0 до 1200 (включительно)

        // Устанавливаем значения x и y для EnemyJetViolet


        Enemy enemy = new EnemyJetViolet(x,y);
        Level1.enemies.add(enemy);
    }


}
