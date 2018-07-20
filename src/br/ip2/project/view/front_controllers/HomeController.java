package br.ip2.project.view.front_controllers;


import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.web.*;


import javafx.scene.layout.Pane;
import br.ip2.project.view.*;

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


        WebView webview = new WebView();
        WebEngine engine = webview.getEngine();
        engine.load("https://www.imdb.com/news/top?ref_=nv_nw_tp");
        webview.setPrefHeight(600);
        webview.setPrefWidth(700);
        feedNoticias.getChildren().add(webview);

    }

    public void toPerfil(ActionEvent actionEvent) { Main.changeScreen(Scenes.Perfil); }


    public void sair(ActionEvent actionEvent) {
        System.exit(0);
    }
}
