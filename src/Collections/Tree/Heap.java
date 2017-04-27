package Collections.Tree;

import java.util.ArrayList;

/**
 * Created by mcstarioni on 20.04.2017.
 */
public class Heap<K extends Comparable,V> extends BinaryTree<K,V>
{
    int size = 0;
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
    public void buildFromArray(Node[] nodes)
    {
        for (Node node:nodes)
        {
            array.add(node);
        }
    }
    public void heapify()
    {

    }
    public class Node
    {
        K key;
        V value;
        Node(K key,V value)
        {
            this.key = key;
            this.value = value;
        }
    }
}
