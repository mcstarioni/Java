package HomeWork.ShapeGUI;

import HomeWork.ShapeGUI.Shape.MoveablePoint;
import HomeWork.ShapeGUI.Shape.Shape;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by mcstarioni on 07.11.2016.
 */
public class SPanel extends JPanel implements KeyListener
{
    protected MoveablePoint point;
    protected Shape drawing;
    boolean up = false;
    boolean down = false;
    boolean right = false;
    boolean left = false;
    public Shape getDrawing()
    {
        return drawing;
    }
    public void setDrawing(Shape drawing)
    {
        this.drawing = drawing;
    }
    public MoveablePoint getPoint()
    {
        return point;
    }
    public void setPoint(MoveablePoint point)
    {
        this.point = point;
    }
    SPanel()
    {
        super();
        setLayout(new BorderLayout());
        Box topbox = Box.createHorizontalBox();
        SEnum[] figures = SEnum.values();
        this.drawing = null;
        HomeWork.ShapeGUI.Shape.Shape shape;
        Shape.setBasePanel(this);
        for (int i = 0; i < figures.length; i++)
        {
            JButton jb = new JButton(figures[i].name());
            jb.setFocusable(false);
            shape = figures[i].getFigure(50);
            jb.addActionListener(shape);
            topbox.add(jb);
        }
        Box bottom = Box.createHorizontalBox();
        Dimension d = topbox.getPreferredSize();
        d.height = 300;
        d.width += 10;
        JPanel canvas = new JPanel();
        canvas.setSize(d);
        JLabel label = new JLabel("MOVE MODE OFF.");
        bottom.add(label);
        add(canvas,BorderLayout.CENTER);
        add(topbox,BorderLayout.NORTH);
        add(bottom,BorderLayout.SOUTH);
        point = new MoveablePoint(d.height/2,d.width/2,0,0);
        setFocusable(true);
        addKeyListener(this);
        setPreferredSize(d);
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        if(drawing!= null)
        {
            Dimension d = this.getSize();
            this.point = new MoveablePoint(d.height / 2, d.width / 2, 0, 0);
            drawing.draw(g);
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        //System.out.println(e.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        //System.out.println(e.getKeyCode());
        int key = e.getKeyCode();
        switch (key)
        {
            case(37):
                left = true;
            case(38):
                up = true;
            case(39):
                right = true;
            case(40):
                down = true;
        }
        this.repaint();
    //drawing.
    }
    @Override
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        switch (key)
        {
            case (37):
                left = false;
                break;
            case (38):
                up = false;
                break;
            case (39):
                right = false;
                break;
            case (40):
                down = false;
                break;
        }
        move();
    }
    public void move()
    {
        if(left && !right)
            System.out.println("left");
            //drawing.moveLeft();

        if(up && !down)
            System.out.println("up");
            //drawing.moveUp();
        if(right && !left)
            System.out.println("right");
            //drawing.moveRight();
        if(down && !up)
            System.out.println("down");
            //drawing.moveDown();
    }
}
