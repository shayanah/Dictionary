package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by shawn on 11/14/2015.
 */
public class newMenuController
{
    public Button addBtn;
    public Label foundLabel;
    Food food;
    public ObservableList<Food> foodData;
    private boolean addClicked = false;
    public TextField nameTextField;
    public TextField ingredientTextField;



    private BST<Food> tree;
    private Stage dialogStage;
    public void setTree(BST<Food> tree) {this.tree = tree;}
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setFood(Food food)
    {
        this.food = food;
        nameTextField.setText(food.getName());
        ingredientTextField.setText(food.getIngredient());

    }
    public boolean isAddClicked()
    {
        return addClicked;
    }
    private boolean existFlag = true;
    public void addData(ActionEvent actionEvent)
    {
        if(existFlag)
        {
            if( nameTextField.getText() != null && ingredientTextField.getText() != null
                    && nameTextField.getText() != "" && ingredientTextField.getText() != "")
            {
                if( tree.search(new Food(nameTextField.getText(),ingredientTextField.getText())) == null )
                {
                    existFlag = false;
                    addBtn.setText("Add");
                    foundLabel.setText("");
                }
                else
                {
                    foundLabel.setText("Your choice of food is already in the menu");
                }
            }

        }
        else
        {
            if( nameTextField.getText() != null && ingredientTextField.getText() != null
                    && nameTextField.getText() != "" && ingredientTextField.getText() != "")
            {
                food.setName(nameTextField.getText());
                food.setIngredient(ingredientTextField.getText());
                addClicked = true;
                dialogStage.close();
            }
        }

    }


}
