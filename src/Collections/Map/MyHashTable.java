package Collections.Map;

import java.util.Iterator;

/**
 * Created by mcstarioni on 27.02.2017.
 */
public class MyHashTable<K, V> implements Map<K,V>
{
    private int[] keys;
    private Object[] values;
    public MyHashTable(int capacity)
    {
        values = new Object[capacity];
    }
    public V get(K key)
    {
        return null;
    }

    public void add(K key, V value)
    {

    }

    public boolean contains(K key)
    {
        return false;
    }

    public void setAt(K key, V value)
    {

    }

    public Iterator<V> iterator()
    {
        return null;
    }
}
