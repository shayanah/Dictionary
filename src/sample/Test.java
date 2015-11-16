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
        b.traveresal();
        b.inorderWalk(b.getRoot());

        System.out.println(b);
        /*Food f = b.search(new Food("pizza","sdf"));
        Food k = b.search(new Food("ee","sdf"));
        Food n = b.search(new Food("salad","sdf"));
        System.out.println(f);
        if(f != null)
        {
            f.setIngredient("cheese, mushrooms");
        }
        System.out.println(n);
        System.out.println(k);
        System.out.println(b);*/
        int i = 0;
        b.delete(new Food("salad", "sdf"));
      //  b.delete(new Food("beef", "sdf"));
        b.delete(new Food("steak", "sdf"));
      //  b.delete(new Food("pizza", "sdf"));
        b.delete(new Food ("greek salad","sdf"));
       // b.delete(new Food ("cheese","sdf"));
        b.delete(new Food ("salad","sdf"));

        b.traveresal();
        b.inorderWalk(b.getRoot());
        System.out.println(b);
    }
}
