package HomeWork.ShapeGUI.Shape;

import HomeWork.ShapeGUI.*;
import HomeWork.ShapeGUI.Canvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Макс on 05.10.2016.
 */
public abstract class Shape implements Moveable, ActionListener
{
    protected Color color;
    protected MoveablePoint point;
    protected static Canvas basePanel;
    protected boolean filled;
    protected boolean isVisible;
    public boolean isStanding()
    {
        if (point.getVelocity().X == 0 && point.getVelocity().Y == 0)
        {
            return true;
        }else
        {
            return false;
        }
    }
    public Shape()
    {
        color = Color.BLUE;
        this.isVisible = false;
        point = new MoveablePoint(0,0,0,0,0,0);
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
    public static Canvas getBasePanel()
    {
        return basePanel;
    }
    public static void setBasePanel(Canvas base)
    {
        basePanel = base;
    }
    public abstract void draw(Graphics g);
    public void moveUp()
    {
        point.moveUp();
        draw(basePanel.getGraphics());


    }
    public void moveDown()
    {
        point.moveDown();
        System.out.println("Draw down");
        draw(basePanel.getGraphics());
    }
    public void moveRight()
    {
        point.moveRight();
        draw(basePanel.getGraphics());
    }
    public void moveLeft()
    {
        point.moveLeft();
        draw(basePanel.getGraphics());
    }
    public void moveX()
    {
        point.moveX();
        draw(basePanel.getGraphics());
    }
    public void moveY()
    {
        point.moveY();
        draw(basePanel.getGraphics());
    }
    public boolean isVisible()
    {
        return isVisible;
    }
    public void setVisible(boolean visible)
    {
        isVisible = visible;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        basePanel.setDrawing(this);
        setPoint(basePanel.getPoint());
        basePanel.repaint();
    }
}
