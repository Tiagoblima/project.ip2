package br.ip2.easylend.view.front_controllers;


import br.ip2.easylend.view.Main;
import br.ip2.easylend.view.Scenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

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
        webview.setPrefHeight(550);
        webview.setPrefWidth(430);
        webview.setZoom(0.65);
        feedNoticias.getChildren().add(webview);

    }

    public void toPerfil(ActionEvent actionEvent) {
        Main.changeScreen(Scenes.Perfil);


    }


    public void sair(ActionEvent actionEvent) {
        System.exit(0);
    }
}
