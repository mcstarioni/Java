package Collections.List;

import Collections.Collection;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by mcstarioni on 21.10.2016.
 */
public class CircleList<T> implements List<T>
{
    public Node<T> head;
    private int size;
    public CircleList()
    {
        head = new Node<T>(null,head,head);
        size = 0;
    }
    @Override
    public void add(T element)
    {
        if(size == 0)
        {
            head.next = new Node<T>(element,head,head);
            head.prev = head.next;
        }
        else
        {
            Node<T> temp = head;
            while(temp.next != head)
            {
                temp = temp.next;
            }
            temp.next = new Node<T>(element,head,temp);
            head.prev = temp.next;
        }
        size++;

    }

    @Override
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
        Node<T> inserted = new Node<T>(element,temp.next,temp);
        temp.next.prev = inserted;
        temp.next = inserted;
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
        //          node1   node2
        // (H:n,0) (0:1,H) (1:2,0) 2 3 4 5 T
        // (H:n,1) (0:1,H) (1:2,H) 2 3 4 5 T
        Node<T> node1 = head.next;
        Node<T> node2;
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
        Node<T> temp = head.next;
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
    @Override
    public T elementAt(int index)
    {
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

    @Override
    public boolean isEmpty()
    {
        return (size == 0);
    }

    @Override
    public boolean indexError(int index)
    {
        return ((index >= size) || (index < 0));
    }

    @Override
    public void clear()
    {
        head.next = head;
        head.prev = head;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public <E extends Collection<T>> void merge(E master, E merged)
    {

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
