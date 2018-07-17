package main.java.br.ip2.project.view.front_controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GaleriaController implements Initializable {

    @FXML
    public VBox anchorGaleria;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        MenuBar menuBar = null;
        try {

            menuBar = FXMLLoader.load(getClass().getResource("../fxml/menu.fxml"));
            menuBar.setTranslateY(-575);
           anchorGaleria.getChildren().add(menuBar);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
