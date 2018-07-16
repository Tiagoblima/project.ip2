package main.java.br.ip2.project.view.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import main.java.br.ip2.project.view.*;
import javax.swing.text.Document;

import javafx.scene.layout.Pane;
import org.w3c.dom.*;
import com.sun.org.apache.xerces.internal.dom.DocumentImpl;

import java.awt.*;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Pane pane = new Pane();

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
