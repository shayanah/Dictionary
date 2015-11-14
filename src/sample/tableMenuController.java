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
            System.out.println(foodData);
        } catch (Exception e)
        {

        }

    }

    public boolean showNewMenu(Food food) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(tableMenuController.class.getResource("newMenu.fxml"));
        Stage dialogeStage = new Stage();
        dialogeStage.setTitle("Add New Food");
        dialogeStage.initModality(Modality.APPLICATION_MODAL);
        AnchorPane page = (AnchorPane) loader.load();
        Scene scene = new Scene(page);
        dialogeStage.setScene(scene);

        //set the person into the newMenuController
        newMenuController controller = loader.getController();
        controller.setDialogeStage(dialogeStage);
        controller.setFood(food);
        dialogeStage.showAndWait();
        return controller.isAddClicked();
    }
    public void handleNewFood(ActionEvent actionEvent) throws IOException
    {


        showFoodDetails(new Food("dsf","sdf"));
       /* Parent root = FXMLLoader.load(getClass().getResource("newMenu.fxml"));
        Stage popupStage = new Stage();
        Scene scene = new Scene(root,400,250);
        popupStage.setScene(scene);
        popupStage.setResizable(false);
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.showAndWait();*/
    }



}
