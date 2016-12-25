package Collections.Tree;

/**
 * Created by mcstarioni on 30.11.2016.
 */
public class Node<T> {
    protected int successors;
    protected int level;
    protected T value;
    protected Node<T> left;
    protected Node<T> right;

    public Node(T value, Node<T> left, Node<T> right,int level) {
        this.value = value;
        this.level = level;
        this.left = left;
        this.right = right;
    }
    public boolean isBalanced() {
        return false;
    }
    public boolean isLeaf() {
        if (left == null && right == null) return true;
        return false;
    }

    public void add(T element) {
        if (this.isBalanced()) {
            left.add(element);
        }

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
