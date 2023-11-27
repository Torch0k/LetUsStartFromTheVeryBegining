import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackGroundImage {    //todo �������� ����� �� �������� ��� ��� �� ����� �������� � ������� ������� ���� � ��� ������� ������ ������ ������ ���
    public BufferedImage bgImage;
    public int x;
    private int speed;  // �������� ���������� ��� �������� ��������

    public BackGroundImage() {
        x = 0;
        speed = 1;  // ���������� �������� ��������
        try {
            bgImage = ImageIO.read(new File("src/textures/Level1BG.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update() {
        x -= speed;  // ��������� ���������� x � ������ ��������
        if (x <= -bgImage.getWidth()) {
            x = 0;
        }

    }
}

