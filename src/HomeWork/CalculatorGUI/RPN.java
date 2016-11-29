package HomeWork.CalculatorGUI;

import Collections.List.Stack;

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
        String output = ""; 
        Stack<Character> operators = new Stack<>(); //Стек для хранения операторов
        for (int i = 0; i < input.length(); i++) //Для каждого символа в входной строке
        {
            char c = input.charAt(i);
            if (isDelimiter(c))
                continue;
            if (RPN.isDigit(c)) //Если цифра
            {
                //Читаем до разделителя или оператора, что бы получить число
                while (!RPN.isDelimiter(c) && !RPN.isOperator(c)) {
                    output += c; //Добавляем каждую цифру числа к нашей строке
                    i++; //Переходим к следующему символу
                    if (i == input.length())
                        break;
                    else
                        c = input.charAt(i);
                    //Если символ - последний, то выходим из цикла
                }
                output += " "; //Дописываем после числа пробел в строку с выражением
                i--; //Возвращаемся на один символ назад, к символу перед разделителем
            }
            //Если символ - оператор
            if (isOperator(c)) //Если оператор
            {
                if (c == '(') //Если символ - открывающая скобка
                    operators.push(c); //Записываем её в стек
                else {
                    if (c == ')') //Если символ - закрывающая скобка
                    {
                        //Выписываем все операторы до открывающей скобки в строку
                        char s = operators.pop();
                        while (s != '(') {
                            output += s + ' ';
                            s = operators.pop();
                        }
                    } else //Если любой другой оператор
                    {
                        if (operators.size() > 0) //Если в стеке есть элементы
                            if (getPriority(c) <= getPriority(operators.peek())) //И если приоритет нашего оператора меньше или равен приоритету оператора на вершине стека
                                output += operators.pop() + " "; //То добавляем последний оператор из стека в строку с выражением
                        operators.push(c); //Если стек пуст, или же приоритет оператора выше - добавляем операторов на вершину стека
                    }
                }
            }
        }
        //Когда прошли по всем символам, выкидываем из стека все оставшиеся там операторы в строку
        while (operators.size() > 0)
            output += operators.pop() + " ";
        return output;
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
            else
            {
                if (RPN.isOperator(c))
                {
                    Double a = temp.pop();
                    Double b = temp.pop();
                    switch (RPN.getPriority(c))
                    {
                        case(2):
                        {
                            temp.push(a+b);
                            break;
                        }
                        case(3):
                        {
                            temp.push(b-a);
                            break;
                        }
                        case(4):
                        {
                            temp.push(a*b);
                            break;
                        }
                        case(5):
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
        if (' ' == c || '(' == c || ')' == c)
            return true;
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
            case '/': return 5;
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