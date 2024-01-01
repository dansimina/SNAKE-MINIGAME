package View;

import Model.Square;

import javax.swing.*;
import java.util.LinkedList;

public class View extends JFrame {
    public static int BOARD_SIZE = 500;
    Panel gamePanel;

    public View() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(BOARD_SIZE, BOARD_SIZE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);


        gamePanel = new Panel();

        this.add(gamePanel);
        this.pack();
    }

    public Panel getGamePanel() {
        return gamePanel;
    }

    public void setSnake(LinkedList<Square> snake) {
        gamePanel.setSnake(snake);
    }

    public void setFood(Square food) {
        gamePanel.setFood(food);
    }
}
