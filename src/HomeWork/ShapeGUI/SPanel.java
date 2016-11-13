package HomeWork.ShapeGUI;

import HomeWork.ShapeGUI.Shape.*;
import HomeWork.ShapeGUI.Shape.Point;
import HomeWork.ShapeGUI.Shape.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by mcstarioni on 07.11.2016.
 */

public class SPanel extends JPanel implements ActionListener,KeyListener {
    protected Canvas canvas;
    protected boolean enterPressed;
    protected boolean moveMode;
    protected JLabel label;
    protected Thread thread;

    SPanel() {
        super();
        setLayout(new BorderLayout());
        Box topbox = Box.createHorizontalBox();
        SEnum[] figures = SEnum.values();
        HomeWork.ShapeGUI.Shape.Shape shape;
        for (int i = 0; i < figures.length; i++) {
            JButton jb = new JButton(figures[i].name());
            jb.setFocusable(false);
            shape = figures[i].getFigure(50);
            jb.addActionListener(this);
            jb.addActionListener(shape);
            topbox.add(jb);
        }
        Box bottom = Box.createHorizontalBox();
        Dimension d = topbox.getPreferredSize();
        d.height = 300;
        d.width += 10;
        Canvas canvas = new Canvas();
        canvas.setSize(d);
        Shape.setBasePanel(canvas);
        canvas.base = this;
        this.canvas = canvas;
        this.label = new JLabel("MOVE MODE OFF.");
        label.setForeground(Color.RED);
        moveMode = false;
        bottom.add(label);
        add(canvas, BorderLayout.CENTER);
        add(topbox, BorderLayout.NORTH);
        add(bottom, BorderLayout.SOUTH);
        setFocusable(true);
        addKeyListener(this);
        setPreferredSize(d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Dimension d = this.getSize();
        MoveablePoint point = new MoveablePoint(d.width / 2, d.height / 2, 0, 0, 1, 1);
        canvas.getDrawing().setPoint(point);
        canvas.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == 10 && !enterPressed)
        {
            enterPressed = true;
            setMoveMode(!isMoveMode());
        } else
        {
            if (moveMode) {
                System.out.println("SPanel  - " + key);
                switch (key) {
                    case (37): {
                        canvas.left = true;
                        break;
                    }
                    case (38): {
                        canvas.up = true;
                        break;
                    }
                    case (39): {
                        canvas.right = true;
                        break;
                    }
                    case (40): {
                        canvas.down = true;
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == 10) {
            enterPressed = false;
        } else
        {
            if (moveMode) {
                switch (key) {
                    case (37): {
                        canvas.left = false;
                        break;
                    }
                    case (38): {
                        canvas.up = false;
                        break;
                    }
                    case (39): {
                        canvas.right = false;
                        break;
                    }
                    case (40): {
                        canvas.down = false;
                        break;
                    }
                }
            }
        }
    }

    public boolean isMoveMode() {
        return moveMode;
    }

    public void setMoveMode(boolean value) {
        if (value) {
            System.out.println((char)27+"[31mStart thread"+(char)27+"[0m");
            moveMode = true;
            label.setForeground(Color.GREEN);
            label.setText("MOVE MODE ON");
            thread = new Thread(canvas);
            canvas.thread = thread;
            thread.start();
        } else {
            System.out.println((char)27+"[31mStop thread"+(char)27+"[0m");
            thread.interrupt();
            moveMode = false;
            label.setForeground(Color.RED);
            label.setText("MOVE MODE OFF");
        }
    }
}