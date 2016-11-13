package HomeWork.ShapeGUI.Shape;

/**
 * Created by mcstarioni on 12.11.2016.
 */
public class Point {
    protected double X;
    protected double Y;
    public Point()
    {
        X = 0;
        Y = 0;
    }
    public Point(double x, double y)
    {
        X = x;
        Y = y;
    }
    public double X() {
        return X;
    }
    public void setX(double x) {
        X = x;
    }
    public double Y() {
        return Y;
    }
    public void setY(double y) {
        Y = y;
    }
}
