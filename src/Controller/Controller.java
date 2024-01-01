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

    int velocityX = 0;
    int velocityY = 1;

    private ActionListener actionListener;
    private KeyListener keyListener;

    Square head = new Square(5, 5);
    private LinkedList<Square> snake;

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
            theView.getGamePanel().repaint();
        }
    }

    class ControllerKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("apasat");

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
