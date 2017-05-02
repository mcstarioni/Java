package Collections.Tree;
/**
 * Created by mcstarioni on 20.04.2017.
 */
public class Heap<K extends Comparable,V> extends BinaryTree<K,V>
{
    private int levelSize = 1;
    private int filledSize = 0;
    Heap()
    {
        root = null;
    }
    public void add(K key, V value)
    {
        Node inserted = new Node(key,value);
        if(size == 0)
        {
            root = inserted;
            root.parent = null;
        }
        else
        {
            int i = Math.abs(size - filledSize);
            Node current = root;
            int currentSize = levelSize/2;
            while(true)
            {
                if(i < currentSize)
                {
                    if(current.left != null)
                    {
                        current = current.left;
                    }
                    else
                    {
                        inserted.parent = current;
                        current.left = inserted;
                        break;
                    }
                }
                else
                {
                    if(current.right != null)
                    {
                        current = current.right;
                    }
                    else
                    {
                        inserted.parent = current;
                        current.right = inserted;
                        break;
                    }
                    i -= currentSize;
                }
                currentSize /= 2;
            }
            heapify(inserted);
        }
        size++;
        if(size == 2*levelSize-1){
            levelSize *= 2;
            filledSize = levelSize - 1;

        }
    }
    public V removeFirst()
    {
        Node first = new Node(root.key,root.value);
        Node localRoot = root;
        while(localRoot.left != null || localRoot.right != null);
        {
            if (localRoot.left.key.compareTo(localRoot.right.key) >= 0)
            {
                localRoot.key = localRoot.left.key;
                localRoot.value = localRoot.left.value;
                localRoot = localRoot.left;
//                current = localRoot.left;
//                current.right = localRoot.right;
//                localRoot.right.parent = current;
            } else
            {
                localRoot.key = localRoot.right.key;
                localRoot.value = localRoot.right.value;
                localRoot = localRoot.right;
//
//                current = localRoot.right;
//                current.left = localRoot.left;
//                localRoot.left.parent = current;
            }
        }
        return null;
    }
//              1
//          /       \
//         2          3
//       /   \       /   \
//      4     5     6     7
//    /  \   / \   / \   / \
//   8   9  10 11 12 13 14 15

    public void printNodes(Node start)
    {
        Node temp = start;
        System.out.println(temp.key);
        if(temp.left != null)
        {
            printNodes(temp.left);
        }
        if(temp.right != null)
        {
            printNodes(temp.right);
        }
    }
    public void heapify(Node inserted)
    {
        while(inserted.parent != null && inserted.key.compareTo(inserted.parent.key)>0)
        {
            swap(inserted.parent,inserted);
            inserted = inserted.parent;
        }
    }
    public void swap(Node par, Node ans)
    {
        Node temp = new Node(par.key, par.value);
        par.value = ans.value;
        par.key = ans.key;
        ans.value = temp.value;
        ans.key = temp.key;
    }
    public void swapByPointer(Node par, Node ans)
    {
        if(par.left == ans)
        {
            Node temp = new Node(par.key,par.value);
            temp.left = ans.left;
            temp.right = ans.right;
            temp.parent = ans;
            ans.right = par.right;
            ans.left = par;
            if(par.parent != null)
                if(par.parent.left == par)
                    par.parent.left = ans;
                else
                    par.parent.right = ans;
            par = temp;
        }else
        {
            Node temp = new Node(ans.key,ans.value);
            temp.left = ans.left;
            temp.right = ans.right;
            temp.parent = ans;
            ans.left = par.left;
            ans.right = par;
            if(par.parent != null)
                if(par.parent.left == par)
                    par.parent.left = ans;
                else
                    par.parent.right = ans;
            par = temp;
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
        heap.add(60,"");
        heap.printTree();
    }
    private void testNode()
    {
        Node a = new Node();
        a.left = new Node();
        //b = a.left;
    }
}
