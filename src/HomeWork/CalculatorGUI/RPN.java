package HomeWork.CalculatorGUI;

/**
 * Created by mcstarioni on 15.11.2016.
 */
public class RPN {
    public static double calculate(String input)
    {
        return count(getRPN(input));
    }
    public static String getRPN(String input)
    {
        String output = new String();
        return output;
    }
    public static double count(String input)
    {
        return 0.0;
    }
    public static boolean isOperator(char c)
    {
        return getPriority(c) != 6;
    }
    public static boolean isDelimiter(char c)
    {
        return false;
    }
    public static int getPriority(char c)
    {
        switch (c)
        {
            case '(': return 0;
            case ')': return 1;
            case '+': return 2;
            case '-': return 3;
            case '*': return 4;
            case '/': return 4;
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