package HomeWork.CalculatorGUI;

import javax.swing.*;

/**
 * Created by mcstarioni on 14.11.2016.
 */
public class CMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        CPanel panel = new CPanel();
        frame.setContentPane(panel);
        frame.setSize(panel.getPreferredSize());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}