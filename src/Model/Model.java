package Model;

import View.Panel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

public class Model {
    private final int MODEL_BOARD_SIZE = Panel.BOARD_SIZE / Panel.SQARE_SIZE;
    boolean gameOver;
    LinkedList<Square> snake;
    Square food;
    Direction direction;
    HashSet<Square> snakeBody;

    public Model() {
        snake = new LinkedList<>();
        snakeBody = new HashSet<>();

        gameOver = false;

        snake.addFirst(new Square(5, 5));
        snake.addFirst(new Square(5, 6));
        snake.addFirst(new Square(5, 7));

        food = new Square(20, 20);

        direction = Direction.DOWN;
    }

    public void move() {
        Square head = null;

        switch (direction) {
            case Direction.UP -> head = new Square(snake.getLast().getX(), snake.getLast().getY() - 1);
            case Direction.DOWN -> head = new Square(snake.getLast().getX(), snake.getLast().getY() + 1);
            case Direction.LEFT -> head = new Square(snake.getLast().getX() - 1, snake.getLast().getY());
            case Direction.RIGHT -> head = new Square(snake.getLast().getX() + 1, snake.getLast().getY());
        }

        if (head.getX() < 0)
            head.setX(MODEL_BOARD_SIZE - 1);
        if (head.getY() < 0)
            head.setY(MODEL_BOARD_SIZE - 1);
        if (head.getX() >= MODEL_BOARD_SIZE)
            head.setX(0);
        if (head.getY() >= MODEL_BOARD_SIZE)
            head.setY(0);

        if (head.compareTo(food) == 0)
        {
            food.setX(new Random().nextInt(MODEL_BOARD_SIZE));
            food.setY(new Random().nextInt(MODEL_BOARD_SIZE));

            while(snakeBody.contains(food)) {
                food.setX(new Random().nextInt(MODEL_BOARD_SIZE));
                food.setY(new Random().nextInt(MODEL_BOARD_SIZE));
            }
        }
        else{
            snakeBody.remove(snake.getFirst());
            snake.removeFirst();
        }

        if(!snakeBody.isEmpty() && snakeBody.contains(head))
            gameOver = true;

        snake.addLast(head);
        snakeBody.add(head);
    }

    public LinkedList<Square> getSnake() {
        return snake;
    }

    public Direction getDirection() {
        return direction;
    }

    public Square getFood() {
        return food;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setDirection(Direction direction) {
        if (this.direction == Direction.UP && direction == Direction.DOWN)
            return;
        if (this.direction == Direction.DOWN && direction == Direction.UP)
            return;
        if (this.direction == Direction.LEFT && direction == Direction.RIGHT)
            return;
        if (this.direction == Direction.RIGHT && direction == Direction.LEFT)
            return;

        this.direction = direction;
    }
}
