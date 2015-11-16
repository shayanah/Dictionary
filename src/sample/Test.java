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
        a.clearQueue();
        a.inorderWalk(a.getRoot());
        System.out.println(a);
        a.clearQueue();
        a.postorderWalk(a.getRoot());
        System.out.println(a);
        a.clearQueue();
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
        b.clearQueue();
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

        b.clearQueue();
        b.inorderWalk(b.getRoot());
        System.out.println(b);
        BinaryFile.saveTheInventory(new Food("burger","meat"),"test.bin");
        Food k = BinaryFile.readTheFood("test.bin");
        System.out.println("*********" + k);
        BST<Food> c = BinaryFile.readTheInventory("bin.out");
        System.out.println(c);
    }
}
