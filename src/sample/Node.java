package sample;

/**
 * Created by shawn on 11/11/2015.
 */
public class Node<T extends Comparable<T>>
{
    private T data;
    private Node left;
    private Node right;
    public Node(T data)
    {
        this.data = data;
        left = null;
        right = null;
    }
    public Node()
    {
        this.data = null;
        left = null;
        right = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
