import enemies.Enemy;
import enemies.EnemyJetViolet;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Spawner {

    private Timer timer;
    public Spawner() {
        // ������� ������
        timer = new Timer();

        // ��������� ������, ����� ������ ������� ��������� ����� enemySpawn()
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                enemySpawn();
            }
        }, 0, 1000); // 1000 ����������� = 1 �������
    }

    public void enemySpawn(){
        Random random = new Random();

        // ���������� ���������� �������� x � y � �������� ����������
        int x = random.nextInt(1001) + 2000;  // �������� �� 2000 �� 3000 (������������)
        int y = random.nextInt(1201);         // �������� �� 0 �� 1200 (������������)

        // ������������� �������� x � y ��� EnemyJetViolet


        Enemy enemy = new EnemyJetViolet(x,y);
        Level1.enemies.add(enemy);
    }


}
