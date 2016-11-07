package HomeWork.ShapeGUI.Shape;

/**
 * Created by mcstarioni on 06.11.2016.
 */
public class MoveablePoint implements Moveable
{
    private int Y;
    private int X;
    private int dY;
    private int dX;
    public MoveablePoint(int Y, int X, int dY, int dX)
    {
        this.Y = Y;
        this.X = X;
        this.dY = dY;
        this.dX = dX;
    }
    public void moveUp()
    {
        Y += dY;
    }

    public void moveDown()
    {
        Y -= dY;
    }

    public void moveRight()
    {
        X += dX;
    }

    public void moveLeft()
    {
        X -= dX;
    }
}
