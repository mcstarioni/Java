package HomeWork.CalculatorGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

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
        GridLayout layout = new GridLayout(4,4,5,5);
        JPanel keys = new JPanel(layout);
        int k = 0;
        for(int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 3; j++,k++)
            {
                CButton button = new CButton(""+numbers[k]);
                button.addActionListener(this);
                button.setMaximumSize(new Dimension(15,15));
                keys.add(button);
            }
            CButton button = new CButton(""+operators[i]);
            button.addActionListener(this);
            button.setMaximumSize(new Dimension(15,15));
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
                String[] request = text.getText().split(" ");
                ArrayList<String> temp = new ArrayList<>(request.length);
                for(String word:request)
                {
                    temp.add(word);
                }
                text.setText(""+RPN.count(temp));
            }
            else
            {
                text.setText(""+RPN.calculate(text.getText()));
                rpn.setSelected(true);
            }
        }
        else {
            text.setText(text.getText() + e.getActionCommand());
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        System.out.println(c);
        if(Character.isDigit(c) || RPN.isOperator(""+c) || RPN.isDelimiter(c)) {
            text.setText(text.getText() + e.getKeyChar());
        }
        else
        {
            if(e.getKeyCode() == 8)
            {
                text.setText(text.getText().substring(0,text.getText().length() - 1));
            }
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}
