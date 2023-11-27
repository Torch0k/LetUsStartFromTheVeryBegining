import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardListener implements KeyListener {

    public boolean  up , down , right , left, fire;

    private boolean isUpPressed, isDownPressed, isRightPressed, isLeftPressed, isFirePressed;



    private static KeyBoardListener instance;
    public static KeyBoardListener getInstance() {
        if (instance == null) {
            instance = new KeyBoardListener();
        }
        return instance;
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        // устанавливаем состояние только для нажатой клавиши
        if (code == KeyEvent.VK_D) {
            isRightPressed = true;
        } else if (code == KeyEvent.VK_W) {
            isUpPressed = true;
        } else if (code == KeyEvent.VK_S) {
            isDownPressed = true;
        } else if (code == KeyEvent.VK_A) {
            isLeftPressed = true;
        } else if (code == KeyEvent.VK_SPACE) {
            isFirePressed = true;
        }

        // устанавливаем состояние общих переменных
        updateState();
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();
        // сбрасываем состояние только для отпущенной клавиши
        if (code == KeyEvent.VK_D) {
            isRightPressed = false;
        } else if (code == KeyEvent.VK_W) {
            isUpPressed = false;
        } else if (code == KeyEvent.VK_S) {
            isDownPressed = false;
        } else if (code == KeyEvent.VK_A) {
            isLeftPressed = false;
        } else if (code == KeyEvent.VK_SPACE) {
            isFirePressed = false;
        }

        // устанавливаем состояние общих переменных
        updateState();
    }
    private void updateState() {
        up = isUpPressed;
        down = isDownPressed;
        right = isRightPressed;
        left = isLeftPressed;
        fire = isFirePressed;
    }
}
