package HomeWork.CalculatorGUI;

import Collections.List.Stack;
import Collections.Map.Pair;

import java.util.ArrayList;

/**
 * Created by mcstarioni on 15.11.2016.
 */
public class RPN
{
    public static void main(String[] args) {
//        String[] rpnTest = {"2 2 +","3 3 *", "4 4   -"};
//        String[] test = {"2 +3-5","4*2*3-  12*2","1/2*(2+3*5 +   1)-((3+2)*3 - 6)"};
//        for (int i = 0; i < test.length; i++)
//        {
//            System.out.println(rpnTest[i] + " = " + RPN.getRPN());
//            System.out.println(test[i] + " = "+RPN.calculate(test[i]));
//        }
//
        String infixTest = "8*9 - 2*6^(4^(1/2))";
        //String infixTest = "-1+1";
        String test[] = {"57","3","5","*","6","2","^","2","*","-","+"};
        String testCombined = "";
        for (String s:test)
        {
            testCombined += s + " ";
        }
        ArrayList<String> array = new ArrayList<>();
        for (String s:test)
        {
            array.add(s);
        }
        //System.out.println(""+ RPN.count(array));
        System.out.println(" = "+RPN.calculate(infixTest));
    }
    public static double calculate(String infixInput)
    {
        return count(getRPN(infixInput));
    }
    public static ArrayList<String> getRPN(String input)
    {
        System.out.println(input + " length: "+input.length());
        ArrayList<String> result = new ArrayList<>(input.length());
        Stack<Character> operators = new Stack<>();
        //java.util.Stack<Character> operators = new java.util.Stack<>();
        int braces = 0;
        for (int i = 0; i < input.length(); i++)
        {
            System.out.print("Result is = ");
            result.forEach((number)-> System.out.print(number+" "));
            System.out.print("\nOperators stack = ");
            operators.forEach((operator) -> System.out.print(operator + " "));
            System.out.println();
            char c = input.charAt(i);
            if(RPN.isDigit(c))
            {
                String digits = "";
                do
                {
                    digits += c;
                    if(i < input.length() - 1)
                    {
                        i++;
                        c = input.charAt(i);
                    }else
                    {
                        break;
                    }
                }while(RPN.isDigit(c) || c == '.');
                result.add(digits);
            }
            if (RPN.isOperator(c))
            {
                if (!operators.isEmpty())
                {
                    int priority = RPN.getPriority(c);
                    while(operators.peek() != '(' && RPN.getPriority(operators.peek()) >= priority)
                    {
                        result.add(operators.pop().toString());
                        if (operators.isEmpty())
                        {
                            break;
                        }
                    }
                    operators.push(c);
                } else
                {
                    operators.push(c);
                }
                System.out.print("Result is = ");
                result.forEach((number)-> System.out.print(number+" "));
                System.out.print("\nOperators stack = ");
                operators.forEach((operator) -> System.out.print(operator + " "));
                System.out.println();
            } else
            {
                if (c == '(')
                {
                    operators.push(c);
                    braces++;
                } else
                {
                    if (c == ')')
                    {
                        while (!operators.isEmpty())
                        {
                            if (operators.peek() == '(')
                            {
                                braces--;
                                operators.pop();
                                break;
                            }
//                        char out = operators.peek();
//                        System.out.println(out);
                            result.add(operators.pop().toString());
                        }
                    }
                }
            }

        }
        while (!operators.isEmpty())
        {
//            char out = operators.peek();
//            System.out.println(out);
            result.add(operators.pop().toString());
        }
        return result;
    }
    public static double count(ArrayList<String> input)
    {
        Stack<Double> temp = new Stack<>();
        for (int i = 0; i < input.size(); i++)
        {
            String value = input.get(i);
            System.out.print(value + " ");
            char c = value.charAt(0);
            if (RPN.isDigit(c))
            {
                temp.push(Double.parseDouble(value));
            }
            else {
                if (RPN.isOperator(c)) {
                    Double a = temp.pop();
                    Double b = temp.pop();
                    switch (RPN.getOperation(c))
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
                        case(5):
                        {
                            temp.push(Math.pow(b,a));
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
        return getOperation(c) != 6;
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
            case '-': return 1;
            case '*': return 2;
            case '/': return 2;
            case '^': return 3;
            //case '(': return 4;
            //case ')': return 4;
            default: return 5;
        }
    }
    public static int getOperation(char c)
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
}