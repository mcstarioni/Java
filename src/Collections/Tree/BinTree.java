package Collections.Tree;

/**
 * Created by mcstarioni on 30.11.2016.
 */
public class BinTree<T>
{
    T value;
    BinTree<T> left;
    BinTree<T> right;
    public BinTree(T value, BinTree<T> left, BinTree<T> right)
    {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinTree<T> getLeft() {
        return left;
    }

    public void setLeft(BinTree<T> left) {
        this.left = left;
    }

    public BinTree<T> getRight() {
        return right;
    }

    public void setRight(BinTree<T> right) {
        this.right = right;
    }
}
