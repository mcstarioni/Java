package HomeWork.ShapeGUI.Shape;

import HomeWork.ShapeGUI.SPanel;

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
    protected static SPanel basePanel;
    protected boolean filled;
    protected boolean isVisible;
    public Shape()
    {
        color = Color.BLUE;
        this.isVisible = false;
        point = new MoveablePoint(0,0,0,0);
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

    public static JPanel getBasePanel()
    {
        return basePanel;
    }

    public static void setBasePanel(SPanel base)
    {
        basePanel = base;
    }
    public abstract void draw(Graphics g);
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

    public boolean isVisible()
    {
        return isVisible;
    }

    public void setVisible(boolean visible)
    {
        isVisible = visible;
    }

    public void moveLeft()
    {
        point.moveLeft();
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        basePanel.setDrawing(this);
        basePanel.repaint();
        //draw(basePanel.getGraphics());
    }
}
