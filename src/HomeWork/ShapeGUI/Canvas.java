package HomeWork.ShapeGUI;

import HomeWork.ShapeGUI.Shape.*;
import HomeWork.ShapeGUI.Shape.Point;
import HomeWork.ShapeGUI.Shape.Shape;

import javax.swing.*;
import java.awt.*;
import static java.lang.Thread.sleep;

/**
 * Created by mcstarioni on 12.11.2016.
 */
public class Canvas extends JPanel implements Runnable {
    protected MoveablePoint point;
    protected Shape drawing;
    protected SPanel base;
    protected Thread thread;
    protected final double A = 1;
    boolean up = false;
    boolean down = false;
    boolean right = false;
    boolean left = false;
    public Shape getDrawing()
    {
        return drawing;
    }
    public void setDrawing(Shape drawing)
    {
        this.drawing = drawing;
    }
    public MoveablePoint getPoint()
    {
        return point;
    }
    public void setPoint(MoveablePoint point)
    {
        this.point = point;
    }
    public Canvas()
    {
        super();
        this.drawing = null;
        System.out.println("Created Canvas");
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        if(drawing!= null)
        {
            Dimension d = this.getSize();
            drawing.draw(g);
        }
    }
    public void move()
    {
        if (left && !right)
        {
            drawing.getPoint().getAcceleration().setX(1);
            drawing.moveX();
        }
        if (!left && right)
        {
            drawing.moveRight();
        }
        if (up && !down)
        {
            drawing.moveUp();
        }
        if (!up && down)
        {
            drawing.moveDown();
        }
        if (!left && !right && (int)drawing.getPoint().getVelocity().X() != 0)
            inertionMoveX();
        if (!up && !right && (int)drawing.getPoint().getVelocity().Y() != 0)
            inertionMoveY();
    }
    public void inertionMoveX()
    {
        int dir = (int)drawing.getPoint().getVelocity().X();
        if (dir > 1)
        {
            drawing.getPoint().getAcceleration().setX(-A);
        }
        else
        {
            drawing.getPoint().getAcceleration().setX(A);
        }
        drawing.moveX();
        if ((int)drawing.getPoint().getVelocity().X() == 0)
        {
            drawing.getPoint().getAcceleration().setX(0);
        }
    }
    public void inertionMoveY()
    {
        int dir = (int)drawing.getPoint().getVelocity().Y();
        if (dir > 1)
        {
            drawing.getPoint().getAcceleration().setY(A);
        }
        else
        {
            drawing.getPoint().getAcceleration().setY(A);
        }
        drawing.moveY();
        if ((int)drawing.getPoint().getVelocity().Y() == 0)
        {
            drawing.getPoint().getAcceleration().setY(0);
        }
    }
    @Override
    public void run()
    {
        if (drawing!=null) {
            while (true) {
                move();
                repaint();
                try {
                    sleep(40);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
        System.out.println("Thread finished" + (char) 27 + "[0m");
    }
}
