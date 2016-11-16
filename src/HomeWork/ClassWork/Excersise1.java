package HomeWork.ClassWork;

import Collections.List.CollectionMain;
import Collections.List.List;
import Collections.List.SingleList;

/**
 * Created by mcstarioni on 16.11.2016.
 */
public class Excersise1 {
    public static void main(String[] args) {
        SingleList<Integer> list = new SingleList<>();
        CollectionMain.listAddTest(7,list);
        CollectionMain.listPrintTest(list);
        list.reverse(list.getHead());
        CollectionMain.listPrintTest(list);
    }
}
/*
0 1 2 3 4 5 6
6 5 4 3 2 1 0

 */