package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{

    private Stage popupStage;
    private Parent root;


    public void addFunc(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("newMenu.fxml"));
        popupStage = new Stage();
        Scene scene = new Scene(root,400,250);
        popupStage.setScene(scene);
        popupStage.setResizable(false);
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.showAndWait();

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
        popupStage = new Stage();
        Scene scene = new Scene(root,700,600);
        popupStage.setScene(scene);
        popupStage.setResizable(false);
        popupStage.initModality(Modality.WINDOW_MODAL);
        popupStage.showAndWait();
    }


}
