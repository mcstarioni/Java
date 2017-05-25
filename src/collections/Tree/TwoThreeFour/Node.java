package collections.Tree.TwoThreeFour;

/**
 * Created by mcstarioni on 25.05.2017.
 */
public class Node<K extends Comparable<K>,V> {
    private static final int ORDER = 4;
    private int numItems;
    private Node parent;
    private Node<K,V> childArray[] = new Node[ORDER];
    private Element<K,V> itemArray[] = new Element[ORDER-1];
    public void connectChild(int childNum, Node child)
    {
        childArray[childNum] = child;
        if(child != null)
            child.parent = this;
    }
    public Node<K,V> disconnectChild(int childNum)
    {
        Node tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }
    // -------------------------------------------------------------
    public Node<K, V> getChild(int childNum)
    { return childArray[childNum]; }
    // -------------------------------------------------------------
    public Node<K,V> getParent()
    { return parent; }
    // -------------------------------------------------------------
    public boolean isLeaf()
    { return (childArray[0]==null) ? true : false; }
    // -------------------------------------------------------------
    public int getNumItems()
    { return numItems; }
    // -------------------------------------------------------------
    public Element<K,V> getItem(int index)
    { return itemArray[index]; }
    public boolean isFull()
    {
        return (numItems==ORDER-1);
    }
    public int findItem(K key)
    {
        for(int j=0; j<ORDER-1; j++)
        {
            if(itemArray[j] == null)
                break;
            else if(itemArray[j].equals(key))
                return j;
        }
        return -1;
    }
    // -------------------------------------------------------------
    public int insertItem(Element<K,V> element)
    {
        numItems++;
        for(int j=ORDER-2; j>=0; j--)
        {
            if(itemArray[j] == null)
                continue;
            else
            {
                if(element.key.compareTo(itemArray[j].key) < 0)
                    itemArray[j+1] = itemArray[j];
                else
                {
                    itemArray[j+1] = element;
                    return j+1;
                }
            }
        }
        itemArray[0] = element;
        return 0;
    }
    public Element<K,V> removeItem()
    {
        Element<K,V> temp = itemArray[numItems-1];
        itemArray[numItems-1] = null;
        numItems--;
        return temp;
    }
    public void displayNode()
    {
        for(int j=0; j<numItems; j++)
            System.out.print("("+itemArray[j].key+": "+itemArray[j].value+"), ");
    }
}
