package Collections.Tree;

/**
 * Created by mcstarioni on 30.11.2016.
 */
public class Node<T>
{
    int level;
    T value;
    Node<T> left;
    Node<T> right;
    public Node(T value, Node<T> left, Node<T> right,int level)
    {
        this.value = value;
        this.left = left;
        this.right = right;
        this.level = level;

    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
}
