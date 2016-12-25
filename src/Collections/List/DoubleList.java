package Collections.List;


import Collections.Collection;

import java.util.Iterator;

/**
 * Created by mcstarioni on 21.10.2016.
 */
public class DoubleList<T> implements List<T>
{
    private Node head;
    private Node tail;
    private int size;

    public void add(T element)
    {
        if(size == 0)
        {
            head.next = new Node(element,tail,head);
            tail.prev = head.next;
        }
        else
        {
            Node temp = head;
            while(temp.next != tail)
            {
                temp = temp.next;
            }
            temp.next = new Node(element,tail,temp);
            tail.prev = temp.next;
        }
        size++;

    }
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
        Node inserted = new Node(element,temp.next,temp);
        temp.next.prev = inserted;
        temp.next = inserted;
        size++;
    }

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
    public void removeAt(int index)
    {
        if(indexError(index))
        {
            System.out.println("\nError: Out of bounds.");
            return;
        }
        //          node1   node2
        // (H:n,0) (0:1,H) (1:2,0) 2 3 4 5 T
        // (H:n,1) (0:1,H) (1:2,H) 2 3 4 5 T
        Node node1 = head.next;
        Node node2;
        for (int i = 0; i < index; i++)
        {
            node1 = node1.next;
        }
        node2 = node1.next;
        node2.prev = node1.prev;
        node1.prev.next = node2;
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
    public <E extends Collection<T>> void merge(E master, E merged) {
    }

    public DoubleList()
    {
        head = new Node(null,tail,null);
        tail = new Node(null,null,head);
        size = 0;
    }

    public T elementAt(int index)
    {
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
        return (size == 0);
    }

    public void clear()
    {
        head.next = tail;
        tail.prev = head;
    }

    public int size()
    {
        return size;
    }

    public boolean indexError(int index)
    {
        return ((index >= size) || (index < 0));
    }

    public Iterator iterator()
    {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T>
    {
        Node next;
        public ListIterator()
        {
            next = head.next;

        }
        @Override
        public boolean hasNext() {
            return next != tail;
        }

        @Override
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
        T element;
        Node next;
        Node prev;
        Node(T element, Node next)
        {
            this.element = element;
            this.next = next;
            prev = null;
        }
        Node(T element, Node next, Node prev)
        {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
