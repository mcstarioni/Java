package HomeWork.ShapeGUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Макс on 14.09.2016.
 */

public class SFrame extends JFrame
{
    SFrame()
    {
        super("My window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SPanel sp = new SPanel();
        setContentPane(sp);
        //panel = new JPanel();
        //mainbox.add(topbox);
        //Shape jp = new Triangle();
        //jp.setPreferredSize(d);
        //mainbox.add(jp);
        //mainbox.add(Box.createRigidArea(d));
        //setContentPane(mainbox);
        //Возможно здесь должен быть код с контейнером для рисования.
        //Класс Shape будет его наследовать и прикрепляться к окну.
        setSize(sp.getPreferredSize());
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
