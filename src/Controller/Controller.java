package Controller;

import Model.Model;
import View.View;
import Model.Square;
import Model.Direction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class Controller {
    Timer loop;
    private View theView;
    private Model theModel;
    private ActionListener actionListener;
    private KeyListener keyListener;
    private LinkedList<Square> snake;
    private Square food;

    public Controller(View theView, Model theModel) {
        this.theView = theView;
        this.theModel = theModel;

        actionListener = new ControllerActionListener();
        keyListener = new ControllerKeyListener();

        loop = new Timer(100, actionListener);
        loop.start();

        theView.addKeyListener(keyListener);

        snake = theModel.getSnake();
        theView.setSnake(snake);
    }

    class ControllerActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theModel.move();
            snake = theModel.getSnake();
            theView.setSnake(snake);
            food = theModel.getFood();
            theView.setFood(food);
            theView.getGamePanel().repaint();

            if (theModel.isGameOver()) {
                loop.stop();
            }
        }
    }

    class ControllerKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP -> theModel.setDirection(Direction.UP);
                case KeyEvent.VK_DOWN -> theModel.setDirection(Direction.DOWN);
                case KeyEvent.VK_LEFT -> theModel.setDirection(Direction.LEFT);
                case KeyEvent.VK_RIGHT -> theModel.setDirection(Direction.RIGHT);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
