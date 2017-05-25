package Algorithms.Graph.gui;

/**
 * Created by mcstarioni on 25.05.2017.
 */
import javax.swing.*;
import java.awt.*;
import static Algorithms.Graph.gui.Frame.MAX_SIZE;
public class OutputPanel extends JPanel{
    public static OutputPanel instance;
    public static JLabel[][] array;
    private static final int MAX_INT = 1000000;
    OutputPanel()
    {
        super(new GridLayout(MAX_SIZE+1, MAX_SIZE+1));
        this.add(new JLabel("Откуда/Куда"));
        for (int i = 0; i < MAX_SIZE; i++) {
            this.add(new JLabel(""+((char)('A'+i))));
        }
        instance = this;

        array = new JLabel[MAX_SIZE][MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            this.add(new JLabel(""+((char)('A'+i))));
            for (int j = 0; j < MAX_SIZE; j++) {
                array[i][j] = new JLabel();
                this.add(array[i][j]);
                array[i][j].setVisible(false);
            }

        }
    }
    public void solve()
    {
        int count = InputPanel.instance.count;
        int[][] g = new int[count][count];

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                g[i][j] = new Integer(InputPanel.array[i][j].getText());
                if (g[i][j] == 0) {
                    g[i][j] = MAX_INT;

                }
            }
        }

        for (int k = 0; k < count; k++) {
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < count; j++) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }

        reset();
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (g[i][j] == MAX_INT || i == j)
                    array[i][j].setText("0");
                else
                    array[i][j].setText(""+ g[i][j]);
                array[i][j].setVisible(true);
            }
        }
    }
    public void reset()
    {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j].setVisible(false);
            }
        }
    }
}
