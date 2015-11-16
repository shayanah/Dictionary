package sample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by shawn on 11/16/2015.
 */
public class BinaryFile
{
    public static void saveTheInventory(BST<Food> bst,String fileName)
    {

        try
        {
            FileOutputStream fileOs = new FileOutputStream(fileName);
            ObjectOutputStream os = new ObjectOutputStream(fileOs);

            os.writeObject(bst);
            os.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void saveTheInventory(Food food,String fileName)
    {

        try
        {
            FileOutputStream fileOs = new FileOutputStream(fileName);
            ObjectOutputStream os = new ObjectOutputStream(fileOs);

            os.writeObject(food);
            os.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static BST<Food> readTheInventory(String fileName)
    {
        BST<Food> bst = null;

        try
        {
            FileInputStream fileIs = new FileInputStream(fileName);
            ObjectInputStream is = new ObjectInputStream(fileIs);

            bst = (BST<Food>) is.readObject();
            is.close();
        }
        catch(Exception e) {}

        return bst;
    }
    public static Food readTheFood(String fileName)
    {
        Food food = null;

        try
        {
            FileInputStream fileIs = new FileInputStream(fileName);
            ObjectInputStream is = new ObjectInputStream(fileIs);

            food = (Food) is.readObject();
            is.close();
        }
        catch(Exception e) {}

        return food;
    }
}
