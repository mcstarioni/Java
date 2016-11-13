package HomeWork.ShapeGUI;

import HomeWork.ShapeGUI.Shape.*;
import HomeWork.ShapeGUI.Shape.Point;
import HomeWork.ShapeGUI.Shape.Shape;

import javax.swing.*;
import java.awt.*;

import static java.lang.Math.tan;
import static java.lang.Thread.sleep;
import java.math.*;

/**
 * Created by mcstarioni on 12.11.2016.
 */
public class Canvas extends JPanel implements Runnable {
    protected MoveablePoint point;
    protected Shape drawing;
    protected SPanel base;
    protected Thread thread;
    protected final double A = 0.3;
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
            drawing.getPoint().getAcceleration().setX(-A);
            drawing.moveX();
        }
        if (!left && right)
        {
            drawing.getPoint().getAcceleration().setX(A);
            drawing.moveX();
        }
        if (up && !down)
        {
            drawing.getPoint().getAcceleration().setY(-A);
            drawing.moveY();
        }
        if (!up && down)
        {
            drawing.getPoint().getAcceleration().setY(A);
            drawing.moveY();
        }
        if (!left && !right && (int)drawing.getPoint().getVelocity().X() != 0)
            inertionMoveX();
        if (!up && !down && (int)drawing.getPoint().getVelocity().Y() != 0)
            inertionMoveY();
    }
    public void inertionMoveX()
    {
        double dir = drawing.getPoint().getVelocity().X();
        double alfa = drawing.getPoint().getVelocity().Y()/dir;
        if ((int)dir > 0)
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
        double dir = drawing.getPoint().getVelocity().Y();
        //double alfa = dir/drawing.getPoint().getVelocity().X();
        if ((int)dir > 0)
        {
            drawing.getPoint().getAcceleration().setY(-A);
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
                    sleep(25);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
        System.out.println("Thread finished" + (char) 27 + "[0m");
    }
}
