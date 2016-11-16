package Collections.List;

import Collections.Collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by mcstarioni on 21.10.2016.
 */
public class SingleList<T> implements List<T>
{
    private Node<T> head;
    private int size = 0;
    public SingleList()
    {
        head = new Node<T>(null,null);
    }
    public void add(T element)
    {
        if(head.next == null)
        {
            head.next = new Node<T>(element,null);
        }
        else
        {
            Node<T> temp = head.next;
            while(temp.hasNext())
            {
                temp = temp.next;
            }
            temp.next = new Node<T>(element,null);
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
        Node<T> temp = head;
        for (int i = 0; i < index ; i++)
        {
            temp = temp.next;
        }
        if(!temp.hasNext())
            return;
        temp.next = new Node<T>(element,temp.next);
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
        Node<T> temp;
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
        Node<T> node1 = head;
        Node<T> node2 = head.next;
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
        Node<T> temp = head.next;
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
        Node<T> temp;
        for (temp = head; i <= index; temp = temp.next)
            i++;
        return temp.element;
    }

    public boolean isEmpty()
    {
        return !head.hasNext();
    }

    public void clear()
    {
        head.next = null;
        size = 0;
    }
    public  void reverse(Node<T> start)
    {
        if(start.next == null)
        {
            head = new Node<T>(null,start);
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
    public Node<T> getHead(){return head;}

    public int size()
    {
        return size;
    }

    public SingleList<T> copy()
    {
        SingleList<T> list = new SingleList<T>();
        for (Node<T> temp = head; temp != null; temp = temp.next)
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
    @Override
    public Iterator iterator()
    {
        return null;
    }

    /**
     * Performs the given action for each element of the {@code Iterable}
     * until all elements have been processed or the action throws an
     * exception.  Unless otherwise specified by the implementing class,
     * actions are performed in the order of iteration (if an iteration order
     * is specified).  Exceptions thrown by the action are relayed to the
     * caller.
     *
     * @param action The action to be performed for each element
     * @throws NullPointerException if the specified action is null
     * @implSpec <p>The default implementation behaves as if:
     * <pre>{@code
     *     for (T t : this)
     *         action.accept(t);
     * }</pre>
     * @since 1.8
     */
    @Override
    public void forEach(Consumer action)
    {


    }

    /**
     * Creates a {@link Spliterator} over the elements described by this
     * {@code Iterable}.
     *
     * @return a {@code Spliterator} over the elements described by this
     * {@code Iterable}.
     * @implSpec The default implementation creates an
     * <em><a href="Spliterator.html#binding">early-binding</a></em>
     * spliterator from the iterable's {@code Iterator}.  The spliterator
     * inherits the <em>fail-fast</em> properties of the iterable's iterator.
     * @implNote The default implementation should usually be overridden.  The
     * spliterator returned by the default implementation has poor splitting
     * capabilities, is unsized, and does not report any spliterator
     * characteristics. Implementing classes can nearly always provide a
     * better implementation.
     * @since 1.8
     */
    @Override
    public Spliterator spliterator()
    {
        return null;
    }
}
