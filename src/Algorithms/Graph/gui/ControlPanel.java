package Algorithms.Graph.gui;

/**
 * Created by mcstarioni on 25.05.2017.
 */
import javax.swing.*;
import java.awt.event.ItemEvent;
import static Algorithms.Graph.gui.Frame.MAX_SIZE;
/**
 * Created by Dell on 16.05.2017.
 */
public class ControlPanel extends JPanel {
    JComboBox<Integer> box;
    JButton solve, reset;
    ControlPanel()
    {
        super();
        Integer[] integers = new Integer[MAX_SIZE-3];
        for (int i = 3; i < MAX_SIZE; i++) {
            integers[i-3] = i;
        }
        box = new JComboBox<>(integers);
        box.addItemListener((e)->{
            if(e.getStateChange() == ItemEvent.SELECTED)
                InputPanel.instance.recount((Integer) e.getItem());
        });
        this.add(box);

        solve = new JButton("Решить");
        solve.addActionListener(e -> OutputPanel.instance.solve());
        this.add(solve);

        reset = new JButton("Сбросить");
        reset.addActionListener(e->
        {
            OutputPanel.instance.reset();
            InputPanel.instance.reset();
        });
        this.add(reset);


    }
}
