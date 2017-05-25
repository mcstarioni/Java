package collections.Tree;
/**
 * Created by mcstarioni on 20.04.2017.
 */
public class Heap<K extends Comparable,V> extends BinaryTree<K,V>
{
    Heap()
    {
        super();
        function1 = (Node)->{heapify(Node);};
        function2 = (Node)->{downHeapify();};
    }
    public void heapify(Node inserted)
    {
        while(inserted.parent != null && inserted.key.compareTo(inserted.parent.key)>0)
        {
            swap(inserted.parent,inserted);
            inserted = inserted.parent;
        }
    }
    public void downHeapify()
    {
        Node inserted = root;
        while(inserted.left != null || inserted.right != null)
        {
            Node local;
            if(inserted.left != null && inserted.right != null)
            {
                if(inserted.left.key.compareTo(inserted.key) > 0 || inserted.right.key.compareTo(inserted.key) > 0)
                    local = (inserted.left.key.compareTo(inserted.right.key) > 0) ? inserted.left : inserted.right;
                else
                    break;
            }else
            {
                if(inserted.right != null)
                {
                    if(inserted.right.key.compareTo(inserted.key) > 0)
                        local = inserted.right;
                    else
                        break;
                }else
                {
                    if(inserted.left.key.compareTo(inserted.key) > 0)
                        local = inserted.left;
                    else
                        break;
                }
            }
            swap(inserted,local);
        }
    }
    public static void main(String[] args)
    {
        Heap<Integer, String> heap = new Heap<>();
        for(int i = 0; i < 30; i++)
        {
            heap.add(i,"");
        }
        //heap.printNodes(heap.root);
        heap.printTree();
        heap.add(60,"");
        heap.printTree();
        System.out.println(heap.get(5).key);
        System.out.println(heap.popFirst().key);
        System.out.println(heap.get(9).key);
        heap.printTree();
    }
}
