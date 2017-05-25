package Algorithms.Graph.gui;

/**
 * Created by mcstarioni on 25.05.2017.
 */
import javax.swing.*;
import java.awt.*;
import static Algorithms.Graph.gui.Frame.MAX_SIZE;


public class InputPanel extends JPanel {
    public static InputPanel instance;
    public static JTextField[][] array;
    public static JLabel[][] marks;
    int count;
    InputPanel(int count)
    {
        super(new GridLayout(MAX_SIZE+1, MAX_SIZE+1, 2 ,2));
        array = new JTextField[MAX_SIZE][MAX_SIZE];
        this.add(new JLabel("Откуда/Куда"));

        marks = new JLabel[2][MAX_SIZE];

        for (int i = 0; i < MAX_SIZE; i++) {
            marks[0][i] = new JLabel(""+((char)('A'+i)));
            add(marks[0][i]);
        }
        instance = this;

        this.count = count;
        for (int i = 0; i < MAX_SIZE; i++) {
            marks[1][i] = new JLabel(""+((char)('A'+i)));
            this.add(marks[1][i]);
            for (int j = 0; j < MAX_SIZE; j++) {
                (array[i][j] = new JTextField(4)).setText("0");
                this.add(array[i][j]);
                if (i >= count || j >= count)
                    array[i][j].setVisible(false);
            }

        }

    }
    public void recount(int count)
    {
        if (count < this.count) {
            for (int i = 0; i < this.count; i++) {
                for (int j = 0; j < this.count; j++) {
                    if (i > count - 1 || j> count - 1)
                        array[i][j].setVisible(false);
                }
            }
        }
        else
        {
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < count; j++) {
                    if (i > this.count - 1 || j > this.count - 1)
                        array[i][j].setVisible(true);
                }
            }
        }
        this.count = count;
    }
    public void reset()
    {
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                array[i][j].setText("0");
            }
        }
    }
}
