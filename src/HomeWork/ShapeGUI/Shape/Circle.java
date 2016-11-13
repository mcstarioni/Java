package HomeWork.ShapeGUI.Shape;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Макс on 05.10.2016.
 */
public class Circle extends Shape
{
    protected double radius;
    public Circle()
    {
        super();
    }
    public Circle(double radius)
    {
        this.radius = radius;
    }
    public Circle(double radius, Color color, boolean filled)
    {
        super(color,filled);
        this.radius = radius;
    }

    @Override
    public double getArea()
    {
        return Math.PI*radius*radius;
    }

    @Override
    public double getPerimeter()
    {
        return 2*Math.PI*radius;
    }

    @Override
    public String toString()
    {
        String s = "Circle: " + color.toString();
        return s + "\nArea - " + getArea() + "\nPerimeter - " + getPerimeter();
    }
    @Override
    public void draw(Graphics g)
    {
        g.setColor(this.color);
        //this.point = basePanel.getPoint();
        int rad = (int)this.radius;
        g.fillOval((int) point.getX() - rad, (int) point.getY() - rad, 2 * rad, 2 * rad);
        g.setColor(Color.BLACK);
        g.drawOval((int) point.getX() - rad, (int) point.getY() - rad, 2 * rad, 2 * rad);
        System.out.println("Circle");
    }
}
