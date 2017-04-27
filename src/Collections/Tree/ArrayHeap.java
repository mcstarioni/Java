package Collections.Tree;

import java.util.ArrayList;

/**
 * Created by mcstarioni on 27.04.2017.
 */
public class ArrayHeap<K,V>
{
    int lastIndex = 0;
    ArrayList<Node> array = new ArrayList<Node>(10);
    public void add(K key, V value)
    {
        int i = lastIndex;
        Node inserted = new Node(key,value);
        if(i == 0)
        {
            array.add(0,inserted);
        }
        else
        {
            int parentIndex = (i-1)/2;
//            while ()
//            {
//
//            }
        }
    }
    public void buildFromArray(K[] keys, V[] values)
    {
        if(keys.length != values.length)
        {
            try
            {
                throw new Exception("Arrays are not equal");
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            for (int i = 0; i < keys.length; i++)
            {
                array.add(new Node(keys[i],values[i]));
            }
        }
    }
    private class Node
    {
        K key;
        V value;
        BinaryTree.Node left;
        BinaryTree.Node right;
        Node(){}
        Node(K key, V value)
        {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }
}
