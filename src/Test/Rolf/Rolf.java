package Test.Rolf;

import javax.swing.*;

/**
 * Created by mcstarioni on 21.11.2016.
 */
public class Rolf extends JFrame{
    public Rolf()
    {
        super("No name window");
        setContentPane(new RPanel());
        //setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        //JButton button
    }
    public static void main(String[] args) {
        Rolf rolf = new Rolf();
    }
}
