package HomeWork.CalculatorGUI;

import Collections.List.Stack;
import Collections.Map.Map;
import Collections.Map.Pair;

import java.util.ArrayList;

/**
 * Created by mcstarioni on 15.11.2016.
 */
public class RPN
{
    public static void main(String[] args) {
        String infixTest = "sin(Pi)^2 + cos(Pi)^2";
        String test[] = {"PI","2","/","sin","asin","2","*"};
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
        Stack<String> operators = new Stack<>();
        int braces = 0;
        for (int i = 0; i < input.length(); i++)
        {
            System.out.print("Result:  ");
            result.forEach((number)-> System.out.print(number+" "));
            System.out.print("\nOperators:  ");
            operators.forEach((operator) -> System.out.print(operator + " "));
            System.out.println();
            char c = input.charAt(i);
            if(RPN.isDigit(c))
            {
                StringBuilder digits = new StringBuilder();
                do
                {
                    digits.append(c);
                    if(i < input.length() - 1)
                    {
                        i++;
                        c = input.charAt(i);
                    }else
                    {
                        break;
                    }
                }while(RPN.isDigit(c) || c == '.');
                if(Math.abs(Double.parseDouble(digits.toString())-Math.PI)<0.1)
                {
                    digits.delete(0,digits.length());
                    digits.append("PI");
                }
                result.add(digits.toString());
            }
            if(Character.isLetter(c))
            {
                StringBuilder letters = new StringBuilder();
                do
                {
                    letters.append(c);
                    if(i < input.length() - 1)
                    {
                        i++;
                        c = input.charAt(i);
                    }else
                    {
                        break;
                    }
                }while(Character.isLetter(c));
                String word = letters.toString();
                if(word.equals("pi") || word.equals("Pi") || word.equals("PI"))
                {
                    result.add("PI");
                }else
                {
                    if(isFunction(word))
                    {
                        operators.push(word);
                    }
                }
            }
            if (RPN.isOperator(""+c))
            {
                if (!operators.isEmpty())
                {
                    int priority = RPN.getPriority(""+c);
                    while(!operators.peek().equals("(") && RPN.getPriority(operators.peek()) >= priority)
                    {
                        result.add(operators.pop());
                        if (operators.isEmpty())
                        {
                            break;
                        }
                    }
                    operators.push(""+c);
                } else
                {
                    operators.push(""+c);
                }
            } else
            {
                if (c == '(')
                {
                    operators.push(""+c);
                    braces++;
                } else
                {
                    if (c == ')')
                    {
                        while (!operators.isEmpty())
                        {
                            if (operators.peek().equals("("))
                            {
                                braces--;
                                operators.pop();
                                break;
                            }
                            result.add(operators.pop());
                        }
                    }
                }
            }
        }
        while (!operators.isEmpty())
        {
            result.add(operators.pop());
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
                if (RPN.isOperator(value)) {
                    Double a = temp.pop();
                    Double b = temp.pop();
                    switch (RPN.getOperation(value))
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
                }else
                {
                    if(isFunction(value))
                    {
                        Double a = temp.pop();
                        try{
                            switch (getFunction(value))
                            {
                                case 0:
                                {
                                    temp.push(Math.sin(a));
                                    break;
                                }
                                case 1:
                                {
                                    temp.push(Math.cos(a));
                                    break;
                                }
                                case 2:
                                {
                                    temp.push(Math.tan(a));
                                    break;
                                }
                                case 3:
                                {
                                    temp.push(1/Math.tan(a));
                                    break;
                                }
                                case 4:
                                {
                                    temp.push(Math.acos(a));
                                    break;
                                }
                                case 5:
                                {
                                    temp.push(Math.asin(a));
                                    break;
                                }
                            }
                        }catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }else
                    {
                        if (value.equals("PI"))
                        {
                            temp.push(Math.PI);
                        }
                    }
                }
            }
        }
        System.out.println();
        return temp.peek();
    }
    // 2 + 2*2*cos()
    public static boolean isFunction(String s)
    {
        return (getFunction(s) != -1);
    }
    public static int getFunction(String s)
    {
        switch (s)
        {
            case "sin":return 0;
            case "cos":return 1;
            case "tg":return 2;
            case "ctg":return 3;
            case "acos":return 4;
            case "asin":return 5;
        }
        return -1;
    }
    public static String getFunction(int n)
    {
        switch (n)
        {
            case 0: return "sin";
            case 1: return "cos";
            case 2: return "tg";
            case 3: return "ctg";
            case 4: return "acos";
            case 5: return "asin";
        }
        return "";
    }
    public static boolean isDigit(char c)
    {
        return (c >= '0' && c <= '9');
    }
    public static boolean isOperator(String c)
    {
        return getOperation(c) != 6;
    }
    public static boolean isDelimiter(char c)
    {
        if (' ' == c)
            return true;
        return false;
    }
    public static int getPriority(String c)
    {
        switch (c)
        {
            case "+": return 1;
            case "-": return 1;
            case "*": return 2;
            case "/": return 2;
            case "^": return 3;
        }
        if(isFunction(c))
            return 4;
        return 5;
    }
    public static int getOperation(String c)
    {
        switch (c)
        {
            case "+": return 1;
            case "-": return 2;
            case "*": return 3;
            case "/": return 4;
            case "^": return 5;
            default: return 6;
        }
    }
}