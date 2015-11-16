package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{

    public GridPane mainGrid;
    private Stage popupStage;
    private Parent root;


    public void addFunc(ActionEvent actionEvent) throws IOException {
    }

    public void searchFunc(ActionEvent actionEvent) {
    }

    public void deleteFunc(ActionEvent actionEvent) {

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void ShowListFunc(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("tableMenu.fxml"));
        Stage mainStage = (Stage) mainGrid.getScene().getWindow();
        Scene scene = new Scene(root,700,600);
        mainStage.setScene(scene);
        mainStage.setResizable(false);
        mainStage.show();
    }


}
