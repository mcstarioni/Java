package HomeWork.ShapeGUI.Shape;

/**
 * Created by mcstarioni on 06.11.2016.
 */
public class MoveablePoint implements Moveable
{
    private Point coordinate;
    private Point velocity;
    private Point acceleration;

    public MoveablePoint()
    {
        coordinate = new Point(0,0);
        velocity = new Point(0,0);
        acceleration = new Point(0,0);
    }
    public MoveablePoint(double X, double Y, double vX, double vY,double aX, double aY)
    {
        coordinate = new Point(X,Y);
        velocity = new Point(vX,vY);
        acceleration = new Point(aX,aY);
    }
    public void moveX()
    {
        velocity.X += acceleration.X;
        coordinate.X += velocity.X;
    }
    public void moveY()
    {
        velocity.Y += acceleration.Y;
        coordinate.Y += velocity.Y;
    }
    public void moveUp()
    {

        velocity.Y += acceleration.Y;
        coordinate.Y -= velocity.Y;
    }

    public void moveDown()
    {
        velocity.Y += acceleration.Y;
        coordinate.Y += velocity.Y;
    }

    public void moveRight()
    {
        velocity.X += acceleration.X;
        coordinate.X += velocity.X;
    }

    public void moveLeft()
    {
        velocity.X += acceleration.X;
        coordinate.X -= velocity.X;
    }

    public double getY()
    {
        return coordinate.Y();
    }
    public void setY(double y)
    {
        coordinate.setY(y);
    }

    public double getX()
    {
        return coordinate.X();
    }
    public void setX(double x)
    {
        coordinate.setX(x);
    }

    public void setAX(double x){acceleration.X = x;}
    public void setAY(double y){acceleration.Y = y;}

    public Point getCoordinate() {
        return coordinate;
    }
    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }

    public Point getVelocity() {
        return velocity;
    }
    public void setVelocity(Point velocity) {
        this.velocity = velocity;
    }

    public Point getAcceleration() {
        return acceleration;
    }
    public void setAcceleration(Point acceleration) {
        this.acceleration = acceleration;
    }

}
