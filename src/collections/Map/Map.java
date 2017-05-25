package collections.Map;

/**
 * Created by mcstarioni on 27.02.2017.
 */
public interface Map<K extends Comparable,V> extends Iterable<V>
{
    public V get(K key);
    public void add(K key, V value);
    public boolean contains(K key);
    public void set(K key, V value);

}
