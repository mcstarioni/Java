package Algorithms;

/**
 * Created by mcstarioni on 25.05.2017.
 */
import java.util.Scanner;
public class NoteProblem {
    public static final int[] notes = new int[]{1,2,5,10,20,100};
    public static void main(String[] args) {
        System.out.println("Введите сумму");
        int N = (new Scanner(System.in)).nextInt();
        int[] sol = go(N);
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < sol.length; i++) {
            if (sol[i] != 0)
                b.append(sol[i]+" по "+notes[i]+", ");
        }
        b.delete(b.length() - 2, b.length() - 1);
        System.out.println(b +".");
    }
    public static int[] go(int N)
    {
        int[] solutions =  new int[6];
        int k;
        for (int i = 5; i >= 0 && N != 0; i--) {
            k = 0;
            while (N >= notes[i])
            {
                N -= notes[i];
                k++;
            }
            solutions[i] = k;
        }
        return solutions;
    }
}