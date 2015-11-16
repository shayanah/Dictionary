package sample;

/**
 * Created by shawn on 11/13/2015.
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class tableMenuController implements Initializable
{

    public TableView<Food> foodTable;
    public TableColumn<Food,String> nameCol;
    public TableColumn<Food,String> ingredientCol;
    public ObservableList<Food> foodData = FXCollections.observableArrayList();
    public Label nameLable;
    public Label ingredientLabel;
    private Stage popupStage;
    private Parent root;
    public TextField nameTextField;
    public TextField ingredientTextField;

    public void showTable()
    {

    }
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        foodData.add(new Food ("salad","sdf"));
        foodData.add(new Food ("beef","sdf"));
        foodData.add(new Food ("beef","sdf"));
        foodData.add(new Food ("steak","sdf"));
        foodData.add(new Food ("pizza","sdf"));
        foodData.add(new Food ("greek salad","sdf"));
        foodData.add(new Food ("salad","sdf"));
        foodData.add(new Food ("cheese","sdf"));


        nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        ingredientCol.setCellValueFactory( cellData -> cellData.getValue().ingredientProperty());

        foodTable.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> showFoodDetails(newValue));
        foodTable.setItems(foodData);
    }

    private void showFoodDetails(Food food)
    {
        if(food != null)
        {
            nameLable.setText(food.getName());
            ingredientLabel.setText(food.getIngredient());
        }

    }
    @FXML
    private void handleDeleteFood(ActionEvent actionEvent)
    {
        try
        {
            int selectedIndex = foodTable.getSelectionModel().getSelectedIndex();
            foodTable.getItems().remove(selectedIndex);
            //foodData.remove(selectedIndex);
        } catch (Exception e)
        {

        }

    }
    private newMenuController controller;
    private Stage dialogStage;
    private Parent page;
    FXMLLoader loader;
    public boolean showNewMenu(Food food)
    {

        try {
            // Load the fxml file and create a new stage for the popup dialog.
            loader = new FXMLLoader();
            //Parent root = loader.load(getClass().getResource("newMenu.fxml"));
            loader.setLocation(tableMenuController.class.getResource("newMenu.fxml"));
            page = loader.load();

            // Create the dialog Stage.
            dialogStage = new Stage();
            dialogStage.setTitle("Add New Person");
            Scene scene = new Scene(page,400,250);
            dialogStage.setScene(scene);
            dialogStage.setResizable(false);
            dialogStage.initModality(Modality.APPLICATION_MODAL);

            // Set the person into the controller.
            controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setFood(food);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            return controller.isAddClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void handleNewFood(ActionEvent actionEvent) throws IOException
    {

        Food temp = new Food();
        boolean addClicked = showNewMenu(temp);
        if(addClicked)
        {
            foodData.add(temp);
        }


    }



}
