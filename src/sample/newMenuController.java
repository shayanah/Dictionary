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
    private boolean addClicked = false;
    public TextField nameTextField;
    public TextField ingredientTextField;


    private Stage dialogStage;
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
    public void addData(ActionEvent actionEvent) {
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
