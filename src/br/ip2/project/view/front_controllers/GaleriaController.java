package br.ip2.project.view.front_controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

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

   private TelaFilmesController telaController;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        MenuBar menuBar = null;
        try {

            menuBar = FXMLLoader.load(getClass().getResource("../fxml/menu.fxml"));
          //  menuBar.setTranslateY(-700);
            anchorGaleria.getChildren().add(menuBar);

            this.telaFilmes = FXMLLoader.load(getClass().getResource("../fxml/telaFilmes.fxml"));



        } catch (IOException e) {
            e.printStackTrace();
        }catch (NullPointerException n){
            System.out.println("Não achado");
        }

    }

    public void toDrama(){
        this.content.getChildren().add(this.telaFilmes);
    }

}
