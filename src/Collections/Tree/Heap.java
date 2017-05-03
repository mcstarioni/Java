package Collections.Tree;
/**
 * Created by mcstarioni on 20.04.2017.
 */
public class Heap<K extends Comparable,V> extends BinaryTree<K,V>
{
    private int levelSize = 1;
    private int filledSize = 0;
    private Node last;
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
            last = root;
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
            last = inserted;
        }
        size++;
        if(size == 2*levelSize-1){
            levelSize *= 2;
            filledSize = levelSize - 1;

        }
    }
    public Node popFirst()
    {
        Node first = new Node(root.key,root.value);
        if(last != root)
        {
            if (last.parent.left == last)
                last.parent.left = null;
            else
                last.parent.right = null;
            swap(root,last);
            downHeapify();
        }
        size--;
        return first;
    }

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
//              1
//          /       \
//         2          3
//       /   \       /   \
//      4     5     6     7
//    /  \   / \   / \   / \
//   8   9  10 11 12 13 14 15
    /*
        5 level = 3
        1 = 5 - 4

     */
    public final Node get(int position)
    {
        if(position == 1)
            return root;
        else
        {
            Node temp = root;
            int level = getLevel(position) - 1;
            int levelCount = (int)Math.pow(2,level);
            int i = position - levelCount;
            while (true)
            {
                levelCount /=2;
                if (i < levelCount)
                {
                    temp = temp.left;
                } else
                    temp = temp.right;
                level--;
                if (level == 0)
                    return temp;
            }

        }
    }
    public int getLevel(int number)
    {
        int i = 0;
        while(number > Math.pow(2,i))
        {
            i++;
        }
        return i;
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
        heap.printTree();
        heap.add(60,"");
        heap.printTree();
        System.out.println(heap.get(5).key);
        System.out.println(heap.popFirst().key);
        heap.printTree();
    }
    private void testNode()
    {
        Node a = new Node();
        a.left = new Node();
        //b = a.left;
    }
}
