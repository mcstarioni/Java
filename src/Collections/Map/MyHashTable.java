package Collections.Map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by mcstarioni on 27.02.2017.
 */
//hello
public class MyHashTable<K extends Comparable,V> implements Map<K,V>
{
    private ArrayList<ItemList> items;
    private int size = 0;
    private int capacity;
    public MyHashTable(int capacity)
    {
        this.capacity = capacity;
        items = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++)
        {
            items.add(new ItemList());
        }
    }
    public V get(K key)
    {
        int index = getIndex(key.hashCode());
        try
        {
            ItemList temp = items.get(index);
            Item temp1 = temp.get(key);
            return temp1.value;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public V[] getArray(K key)
    {
        int index = getIndex(key.hashCode());
        return items.get(index).toArray();
    }
    public void add(K key, V value)
    {
        int index = getIndex(key.hashCode());
        try
        {
            items.get(index).add(key,value);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public boolean contains(K key)
    {
        return items.get(key.hashCode()).contains(key);
    }
    public void set(K key, V value)
    {
        int index = getIndex(key.hashCode());
        Item item;
        try
        {
            item = items.get(index).get(key);
            item.value = value;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void remove(K key)
    {
        int index = getIndex(key.hashCode());
        items.get(index).remove(key);

    }
    public Iterator<V> iterator()
    {
        return null;
    }
    private int getIndex(int hash){return hash%capacity;}
    private class Item
    {
        K key;
        V value;
        Item(K key, V value)
        {
            this.key = key;
            this.value = value;
        }
    }
    private class ItemList
    {
        public LinkedList<MyHashTable.Item> list = new LinkedList<>();
        MyHashTable.Item item = null;
        void add(K key, V value)throws Exception
        {
            if(!contains(key))
            {
                list.add(new Item(key,value));
            }
            else
            {
                throw new Exception("Such key already exists.");
            }
        }
        boolean contains(K key)
        {
            Iterator<MyHashTable.Item> it = list.iterator();
            while(it.hasNext() && list.size()!=0)
            {
                item = it.next();
                if(key.equals(item.key))
                    return true;
            }
            return false;
        }
        Item get(K key)throws Exception
        {
            if(contains(key))
            {
                return (Item)item;
            }
            else
            {
                throw new Exception("No such key.");
            }
        }
        void remove(K key)
        {
            if(contains(key))
            {
                list.remove(item);
            }
        }
        V[] toArray()
        {
            return null;
        }
    }

    public static void main(String[] args)
    {
        MyHashTable<String,Integer> hash = new MyHashTable<>(111);
        hash.add("Hello",100);
        hash.add(" world!",120);
        System.out.println(hash.get("Hello")+hash.get(" world!"));
        hash.set("Hello",-20);
        System.out.println(hash.get("Hello")+hash.get(" world!"));
        hash.remove("Hello");
        System.out.println(hash.get("Hello"));
    }
}
