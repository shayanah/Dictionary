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
        lenght = 0;
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
    public boolean delete(T data)
    {
        try
        {
            if(isEmpty())
            {
                try{ throw new EmptyException(); }
                catch (EmptyException e){}
                return false;
            }
            else
            {
                Node current = root;
                Node parent = null;
                while(current != null )
                {
                    if(current.getData().equals(data))
                    {
                        removeData(current,parent);
                        lenght--;
                        return true;
                    }

                    else
                    {
                        parent = current;
                        if( data.compareTo((T) current.getData()) <= 0)
                            current = current.getLeft();
                        else
                            current = current.getRight();
                    }
                }
            }

        }
        catch (Exception e) {}
        return false;
    }

    private boolean isEmpty()
    {
        if(root == null)
            return true;
        else
            return false;
    }

    private void removeData(Node current,Node parent)
    {
        try {
            if(parent == null)
            {
                if(leafAnalyze(current))
                {
                    current = null;
                    root = null;
                }
                else if(oneChildAnalyze(current))
                {
                    if(current.getLeft() != null)
                        root = current.getLeft();
                    else
                        root = current.getRight();
                }
                else
                {
                    //two child analyze
                    twoChildRemove(current);
                }
            }
            else
            {
                if(leafAnalyze(current))
                {
                    if( parent.getLeft().getData().equals(current.getData()) )
                    {
                        parent.setLeft(null);
                    }
                    else
                    {
                        parent.setRight(null);
                    }
                }
                else if(oneChildAnalyze(current))
                {
                    oneChildRemove(current,parent);
                }
                else
                {
                    //two child analyze true
                    twoChildRemove(current);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void twoChildRemove(Node current)
    {
        Node succesor = current.getLeft();
        Node parent = current;
        while(succesor.getRight() != null)
        {
            parent = succesor;
            succesor = succesor.getRight();
        }

        if(leafAnalyze(succesor))
        {
            current.setData(succesor.getData());
            if(parent != current)
                parent.setRight(null);
            else
                parent.setLeft(null);
        }
        else
        {
            //one child analyze
            current.setData(succesor.getData());
            oneChildRemove(succesor,parent);

        }
    }


    private void oneChildRemove(Node current, Node parent)
    {
        if( parent.getLeft().getData().equals(current.getData()) )
        {
            if(current.getLeft() != null)
                parent.setLeft(current.getLeft());
            else
                parent.setLeft(current.getRight());

        }
        else
        {
            if(current.getLeft() != null)
                parent.setRight(current.getLeft());
            else
                parent.setRight(current.getRight());
        }
    }
    private boolean oneChildAnalyze(Node current)
    {
        if(current.getLeft() != null && current.getRight() != null)
            return false;
        if(current.getLeft() != null)
            return true;
        if(current.getRight() != null)
            return true;
        return false;
    }

    private boolean leafAnalyze(Node current)
    {
        if(current.getLeft() == null && current.getRight() == null)
            return true;
        else
            return false;
    }

    public T search(T data)
    {

        try
        {
            Node current = root;
            while(current != null )
            {
                if(current.getData().equals(data))
                {
                    return (T) current.getData();
                }

                else
                {
                    if( data.compareTo((T) current.getData()) <= 0)
                        current = current.getLeft();
                    else
                        current = current.getRight();
                }
            }
        }
        catch (Exception e) {}
        return null;
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
