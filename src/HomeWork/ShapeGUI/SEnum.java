package HomeWork.ShapeGUI;

import HomeWork.ShapeGUI.Shape.*;

import javax.swing.*;

/**
 * Created by Макс on 07.09.2016.
 */
public enum SEnum
{
    Triangle, Rectangle, Circle, Square;
    public static final int length = SEnum.values().length;
    public Shape getFigure(int i,int size)
    {
        Shape shape = null;
        if ((i < 0)|(i > SEnum.length))
        {
            return shape;
        }
        switch(i)
        {
            case(0):

                break;
            case(1):
                shape = new Rectangle(size*2,size);
                break;
            case(2):
                shape = new Circle(size);
                break;
            case(3):
                shape = new Square(size);
                break;
        }
        return shape;
    }
    public Shape getFigure(int size)
    {
        return this.getFigure(this.ordinal(),size);
    }
}
