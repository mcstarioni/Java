package Collections.List;

import Collections.Collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by mcstarioni on 21.10.2016.
 */
public class SingleList<T> implements List<T>
{
    private Node head;
    private int size = 0;
    public SingleList()
    {
        head = new Node(null,null);
    }
    public void add(T element)
    {
        if(head.next == null)
        {
            head.next = new Node(element,null);
        }
        else
        {
            Node temp = head.next;
            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = new Node(element,null);
        }
        size++;
    }
    // {h 0 1 2 3 4 5} -> {h 0 1 2 3 _ 4 5} -> {h 0 1 2 3 4 5 6}
    public void add(T element, int index)
    {
        if(indexError(index))
        {
            System.out.println("\nError: Out of bounds.");
            return;
        }
        Node temp = head;
        for (int i = 0; i < index ; i++)
        {
            temp = temp.next;
        }
        if(temp.next != null)
            return;
        temp.next = new Node(element,temp.next);
        size++;
    }

    @Override
    public void modifyAt(T element, int index)
    {
        if(indexError(index))
        {
            System.out.println("\nError: Out of bounds.");
            return;
        }
        int i = 0;
        Node temp;
        for (temp = head; i <= index; temp = temp.next)
            i++;
        temp.element = element;
    }

    @Override
    public void removeAt(int index)
    {
        if(indexError(index))
        {
            System.out.println("\nError: Out of bounds.");
            return;
        }
        Node node1 = head;
        Node node2 = head.next;
        for (int i = 0; i < index; i++)
        {
            node1 = node1.next;
            node2 = node2.next;
        }
        node2 = node2.next;
        node1.next = node2;
        size--;
    }
    public void removeObj(T object)
    {
        int index = search(object);
        removeAt(index);
    }
    public int search(T object)
    {
        Node temp = head.next;
        for(int i = 0; i < size; i++)
        {
            //System.out.println(temp.toString());
            if(temp.element == object)
            {
                return i;
            }
            else
            {
                temp = temp.next;
            }
        }
        return -1;
    }
    public T elementAt(int index)
    {
        //size = 10
        if(indexError(index))
        {
            System.out.println("\nError: Out of bounds.");
            return null;
        }
        int i = 0;
        Node temp;
        for (temp = head; i <= index; temp = temp.next)
            i++;
        return temp.element;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void clear()
    {
        head.next = null;
        size = 0;
    }
    public  void reverse(Node start)
    {
        if(start.next == null)
        {
            head = new Node(null,start);
        }else
        {
            reverse(start.next);
            start.next.next = start;
        }
    }
    @Override
    public <E extends Collection<T>> void merge(E master, E merged)
    {

    }
    public Node getHead(){return head;}

    public int size()
    {
        return size;
    }

    public SingleList<T> copy()
    {
        SingleList<T> list = new SingleList<T>();
        for (Node temp = head; temp != null; temp = temp.next)
        {
            list.add(temp.element);
        }
        return list;
    }

    public boolean indexError(int index)
    {
        return ((index >= size) || (index < 0));
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        Node next;
        public ListIterator()
        {
            next = head.next;

        }
        public boolean hasNext() {
            return next != null;
        }
        public T next() {
            if (hasNext())
            {
                T value = next.element;
                next = next.next;
                return value;

            }else
            {
                System.out.println("Error. Iterator out of bounds");
                return null;
            }
        }
    }
    private class Node
    {
        protected T element;
        protected Node next;
        Node(T element,Node next)
        {
            this.element = element;
            this.next = next;
        }
        //protected boolean hasNext(){return this.next != null;}
    }
}
