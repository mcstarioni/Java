package Collections.List;

/**
 * Created by mcstarioni on 22.10.2016.
 */
public class Node<T>
{
    protected T element;
    protected Node<T> next;
    protected Node<T> prev;
    Node(T element, Node<T> next)
    {
        this.element = element;
        this.next = next;
        prev = null;
    }
    Node(T element, Node<T> next, Node<T> prev)
    {
        this.element = element;
        this.next = next;
        this.prev = prev;
    }
    T getElement()
    {
        return this.element;
    }
    Node<T> getNext()
    {
        return this.next;
    }
    Node<T> getPrev()
    {
        return prev;
    }
    void setElement(T element)
    {
        this.element = element;
    }
    void setNext(Node<T> next)
    {
        this.next = next;
    }
    void setPrev(Node<T> prev)
    {
        this.prev = prev;
    }
    boolean hasNext()
    {
        return next != null;
    }
}
