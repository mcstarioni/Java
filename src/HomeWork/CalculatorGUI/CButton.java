package HomeWork.CalculatorGUI;

import javax.swing.*;

/**
 * Created by mcstarioni on 16.11.2016.
 */
public class CButton extends JButton {
    public CButton(String s)
    {
        super(s);
        setActionCommand(this.getText());
        setFocusable(false);
    }
}
