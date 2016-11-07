package HomeWork.ShapeGUI.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Макс on 05.10.2016.
 */
public abstract class Shape implements Moveable,ActionListener
{
    protected Color color;
    protected MoveablePoint point;
    protected JPanel basePanel;
    protected boolean filled;
    public Shape()
    {
        color = Color.BLUE;
    }
    public Shape(Color color, boolean filled)
    {
        this.color = color;
        this.filled = filled;
    }
    public Color getColor()
    {
        return this.color;
    }
    public void setColor(Color color)
    {
        this.color = color;
    }
    public boolean isFilled()
    {
        return filled;
    }
    public void setFilled(boolean filled)
    {
        this.filled = filled;
    }
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract String toString();
    public MoveablePoint getPoint()
    {
        return point;
    }

    public void setPoint(MoveablePoint point)
    {
        this.point = point;
    }

    public JPanel getBaseFrame()
    {
        return basePanel;
    }

    public void setBaseFrame(JPanel base)
    {
        this.basePanel = base;
    }
    public void moveUp()
    {
        point.moveUp();
    }
    public void moveDown()
    {
        point.moveDown();
    }
    public void moveRight()
    {
        point.moveRight();
    }
    public void moveLeft()
    {
        point.moveLeft();
    }
}
