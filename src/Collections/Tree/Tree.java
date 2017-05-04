package Collections.Tree;

import Collections.List.Stack;

/**
 * Created by mcstarioni on 03.05.2017.
 */
public abstract class Tree<K,V>
{
    protected Node root;
    protected int size = 0;
    public void printTree()
    {
        Stack<Node> global = new Stack<>();
        global.push(root);
        int spaces = 32;
        boolean isRowEmpty = false;
        for (int i = 0; i < spaces; i++)
        {
            System.out.print('.');
        }
        System.out.println();
        while(!isRowEmpty )
        {
            Stack<Node> local = new Stack<>();
            isRowEmpty = true;
            for (int i = 0; i < spaces; i++)
            {
                System.out.print(' ');
            }
            while (!global.isEmpty())
            {
                Node temp = global.pop();
                if(temp != null)
                {
                    System.out.print(temp.key.toString() +":"+temp.value.toString());
                    local.push(temp.left);
                    local.push(temp.right);
                    if(temp.left != null || temp.right != null)
                    {
                        isRowEmpty = false;
                    }
                }
                else
                {
                    System.out.print("_ _");
                    local.push(null);
                    local.push(null);
                }
                for (int i = 0; i < spaces*2-2; i++)
                {
                    System.out.print(' ');
                }
            }
            System.out.println();
            spaces = spaces/2;
            while(!local.isEmpty())
            {
                global.push(local.pop());
            }
        }
        System.out.println();
    }
    protected class Node
    {
        K key;
        V value;
        Node left;
        Node right;
        Node parent = null;

        Node()
        {
        }

        Node(K key, V value)
        {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }
}
