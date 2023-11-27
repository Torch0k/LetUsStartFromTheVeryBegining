import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackGroundImage {    //todo добавить чтото на передний фон как бы между кораблем и камерой облакуа пыль и оно быстрее плывет нежели задний фон
    public BufferedImage bgImage;
    public int x;
    private int speed;  // ƒобавьте переменную дл€ скорости движени€

    public BackGroundImage() {
        x = 0;
        speed = 1;  // ”становите скорость движени€
        try {
            bgImage = ImageIO.read(new File("src/textures/Level1BG.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update() {
        x -= speed;  // »зменение координаты x с учетом скорости
        if (x <= -bgImage.getWidth()) {
            x = 0;
        }

    }
}

