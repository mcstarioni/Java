package collections.Tree;

/**
 * Created by mcstarioni on 27.04.2017.
 */
public class BinaryTree<K,V> extends Tree<K,V>
{
    protected int levelSize = 1;
    protected int filledSize = 0;
    protected Node last;
    protected Function function1 = (Node)->{};
    protected Function function2 = (Node)->{};
    public BinaryTree()
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
            function1.heapify(inserted);
            last = inserted;
        }
        size++;
        if(size == 2*levelSize-1){
            levelSize *= 2;
            filledSize = levelSize - 1;

        }
    }
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
    protected int getLevel(int number)
    {
        int i = 0;
        while(number > Math.pow(2,i))
        {
            i++;
        }
        return i;
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
            function2.heapify(root);
        }
        size--;
        return first;
    }
    protected void swap(Node par, Node ans)
    {
        Node temp = new Node(par.key, par.value);
        par.value = ans.value;
        par.key = ans.key;
        ans.value = temp.value;
        ans.key = temp.key;
    }
    protected void remove(int position)
    {
        Node temp = get(position);
        swap(temp,last);
        if(last != root)
        {
            if (last.parent.left == last)
                last.parent.left = null;
            else
                last.parent.right = null;
        }
    }
    public static void main(String[] args)
    {
        BinaryTree<Integer,String> tree = new BinaryTree<>();
        for(int i = 0; i < 30; i++)
        {
            tree.add(i,"");
        }
        tree.printTree();
        tree.remove(3);
        tree.add(5,"");
        tree.printTree();
    }
}
