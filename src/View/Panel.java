package View;

import Model.Square;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Panel extends JPanel {
    public static final int BOARD_SIZE = 500;
    public static final int SQARE_SIZE = 20;
    Square food;
    private LinkedList<Square> snake;

    public Panel() {
        setPreferredSize(new Dimension(BOARD_SIZE, BOARD_SIZE));
        setBackground(Color.BLACK);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        for (int i = 0; i < BOARD_SIZE / SQARE_SIZE; i++) {
            graphics.drawLine(i * SQARE_SIZE, 0, i * SQARE_SIZE, BOARD_SIZE);
            graphics.drawLine(0, i * SQARE_SIZE, BOARD_SIZE, i * SQARE_SIZE);
        }

        graphics.setColor(Color.WHITE);

        if(snake != null &&  !snake.isEmpty()) {
            for(Square square: snake) {
                if(square.equals(snake.getLast())){
                    graphics.setColor(Color.GRAY);
                }
                graphics.fillRect(square.getX() * SQARE_SIZE, square.getY() * SQARE_SIZE, SQARE_SIZE, SQARE_SIZE);
            }
        }

        if(food != null) {
            graphics.setColor(Color.WHITE);
            graphics.fillOval(food.getX() * SQARE_SIZE, food.getY() * SQARE_SIZE, SQARE_SIZE, SQARE_SIZE);
        }

    }

    public void setSnake(LinkedList<Square> snake) {
        this.snake = snake;
    }

    public void setFood(Square food) {
        this.food = food;
    }
}
