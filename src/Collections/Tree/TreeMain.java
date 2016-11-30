package Collections.Tree;

import Collections.List.Stack;
import HomeWork.CalculatorGUI.RPN;

/**
 * Created by mcstarioni on 30.11.2016.
 */
public class TreeMain {
    public static void main(String[] args) {
        String input = "2 3 5 6 7 + + + +";
        BinTree<String> tree =  fillTree(input);
        printTree(tree,1);
    }
    public static BinTree<String> fillTree(String input)
    {
        System.out.println(input);
        Stack<BinTree<String>> temp = new Stack<>();
        for (int i = 0; i < input.length(); i++)
        {
            char c = input.charAt(i);
            String number = "";
            if (RPN.isDigit(c) || c == '.')
            {
                while (c != ' ' && !RPN.isOperator(c)) {
                    number += c;
                    i++;
                    c = input.charAt(i);
                }
                temp.push(new BinTree<String>(number,null,null));
            }
            else {
                if (RPN.isOperator(c)) {
                    BinTree<String> a = temp.pop();
                    BinTree<String> b = temp.pop();
                    temp.push(new BinTree<>(""+c,b,a));
                }
            }
        }
        return temp.peek();
    }
    public static <T> void printTree(BinTree<T> tree, int level)
    {
        System.out.print(level + ". "+tree.value.toString());
        if (tree.left != null) {
            System.out.println();
            printTree(tree.left, level + 1);
        }
        if (tree.right != null) {
            System.out.println();
            printTree(tree.right, level + 1);
        }
    }
}
