package collections.Tree;

/**
 * Created by mcstarioni on 03.05.2017.
 */
public class PriorityQueue<V>
{
    private Heap<Integer,V> heap;
    public void add(int priority,V value)
    {
        heap.add(priority,value);
    }
    public V peek()
    {
        return heap.get(1).value;
    }
    public V pop()
    {
        return heap.popFirst().value;
    }
}
