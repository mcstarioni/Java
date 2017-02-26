package HomeWork;

import java.util.Collection;

/**
 * Created by mcstarioni on 23.01.2017.
 */
public class Sorter
{
    private static class IntHolder
    {
        public int a;
        IntHolder(int a){this.a = a;}
        @Override
        public String toString()
        {
            return ""+a;
        }
    }
    public static void main(String[] args)
    {
        IntHolder a = new IntHolder(10);
        IntHolder b = new IntHolder(20);
        //swap(b,a);
        System.out.println(a + " " + b);

    }
    public static <T extends Comparable> Collection<T> sort(Collection<T> collection)
    {
        Object o = new Object();
        T temp = collection.iterator().next();
        return collection;
    }
    public static <T extends Comparable> void sortBubble(T[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            T t = array[i];
        }
    }
    public static <T> void swap(T[] array, int i, int j)
    {
        class Fuck
        {

        }
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
