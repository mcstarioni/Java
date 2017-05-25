package collections.Tree.TwoThreeFour;

/**
 * Created by mcstarioni on 25.05.2017.
 */

public class TwoThreeFourTree<K extends Comparable<K>,V> {
    private Node<K,V> root = new Node<K, V>();
    // -------------------------------------------------------------

    public V find(K key)
    {
        Node<K,V> curNode = root;
        int childNumber;
        while(true)
        {
            if(( childNumber=curNode.findItem(key) ) != -1)
                return curNode.getItem(childNumber).value; // Узел найден
            else if( curNode.isLeaf() )
                return null;
            else
                curNode = getNextChild(curNode, key);
        }
    }
    public void insert(K key, V value)
    {
        Node<K,V> curNode = root;
        Element<K,V> tempItem = new Element<K, V>(key, value);
        while(true)
        {
            if( curNode.isFull() )
            {
                split(curNode);
                curNode = curNode.getParent();
                curNode = getNextChild(curNode, key);
            }
            else if( curNode.isLeaf() )
                break;
            else
                curNode = getNextChild(curNode, key);
        }
        curNode.insertItem(tempItem);
    }
    public void split(Node<K,V> thisNode)
    {
        Element<K,V> itemB, itemC;
        Node<K,V> parent, child2, child3;
        int itemIndex;
        itemC = thisNode.removeItem();
        itemB = thisNode.removeItem();
        child2 = thisNode.disconnectChild(2);
        child3 = thisNode.disconnectChild(3);
        Node<K,V> newRight = new Node<K,V>();
        if(thisNode==root)
        {
            root = new Node<K,V>();
            parent = root;
            root.connectChild(0, thisNode);
        }
        else
            parent = thisNode.getParent();
        itemIndex = parent.insertItem(itemB);
        int n = parent.getNumItems();
        for(int j=n-1; j>itemIndex; j--)
        {
            Node<K,V> temp = parent.disconnectChild(j);
            parent.connectChild(j+1, temp);
        }
        parent.connectChild(itemIndex+1, newRight);
        newRight.insertItem(itemC);
        newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);
    }
    public Node<K,V> getNextChild(Node<K,V> theNode, K key)
    {
        int j;
        int numItems = theNode.getNumItems();
        for(j=0; j<numItems; j++)
        {
            if (key.compareTo(theNode.getItem(j).key) < 0)
                return theNode.getChild(j);
        }
        return theNode.getChild(j);
    }
    // -------------------------------------------------------------
    public void displayTree()
    {
        recDisplayTree(root, 0, 0);
    }
    private void recDisplayTree(Node<K,V> thisNode, int level,
                                int childNumber)
    {
        System.out.print("\nУровень="+level+" Потомок="+childNumber+" ");
        thisNode.displayNode();
        int numItems = thisNode.getNumItems();
        for(int j=0; j<numItems+1; j++)
        {
            Node<K,V> nextNode = thisNode.getChild(j);
            if(nextNode != null)
                recDisplayTree(nextNode, level+1, j);
            else
                return;
        }
    }

}
