package Collections.Tree;

import Collections.List.Stack;
import Collections.Map.Pair;
import HomeWork.CalculatorGUI.RPN;
import com.sun.awt.AWTUtilities;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.jar.JarFile;

/**
 * Created by mcstarioni on 30.11.2016.
 */
public class BinaryTree<K extends Comparable,V> implements Iterable<V>
{
    Node root;
    int size = 0;
    public BinaryTree()
    {
        root = null;
    }
    public BinaryTree(K key, V value){root = new Node(key,value);}
    public void add(K key, V value)
    {
        Node added = new Node(key,value);
        if(root == null)
        {
            root = added;
        }
        else
        {
            Node current = root;
            Node last = null;
            while(true)
            {
                int compare = key.compareTo(current.key);
                last = current;
                if(compare < 0)
                {
                    current = current.left;
                    if (current == null)
                    {
                        last.left  = added;
                        return;
                    }
                }
                else
                {
                    current = current.right;
                    if(current == null)
                    {
                        last.right = added;
                        return;
                    }
                }
            }
        }
    }
    public V get(K key)
    {
        Node current = root;
        while(!key.equals(current.key))
        {
            int compare = key.compareTo(current.key);
            if(compare < 0)
                current = current.left;
            else
                current = current.right;
            if (current == null)
            {
                return null;
            }
        }
        if(current == null)
        {
            System.out.println("Not foutnd");
        }

        return current.value;
    }
    public Pair<K,V> getPair(K key)
    {
        V value = get(key);
        if(value != null)
            return new Pair<K, V>(key,value);
        else
            return null;
    }
    public void set(K key)
    {

    }
    public void remove(K key)
    {
        Node current = root;
        Node last = root;
        boolean isLeftChild = true;
        while(!key.equals(current.key))
        {
            last = current;
            int compare = key.compareTo(current.key);
            if(compare < 0)
            {
                isLeftChild = true;
                current = current.left;
            }
            else
            {
                isLeftChild = false;
                current = current.right;
            }
            if(current == null)
            {
                return;
            }
        }
        //System.out.println(current.key.toString() + " " + current.value.toString());
        if(current.left == null && current.right == null)
        {
            //System.out.println("Option one");
            if(current == root)
            {
                root = null;
            }
            else
            {
                if(isLeftChild)
                    last.left = null;
                else
                    last.right = null;
            }
        }
        else
        {
            //System.out.println("Second option");
            if(current.left == null)
                if(current == root)
                    root = current.right;
                else if(isLeftChild)
                        last.left = current.right;
                    else
                        last.right = current.right;
            else
            {
                if(current.right == null)
                {
                    if(current == root)
                        root = current.left;
                    else if (isLeftChild)
                            last.left = current.left;
                        else
                            last.right = current.left;
                }
                else
                {
                    System.out.println("Third option");
                    Node temp = getSuccessor(current);
                    if(current == root)
                        root = temp;
                    if (isLeftChild)
                        last.left = temp;
                    else
                        last.right = temp;
                }
            }
        }
    }
    private Node getSuccessor(Node current)
    {
        Node last = current;
        Node successor = current.right;
        while(successor.left != null)
        {
            last = successor;
            successor = successor.left;
        }
        successor.left = current.left;
        return successor;
    }
    public void iterateInOrder(Consumer<V> action)
    {
        //action.accept(V);
    }
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
    public Iterator<V> iterator()
    {
        return null;
    }
    private class TreeIterator<V> implements Iterator<V>
    {
        Node current = root;
        @Override
        public boolean hasNext()
        {
            if(current == null)
                return false;
            else
                if(current.left == null || current.right == null)
                    return false;
            return false;
        }

        @Override
        public V next()
        {
            return null;
        }

        @Override
        public void remove()
        {

        }
    }
    private class Node
    {
        K key;
        V value;
        Node left;
        Node right;
        Node(K key, V value)
        {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }
    public void print()
    {
        System.out.println(root.left.value);
    }
    public static void main(String[] args)
    {
        BinaryTree<Integer,String> tree = new BinaryTree<>();
        tree.add(100,"Hello");
        tree.add(120,"world");
        tree.add(90,"brave");
        tree.add(107,"I love java");
        //System.out.println(tree.get("1"));
        //tree.print();
        tree.printTree();
        //System.out.println(tree.root.value);
        //tree.remove("1");
        //System.out.println(tree.get("1 2"));
        //System.out.println(tree.root.value);
    }

}
