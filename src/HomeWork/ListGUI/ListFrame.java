package HomeWork.ListGUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mcstarioni on 01.11.2016.
 */
public class ListFrame extends JFrame
{
    public ListFrame()
    {
        super("ListGUI");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Box references = Box.createHorizontalBox();
        JLabel prev = new JLabel("NULL",Label.LEFT);
        JLabel element = new JLabel("HEAD",Label.LEFT);
        JLabel next = new JLabel("NULL",Label.LEFT);
        references.add(prev);
        references.add(element);
        references.add(next);
        references.setForeground(Color.blue);
        references.setSize(90,50);
        JPanel basePane = new JPanel();
        basePane.setLayout(new GridLayout());
        JButton addElement = new JButton("Add");
        addElement.setSize(90,50);
        basePane.add(addElement);
        basePane.add(references);
        setContentPane(basePane);
        setSize(basePane.getPreferredSize());
    }
}
