package main.java.br.ip2.project.view.front_controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import main.java.br.ip2.project.view.*;

import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable{


    @FXML
    public AnchorPane feedNoticias;
    public ScrollPane scroll;
    public Button refresh;
    @FXML
    public Pane pnPost;
    @FXML
    public Label lblpost;
    public AnchorPane anchorHome;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Pane pane = new Pane();
        MenuBar menuBar = null;
        try {
            menuBar = FXMLLoader.load(getClass().getResource("../fxml/menu.fxml"));
            anchorHome.getChildren().add(menuBar);
        } catch (IOException e) {
            e.printStackTrace();
        }

        pane.setStyle("-fx-background-color: gray");
        pane.setLayoutX(25.0);

        pane.setPrefHeight(75.0);
        pane.setPrefWidth(200.0);
        pane.getChildren().add(new Label("Olá"));

        feedNoticias.getChildren().add(pane);

    }

    public void toPerfil(ActionEvent actionEvent) {
        Main.changeScreen(Scenes.Perfil);
    }


    public void sair(ActionEvent actionEvent) {
        System.exit(0);
    }
}
