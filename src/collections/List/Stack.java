package collections.List;

/**
 * Created by mcstarioni on 02.11.2016.
 */
public class Stack<T> extends DoubleList<T>
{
    public T pop()
    {
        T temp = elementAt(size() - 1);
        removeAt(size() - 1);
        return temp;
    }
    public void push(T element)
    {
        add(element);
    }
    public T peek()
    {
        return elementAt(size() - 1);
    }
}
