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


    public Label feedNoticias;
    public AnchorPane main;
    public ScrollPane scroll;

    public Controller() {


    }

    public void criar(){

        feedNoticias.setText("Olá");
    }
    public void toPerfil(ActionEvent actionEvent) {
        Main.changeScreen(Scenes.Perfil);
    }
}
