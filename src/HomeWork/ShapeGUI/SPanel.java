package HomeWork.ShapeGUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mcstarioni on 07.11.2016.
 */
public class SPanel extends JPanel
{
    SPanel()
    {
        setLayout(new BorderLayout());
        Box topbox = Box.createHorizontalBox();
        SEnum[] figures = SEnum.values();
        HomeWork.ShapeGUI.Shape.Shape shape;
        Dimension d = new Dimension();
        for (int i = 0; i < figures.length; i++)
        {
            JButton jb = new JButton(figures[i].name());
            shape = figures[i].getFigure(50);
            jb.addActionListener(shape);
            topbox.add(jb);
            d.width += jb.getMaximumSize().width;
        }
        Box bottom = Box.createHorizontalBox();
        d.height = 300;
        JPanel canvas = new JPanel();
        canvas.setSize(d);
        JLabel label = new JLabel("Hello world!");
        bottom.add(label);
        add(canvas,BorderLayout.CENTER);
        add(topbox,BorderLayout.NORTH,2);
        add(bottom,BorderLayout.SOUTH);
        setPreferredSize(new Dimension(d.width,topbox.getHeight()+bottom.getHeight()+canvas.getHeight()));
    }
}
