package sample;

/**
 * Created by shawn on 11/11/2015.
 */
public class Test
{
    public static void main(String [] args)
    {
        BST<Integer> a = new BST<>();
        a.add(5);
        a.add(4);
        a.add(2);
        a.add(1);
        a.add(8);
        a.add(10);
        a.add(4);
        a.traveresal();
        a.inorderWalk(a.getRoot());
        System.out.println(a);
        a.traveresal();
        a.postorderWalk(a.getRoot());
        System.out.println(a);
        a.traveresal();
        a.preorderWalk(a.getRoot());
        System.out.println(a);
        BST<Food> b = new BST<>();
        b.add(new Food ("salad","sdf"));
        b.add(new Food ("beef","sdf"));
        b.add(new Food ("steak","sdf"));
        b.add(new Food ("pizza","sdf"));
        b.add(new Food ("greek salad","sdf"));
        b.add(new Food ("salad","sdf"));
        b.add(new Food ("cheese","sdf"));
        b.inorderWalk(b.getRoot());
        System.out.println(b);
    }
}
