package Algorithms;

/**
 * Created by mcstarioni on 25.05.2017.
 */
import java.util.Scanner;
public class Reshuffle {

    static {
        System.out.println("Введите число элементов");
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        System.out.println("Введите последовательность");
        int[] ints = new int[N];
        for (int i = 0; i < N; i++) {
            ints[i] = s.nextInt();
        }

        go(ints);
        System.out.println("Следующая перестановка: ");
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }
    }
    public static void main(String[] args) {


    }
    public static void go(int[] cons)
    {
        int k = cons.length - 1;
        for (int i = cons.length - 1; i >= 1; i--) {
            if (cons[i] > cons[i-1])
            {
                k = i - 1;
                break;
            }
        }
        if (k == cons.length - 1)
        {
            System.out.println("Нет перестановок");
            return;
        }
        int t = cons.length - 1;
        for (int i = cons.length - 2; i > k; i--) {
            if (cons[i] > cons[k])
            {
                t = i;
                break;
            }
        }
        int temp = cons[t];
        cons[t] = cons[k];
        cons[k] = temp;
        sort(cons, t,cons.length);
    }
    public static void sort(int[] arr, int start, int end)
    {
        for (int i = start; i < end-1; i++) {
            int min = i;
            for (int j = i+1; j < end; j++) {
                if (arr[min] > arr[j])
                    min = j;
            }
            if (i != min)
            {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

}
