package Collections.Tree;

import Collections.List.Stack;
import HomeWork.CalculatorGUI.RPN;
import com.sun.awt.AWTUtilities;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.jar.JarFile;

/**
 * Created by mcstarioni on 30.11.2016.
 */
public class TreeMain {
    public ArrayList<JPanel> panels;

    public static void main(String[] args) {
        String input = "2 3 * 12 6 / 3 * -";
        BinTree<Integer> tree = new BinTree<>();
        //fillTree(input);
        for (int i = 0; i < 10; i++) {
            tree.add(i);
        }

    }

    class CustomPanel extends JPanel {
        CustomPanel() {
            super();
            BoxLayout layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
            panels = new ArrayList<>();
            //setLayout();
        }
    }
}
//    public static BinTree<String> fillTree(String input)
//    {
//        System.out.println(input);
//        Stack<BinTree<String>> temp = new Stack<>();
//        for (int i = 0; i < input.length(); i++)
//        {
//            char c = input.charAt(i);
//            String number = "";
//            if (RPN.isDigit(c) || c == '.')
//            {
//                while (c != ' ' && !RPN.isOperator(c)) {
//                    number += c;
//                    i++;
//                    c = input.charAt(i);
//                }
//                temp.push(new BinTree<String>(number,null,null));
//            }
//            else {
//                if (RPN.isOperator(c)) {
//                    BinTree<String> a = temp.pop();
//                    BinTree<String> b = temp.pop();
//                    temp.push(new BinTree<>(""+c,b,a));
//                }
//            }
//        }
//        return temp.peek();
//    }
