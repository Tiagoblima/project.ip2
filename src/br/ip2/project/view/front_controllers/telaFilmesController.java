package br.ip2.project.view.front_controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class telaFilmesController implements Initializable{

    @FXML
    public Pane pn1;
    @FXML
    public Pane pn2;
    @FXML
    public Pane pn3;
    @FXML
    public Pane pn4;
    @FXML
    public Pane pn5;
    @FXML
    public Pane pn6;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        WebView webview = new WebView();
        WebEngine engine = webview.getEngine();
        engine.load("http://t2.gstatic.com/images?q=tbn:ANd9GcR0lDhR_dXAKTm9wysp3nWu6kP0V5skJBVbCNC_Q8urAWcr4iF_");
        webview.setPrefHeight(200);
        webview.setPrefWidth(250);
        this.pn1.getChildren().add(webview);
    }
}
