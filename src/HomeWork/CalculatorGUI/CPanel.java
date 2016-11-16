package HomeWork.CalculatorGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by mcstarioni on 15.11.2016.
 */
public class CPanel extends JPanel implements ActionListener,KeyListener{
    JTextField text;
    JCheckBox rpn;
    JButton enter;
    public CPanel()
    {
        super();
        setLayout(new BorderLayout(0,5));
        Box top = Box.createHorizontalBox();
        rpn = new JCheckBox("RPN");
        rpn.setSelected(true);
        top.add(rpn);
        text = new JTextField("");
        text.setColumns(15);
        top.add(text);
        enter = new JButton("=");
        enter.addActionListener(this);
        top.add(enter);
        char[] numbers = {'1','2','3','4','5','6','7','8','9','(','0',')'};
        char[] operators = {'+','-','*','/'};
        JPanel keys = new JPanel(new GridLayout(4,4,5,2));
        int k = 0;
        for(int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 3; j++,k++)
            {
                CButton button = new CButton(""+numbers[k]);
                button.addActionListener(this);
                keys.add(button);
            }
            CButton button = new CButton(""+operators[i]);
            button.addActionListener(this);
            keys.add(button);
        }
        add(top,BorderLayout.NORTH);
        add(keys,BorderLayout.CENTER);
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == enter)
        {
            if(rpn.isSelected())
            {
                text.setText(""+RPN.count(text.getText()));
            }
            else
            {
                text.setText(""+RPN.getRPN(text.getText()));
            }
        }
        else {
            text.setText(text.getText() + e.getActionCommand());
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        text.setText(text.getText() + e.getKeyChar());
    }
    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}
