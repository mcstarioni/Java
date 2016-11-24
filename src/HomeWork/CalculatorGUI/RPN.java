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
        String output = new String(); //Строка для хранения выражения
        java.util.Stack<Character> operStack = new java.util.Stack<>(); //Стек для хранения операторов
        for (int i = 0; i < input.length(); i++) //Для каждого символа в входной строке
        {
            char c = input.charAt(i);
            //Разделители пропускаем
//            if (isDelimiter(c))
//                continue; //Переходим к следующему символу
            //Если символ - цифра, то считываем все число
            if (isDigit(c)) //Если цифра
            {
                //Читаем до разделителя или оператора, что бы получить число
                while (!isOperator(c))
                {
                    output += input.charAt(i); //Добавляем каждую цифру числа к нашей строке
                    i++; //Переходим к следующему символу
                    if (i == input.length()) break; //Если символ - последний, то выходим из цикла
                }

                output += " "; //Дописываем после числа пробел в строку с выражением
                i--; //Возвращаемся на один символ назад, к символу перед разделителем
            }
            //Если символ - оператор
            if (isOperator(c)) //Если оператор
            {
                if (c == '(') //Если символ - открывающая скобка
                    operStack.push(c); //Записываем её в стек
                else if (c == ')') //Если символ - закрывающая скобка
                {
                    //Выписываем все операторы до открывающей скобки в строку
                    char s = operStack.pop();
                    while (s != '(')
                    {
                        output += s + ' ';
                        s = operStack.pop();
                    }
                }
                else //Если любой другой оператор
                {
                    if (operStack.size() > 0) //Если в стеке есть элементы
                        if (getPriority(c) <= getPriority(operStack.peek())) //И если приоритет нашего оператора меньше или равен приоритету оператора на вершине стека
                            output += operStack.pop() + " "; //То добавляем последний оператор из стека в строку с выражением
                    operStack.push(c); //Если стек пуст, или же приоритет оператора выше - добавляем операторов на вершину стека
                }
            }
        }
        //Когда прошли по всем символам, выкидываем из стека все оставшиеся там операторы в строку
        while (operStack.size() > 0)
            output += operStack.pop() + " ";

        return output; //Возвращаем выражение в постфиксной записи
    }
    public static double count(String input)
    {
        System.out.println(input);
        double result = 0; //Результат
        Stack<Double> temp = new Stack<Double>(); //Dhtvtyysq стек для решения

        for (int i = 0; i < input.length(); i++) //Для каждого символа в строке
        {
            //Если символ - цифра, то читаем все число и записываем на вершину стека
            if (isDigit(input.charAt(i)))
            {
                System.out.println(input.charAt(i));
                String a = "";

                System.out.println(i);
                while (!isDelimiter(input.charAt(i)) && !isOperator(input.charAt(i))) //Пока не разделитель
                {
                    a += input.charAt(i); //Добавляем
                    i++;
                    if (i == input.length()) break;
                }
                System.out.println(a);
                temp.push(Double.parseDouble(a)); //Записываем в стек
                i--;
            }
            else if (isOperator(input.charAt(i))) //Если символ - оператор
            {
                //Берем два последних значения из стека
                double a = temp.pop();
                double b = temp.pop();
                switch (input.charAt(i)) //И производим над ними действие, согласно оператору
                {
                    case '+': result = b + a; break;
                    case '-': result = b - a; break;
                    case '*': result = b * a; break;
                    case '/': result = b / a; break;
                    //case '^': result = double.Parse(Math.Pow(double.Parse(b.ToString()), double.Parse(a.ToString())).ToString()); break;
                }
                temp.push(result); //Результат вычисления записываем обратно в стек
            }
        }
        return temp.peek(); //Забираем результат всех вычислений из стека и возвращаем его
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