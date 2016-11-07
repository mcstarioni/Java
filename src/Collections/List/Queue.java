package Collections.List;

/**
 * Created by mcstarioni on 02.11.2016.
 */
public class Queue<T> extends Stack<T>
{
    public T popFirst()
    {
        T temp = elementAt(0);
        removeAt(0);
        return temp;
    }
    public T peekFirst()
    {
        return elementAt(0);
    }
    public void pushFirst(T element)
    {
        add(element,0);
    }
}
