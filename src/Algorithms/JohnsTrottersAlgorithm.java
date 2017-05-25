package Algorithms;
import java.util.*;
/**
 * Created by mcstarioni on 25.05.2017.
 */


public class JohnsTrottersAlgorithm
{
    public static void main(String[] args) {
        int N;
        System.out.println("Введите число: ");
        try {
            N = (new Scanner(System.in)).nextInt();
            trotter(Math.abs(N));
        } catch (Exception e)
        {
            System.out.println("Ошибка! Вы ввели неправильное число!");
        }
    }
    public static void trotter(final int n)
    {
        Integer[] consequence = new Integer[n];
        for (int i = 0; i < n; i++) {
            consequence[i] = i+1;
        }
        Integer[] dir = new Integer[n];
        for (int i = 0; i < n; i++) {
            dir[i] = -1;
        }
        while (true)
        {
            print(consequence);
            int id = -1;
            for (int i = 0; i < n; i++) {
                if ( (i+dir[i] >=0 && i+dir[i] < n) && consequence[i] > consequence[i+dir[i]] &&
                        (id == -1 || consequence[i]>consequence[id]) )
                    id = i;
            }
            if (id == -1) break;
            for (int i = 0; i < n; i++) {
                if (consequence[i] > consequence[id])
                    dir[i] *= -1;
            }
            swap(consequence, id, id + dir[id]);
            swap(dir, id, id + dir[id]);
        }
    }
    public static <E> void swap(final E[] arr,final int i,final int j)
    {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static <T> void print(final T[] arr)
    {
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
