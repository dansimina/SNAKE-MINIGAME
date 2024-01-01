package View;

import Model.Square;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class Panel extends JPanel {
    public static final int BOARD_SIZE = 500;
    public static final int SQARE_SIZE = 20;
    Square food;

    private LinkedList<Square> snake;

    public Panel() {
        setPreferredSize(new Dimension(BOARD_SIZE, BOARD_SIZE));
        setBackground(Color.BLACK);

        food = new Square(10, 10);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        for (int i = 0; i < BOARD_SIZE / SQARE_SIZE; i++) {
            graphics.drawLine(i * SQARE_SIZE, 0, i * SQARE_SIZE, BOARD_SIZE);
            graphics.drawLine(0, i * SQARE_SIZE, BOARD_SIZE, i * SQARE_SIZE);
        }

        graphics.setColor(Color.WHITE);

        if(!snake.isEmpty()) {
            for(Square sqare: snake) {
                graphics.fillRect(sqare.getX() * SQARE_SIZE, sqare.getY() * SQARE_SIZE, SQARE_SIZE, SQARE_SIZE);
            }
        }


//        food.setX(new Random().nextInt(BOARD_SIZE / SQARE_SIZE));
//        food.setY(new Random().nextInt(BOARD_SIZE / SQARE_SIZE));
//        graphics.setColor(Color.RED);
//        graphics.fillOval(food.getX() * SQARE_SIZE, food.getY() * SQARE_SIZE, SQARE_SIZE, SQARE_SIZE);
    }

    public void setSnake(LinkedList<Square> snake) {
        this.snake = snake;
    }
}
