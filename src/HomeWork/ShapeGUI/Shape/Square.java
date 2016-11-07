package HomeWork.ShapeGUI.Shape;

import java.awt.*;

/**
 * Created by Макс on 05.10.2016.
 */
public class Square extends Rectangle
{
    public Square()
    {
        super();
    }
    public Square(double side)
    {
        super(side,side);
    }
    public Square(double side, Color color, boolean filled)
    {
        super(side,side,color,filled);
    }
    public double getSide()
    {
        return height;
    }
    public void setSide(double side)
    {
        this.height = this.width = side;
    }
    public String toString()
    {
        String s = "Square: ";
        return super.toString();
    }
}
