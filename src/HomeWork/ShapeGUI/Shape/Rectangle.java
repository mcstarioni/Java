package HomeWork.ShapeGUI.Shape;

import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Макс on 05.10.2016.
 */
public class Rectangle extends Shape
{
    protected double width;
    protected double height;
    public Rectangle()
    {
        super();
    }

    @Override
    public double getArea()
    {
        return width*height;
    }

    @Override
    public double getPerimeter()
    {
        return 2*(width+height);
    }

    @Override
    public String toString()
    {
        String s = "Rectangle: " + color.toString();
        return s + "\nPerimeter - "+ getPerimeter() + "\nArea - " + getArea();
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(this.color);
        this.point = basePanel.getPoint();
        g.fillRect(point.getX() - (int)width/2,point.getY() - (int)height/2,(int)width,(int)height);
        System.out.println("Rectangle");
    }

    public Rectangle(double width,double height)
    {
        super();
        this.height = height;
        this.width = width;
    }
    public Rectangle(double width, double height, Color color, boolean filled)
    {
        super(color, filled);
        this.height = height;
        this.width = width;
    }
    public double getWidth()
    {
        return width;
    }
    public void setWidth(double width)
    {
        this.width = width;
    }
    public double getHeight()
    {
        return height;
    }
    public void setHeight(double height)
    {
        this.height = height;
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
}
