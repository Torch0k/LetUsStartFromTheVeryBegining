import enemies.Enemy;
import projectiles.PlayerBullet;

import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.List;

public class CollisionChecker {

    private static CollisionChecker instance;
    static CollisionChecker getInstance(){
        if(instance == null){
            instance = new CollisionChecker();
        }
        return instance;
    }



    public CollisionChecker(){

    }
    public void CheckBulletCollision(List<PlayerBullet> playerBullets) {
        Iterator<PlayerBullet> bulletIterator = playerBullets.iterator();

        while (bulletIterator.hasNext()) {
            PlayerBullet playerBullet = bulletIterator.next();

            // Проверка столкновения пули с каждым врагом
            Iterator<Enemy> enemyIterator = Level1.enemies.iterator();

            while (enemyIterator.hasNext()) {
                Enemy enemy = enemyIterator.next();

                int bulletX = playerBullet.getX();
                int bulletY = playerBullet.getY();
                int bulletWidth = playerBullet.getPlayerBulletImage().getWidth();
                int bulletHeight = playerBullet.getPlayerBulletImage().getHeight();

                int enemyX = enemy.getX();
                int enemyY = enemy.getY();
                int enemyWidth = enemy.getEnemyTexture().getWidth();
                int enemyHeight = enemy.getEnemyTexture().getHeight();

                // Проверка столкновения по текстурам
                boolean collision = checkCollision(
                        playerBullet.getPlayerBulletImage(), bulletX, bulletY,
                        enemy.getEnemyTexture(), enemyX, enemyY,
                        bulletWidth, bulletHeight, enemyWidth, enemyHeight
                );

                // Если есть столкновение, удаляем пулю и врага
                if (collision) {
                    bulletIterator.remove(); // Удаление пули
                    enemyIterator.remove();  // Удаление врага
                }
            }
        }
    }

    // Метод для проверки столкновения по текстурам
    private boolean checkCollision(BufferedImage texture1, int x1, int y1, BufferedImage texture2, int x2, int y2, int width1, int height1, int width2, int height2) {
        // Границы области пересечения текстур
        int xMin = Math.max(x1, x2);
        int xMax = Math.min(x1 + width1, x2 + width2);
        int yMin = Math.max(y1, y2);
        int yMax = Math.min(y1 + height1, y2 + height2);

        // Проверяем каждый пиксель в области пересечения на наличие столкновения
        for (int i = xMin; i < xMax; i++) {
            for (int j = yMin; j < yMax; j++) {
                int pixel1 = texture1.getRGB(i - x1, j - y1);
                int pixel2 = texture2.getRGB(i - x2, j - y2);

                // Если оба пикселя не прозрачны, то есть столкновение
                if ((pixel1 & 0xFF000000) != 0 && (pixel2 & 0xFF000000) != 0) {
                    System.out.println("я столкнулся");

                    return true; // Столкновение

                }
            }
        }

        return false; // Нет столкновения
    }

}
