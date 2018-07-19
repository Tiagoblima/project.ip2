package main.java.br.ip2.project.view.front_controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GaleriaController implements Initializable {

    @FXML
    public VBox anchorGaleria;

    @FXML
    public AnchorPane content;

    @FXML
    public Pane drama;

   private AnchorPane telaFilmes;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        MenuBar menuBar = null;
        try {

            menuBar = FXMLLoader.load(getClass().getResource("../fxml/menu.fxml"));
            menuBar.setTranslateY(-740);
            anchorGaleria.getChildren().add(menuBar);

            this.telaFilmes = FXMLLoader.load(getClass().getResource("../fxml/telaFilmes.fxml"));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void toDrama(){

      this.content.getChildren().add(this.telaFilmes);
    }

}
