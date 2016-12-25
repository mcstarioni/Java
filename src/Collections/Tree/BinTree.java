package Collections.Tree;

/**
 * Created by mcstarioni on 30.11.2016.
 */
public class BinTree<T>
{
    int depth;
    int bottom;
    Node<T> head;

    public BinTree() {
        head = new Node<T>(null, null, null,0);
        depth = 0;
    }
    public void add(T element){
        if(head.value == null)
        {
            head.value = element;
        }
        else
        {
            //while()
        }
    }
}

