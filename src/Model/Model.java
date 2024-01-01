package Model;

import View.Panel;

import java.util.ArrayList;
import java.util.LinkedList;

public class Model {
    private final int MODEL_BOARD_SIZE = Panel.BOARD_SIZE / Panel.SQARE_SIZE;

    LinkedList<Square> snake;
    Direction direction;

    public Model() {
        snake = new LinkedList<>();

        snake.addFirst(new Square(5, 5));
        snake.addFirst(new Square(5, 6));
        snake.addFirst(new Square(5, 7));

        direction = Direction.DOWN;
    }

    public void move() {
        Square head = null;

        switch (direction){
            case Direction.UP -> head = new Square(snake.getLast().getX(), snake.getLast().getY() - 1);
            case Direction.DOWN -> head = new Square(snake.getLast().getX(), snake.getLast().getY() + 1);
            case Direction.LEFT -> head = new Square(snake.getLast().getX() - 1, snake.getLast().getY());
            case Direction.RIGHT -> head = new Square(snake.getLast().getX() + 1, snake.getLast().getY());
        }

        if(head.getX() < 0)
            head.setX(MODEL_BOARD_SIZE - 1);
        if(head.getY() < 0)
            head.setY(MODEL_BOARD_SIZE - 1);
        if(head.getX() >= MODEL_BOARD_SIZE)
            head.setX(0);
        if(head.getY() >= MODEL_BOARD_SIZE)
            head.setY(0);

        snake.addLast(head);
        snake.removeFirst();
    }

    public LinkedList<Square> getSnake() {
        return snake;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
