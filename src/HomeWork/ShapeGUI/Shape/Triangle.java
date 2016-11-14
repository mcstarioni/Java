package HomeWork.ShapeGUI.Shape;

import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by mcstarioni on 06.11.2016.
 */
public class Triangle extends Shape
{
    protected Point p1;
    protected Point p2;
    protected Point p3;
    double radius;
    public Triangle(double rad)
    {
        radius = rad;
        p1 = new Point(0,0);
        p2 = new Point(0,0);
        p3 = new Point(0,0);
    }
    @Override
    public double getArea()
    {
        return 0;
    }

    @Override
    public double getPerimeter()
    {
        return 0;
    }

    @Override
    public String toString()
    {
        return null;
    }

    @Override
    public void draw(Graphics g)
    {

        g.setColor(this.color);
        p1.setX(point.getCoordinate().X());
        p1.setY(point.getCoordinate().Y() - radius);
        p2.setX(point.getCoordinate().X() - radius/(3*Math.tan(Math.PI/6)));
        p2.setY(point.getCoordinate().Y() + radius/3);
        p3.setX(point.getCoordinate().X() + radius/(3*Math.tan(Math.PI/6)));
        p3.setY(point.getCoordinate().Y() + radius/3);
        int[] arrX = {(int)p1.X(),(int)p2.X(),(int)p3.X()};
        int[] arrY = {(int)p1.Y(),(int)p2.Y(),(int)p3.Y()};
        g.fillPolygon(arrX,arrY,3);
        g.setColor(Color.BLACK);
        g.drawPolyline(arrX,arrY,3);
        System.out.println("Triangle");
    }
}
