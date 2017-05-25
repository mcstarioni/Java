package collections.List;

import collections.Collection;

/**
 * Created by mcstarioni on 22.10.2016.
 */
public interface List<T> extends Collection<T>
{
    public  void add(T element);
    public  void add(T element, int index);
    public  void modifyAt(T element, int index);
    public  void removeAt(int index);
    public  void removeObj(T object);
    public  T elementAt(int index);
    public  boolean isEmpty();
    public  boolean indexError(int index);
    public  void clear();
    public  int size();
    public  int search(T object);
    public  <E extends Collection<T>> void merge(E master, E merged);

    //public void
}
