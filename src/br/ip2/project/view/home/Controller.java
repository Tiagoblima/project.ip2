package br.ip2.project.view.home;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import br.ip2.project.view.Main;
import br.ip2.project.view.Scenes;
import javax.swing.text.Document;

import javafx.scene.layout.Pane;
import org.w3c.dom.*;
import com.sun.org.apache.xerces.internal.dom.DocumentImpl;

import java.awt.*;
import java.io.IOException;

public class Controller {


    public AnchorPane feedNoticias;
    public ScrollPane scroll;
    public Button refresh;
    public Pane pnPost;
    public Label lblpost;

    public Controller() {


    }

    public void criar(){

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
}
