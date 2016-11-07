package HomeWork;
import java.lang.reflect.Array;
import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

public class Recursion
{
    public static void main(String[] args)
    {
        //System.out.println(maxCount(0));
        //System.out.println(secondMax(0,0));
        numbers(546465);
    }
    public static int maxCount(int max1)
    {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        int max = max1;
        int count = 1;
        do
        {
            i = scan.nextInt();
            if(i > max)
            {
                return maxCount(i);
            }else
            {
                if(i == max)
                    count++;
            }
        }while(i != 0);
        return count;
    }
    public static int secondMax(int max1,int max2)
    {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        int max = max1;
        int count = 1;
        do
        {
            i = scan.nextInt();
            if(i > max)
            {
                return secondMax(i, max);
            }
        }while(i != 0);
        return max2;
    }
    public static int pow(int N, int p)
    {
        if(p == 0)
            return 1;
        else
            return N*pow(N,p-1);
    }
    public static void numbers(int N)
    {
        int numbCount = firstNumber(N,0);
        if(numbCount != 0)
        numbers(N%pow(10,numbCount));
    }
    public static int firstNumber(int N, int numbCount)
    {
        if(N < 10)
        {
            System.out.print(N);
            return numbCount;
        }
        else
        return firstNumber(N/10, ++numbCount);
    }
}
 //4567-> 456-> 45-> 4
//        int count = 1;
//        Integer max = array.elementAt(0);
//        for (int i = 1; i < array.size(); i++)
//        {
//            if (Objects.equals(array.elementAt(i), max))
//            {
//                count++;
//            } else
//            {
//                if (array.elementAt(i) > max)
//                {
//                    return maxCount(new Vector<Integer>(array.subList(i, array.size())));
//                }
//            }
//        }
//        return count;
//