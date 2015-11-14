package sample;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shawn on 11/11/2015.
 */
public class BST<T extends Comparable<T>>
{
    private int lenght;
    private Node<T> root;
    private Queue<T> q;
    public BST()
    {
        root = null;
        q = new LinkedList<T>();
    }
    public void add(T data)
    {
        if(root == null)
        {
            root = new Node<>(data);
        }
        else
        {
            Node current = root;
            while(current != null)
            {
                if( data.compareTo((T) current.getData()) <= 0)
                {
                    if(current.getLeft() != null)
                        current = current.getLeft();
                    else
                    {
                        Node<T> newNode = new Node<>(data);
                        current.setLeft(newNode);
                        break;
                    }
                }
                else
                {
                    if(current.getRight() != null)
                        current = current.getRight();
                    else
                    {
                        Node<T> newNode = new Node<>(data);
                        current.setRight(newNode);
                        break;
                    }
                }
            }
        }
    }
    public void delete(T data){}
    public boolean search(T data)
    {
        return false;
    }

    public void inorderWalk(Node r)
    {
        if( r != null)
        {
            inorderWalk(r.getLeft());
            q.add((T) r.getData());
            inorderWalk(r.getRight());
        }
    }
    public void preorderWalk(Node r)
    {
        if( r != null)
        {
            q.add((T) r.getData());
            preorderWalk(r.getLeft());
            preorderWalk(r.getRight());
        }
    }
    public void postorderWalk(Node r)
    {
        if( r != null)
        {
            postorderWalk(r.getLeft());
            postorderWalk(r.getRight());
            q.add((T) r.getData());
        }
    }
    public void traveresal(){q= new LinkedList<T>();}

    @Override
    public String toString() {
        return "BST{" +
                "q=" + q +
                '}';
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }
}
