package HomeWork.ShapeGUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Макс on 14.09.2016.
 */

public class SFrame extends JFrame
{
    public SFrame()
    {
        super("My window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SPanel sp = new SPanel();
        setContentPane(sp);
        setSize(sp.getPreferredSize());
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
