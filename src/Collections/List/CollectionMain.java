package Collections.List;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Created by mcstarioni on 20.10.2016.
 */
public class CollectionMain
{
    private static class MyStr
    {
        public String str = "hell";

        public MyStr()
        {
        }

        public MyStr(String str)
        {
            this.str = str;
        }
        public String toString(){return this.str;}
    }
    public static void listAddTest(int N,List list)
    {
        for (int i = 0; i < N; i++)
        {
            list.add(new MyStr("" + i));
        }
    }
    public static <T> void listAddTest(int from, int to, T inserted, List<T> list)
    {
        for (int i = from; i <= to ; i++)
        {
            list.add(inserted,i);
        }
    }
    public static void listRemoveTest(int from,int to,List list)
    {
        for (int i = to; i >= from; i--)
        {
            System.out.println("Remove " + i);
            list.removeAt(i);
        }
    }
    public static void listPrintTest(List list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            System.out.print(list.elementAt(i).toString() + " ");
        }
        System.out.println();
    }
    public static <T> void listModifyTest(int from, int to, T changer, List<T> list)
    {
        for (int i = from; i <= to; i++)
        {
            list.modifyAt(changer,i);
        }
    }
    public static void listTest(List<MyStr> list)
    {
        list.add(new MyStr());
        list.add(new MyStr("Hello"));
        System.out.println(list.size() + " " + list.indexError(0));
        MyStr string = list.elementAt(0);
        string.str = string.str + ", world!";
        System.out.println(list.elementAt(0).str);
        list.modifyAt(new MyStr("0"), 0);
        for (Integer i = 1; i < 10; i++)
        {
            list.add(new MyStr(i.toString()), i.intValue());
            System.out.print(list.elementAt(i).str + " ");
        }
        list.removeAt(5);
        System.out.println();
        for (int i = 0; i < list.size(); i++)
        {
            System.out.print(list.elementAt(i).str + " ");
        }
        System.out.println();
        System.out.println(list.isEmpty());
        for (int i = 1; i < list.size(); i++)
        {
            System.out.println(list.elementAt(i-1).str + list.elementAt(i).str);
        }

    }
    public static void main(String[] args)
    {
        DoubleList<Integer> list = new DoubleList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.forEach((Integer i)-> System.out.print(i+" "));
//        List<MyStr> list = new DoubleList<MyStr>();
//        listAddTest(14,list);
//        listPrintTest(list);
//        listAddTest(5,10,new MyStr("_"),list);
//        listPrintTest(list);
//        listRemoveTest(0,4,list);
//        listPrintTest(list);
//        listModifyTest(3,9,new MyStr("* "),list);
//        listPrintTest(list);
    }
}