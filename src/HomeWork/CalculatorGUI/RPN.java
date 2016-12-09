package HomeWork.CalculatorGUI;

import Collections.List.Stack;
import Collections.Map.Pair;

import java.util.ArrayList;

/**
 * Created by mcstarioni on 15.11.2016.
 */
public class RPN
{
    public static double calculate(String input)
    {
        return count(getRPN(input));
    }
    public static String getRPN(String input)
    {
        String output = ""; 
        Stack<Character> operators = new Stack<>();
        for (int i = 0; i < input.length(); i++)
        {
            char c = input.charAt(i);
            if (RPN.isDelimiter(c))
                continue;
            if (RPN.isDigit(c))
            {
                while (!RPN.isDelimiter(c) && !RPN.isOperator(c)) {
                    output += c;
                    i++;
                    if (i == input.length())
                        break;
                    else
                        c = input.charAt(i);
                }
                output += " ";
                i--;
                continue;
            }
            if (RPN.isOperator(c))
            {
                System.out.println(c);
                if (RPN.getPriority(c) > RPN.getPriority(operators.peek())
                        || operators.isEmpty()
                        || operators.peek() == '(') {
                    operators.push(c);
                } else {
                    do {
                        output += operators.pop() + " ";
                    } while (RPN.getPriority(c) < RPN.getPriority(operators.peek())
                            && !operators.isEmpty()
                            && operators.peek() != '(');
                    operators.push(c);
                }
                continue;
            }
            if(c == '(')
            {
                operators.push(c);
                continue;
            }
            if(c == ')')
            {
                while(!operators.isEmpty() && operators.peek() != '(')
                {
                    output += operators.pop();
                }
                continue;
            }

        }
        while (operators.size() > 0)
            if(operators.peek() != '(' && operators.peek() != ')')
                output += operators.pop() + " ";
        return output;
    }
    public static Pair<Stack<String>,Stack<Character>> parseToArrayList(String input)
    {
        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            while (c != ' ') {
                if(RPN.isOperator(c))
                {
                    Pair<Stack<String>,Stack<Character>> result;
                }
                else
                {
                }
            }
        }
        return new Pair<>();
    }
    public static double count(String input)
    {
        System.out.println(input);
        Stack<Double> temp = new Stack<Double>();
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
                temp.push(Double.parseDouble(number));
            }
            else {
                if (RPN.isOperator(c)) {
                    Double a = temp.pop();
                    Double b = temp.pop();
                    switch (RPN.getPriority(c))
                    {
                        case(1):
                        {
                            temp.push(a+b);
                            break;
                        }
                        case(2):
                        {
                            temp.push(b-a);
                            break;
                        }
                        case(3):
                        {
                            temp.push(a*b);
                            break;
                        }
                        case(4):
                        {
                            temp.push(b/a);
                            break;
                        }
                    }
                }
            }
        }
        return temp.peek();
    }
    public static boolean isDigit(char c)
    {
        return (c >= '0' && c <= '9');
    }
    public static boolean isOperator(char c)
    {
        return getPriority(c) != 6;
    }
    public static boolean isDelimiter(char c)
    {
        if (' ' == c)
            return true;
        return false;
    }
    public static int getPriority(char c)
    {
        switch (c)
        {
            case '+': return 1;
            case '-': return 2;
            case '*': return 3;
            case '/': return 4;
            case '^': return 5;
            default: return 6;
        }
    }
    public static enum  Operator
    {
        //'+','-';
    }

}
/*
1 2 3 +
4 5 6 -
7 8 9 *
( 0 ) /
 */