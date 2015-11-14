package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by shawn on 11/14/2015.
 */
public class newMenuController
{
    Food food;
    public ObservableList<Food> foodData;
    public boolean isAddClicked()
    {

        return false;
    }

    public newMenuController( ObservableList<Food> foodData){ this.foodData = foodData;}
    public TextField nameTextField;
    public TextField ingredientTextField;

    public void setDialogeStage(Stage dialogeStage) {
        this.dialogeStage = dialogeStage;
    }

    private Stage dialogeStage;

    public void setFood(Food food)
    {
        this.food = food;
        nameTextField.setText(food.getName());
        ingredientTextField.setText(food.getIngredient());
    }
    public void addData(ActionEvent actionEvent) {
        /*if(nameTextField.getText() != "" && ingredientTextField.getText() != "")
        {

        }*/
    }
}
