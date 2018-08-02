package br.ip2.easylend.view.front_controllers;


import br.ip2.easylend.controller.CatalogoController;
import br.ip2.easylend.controller.ClienteController;
import br.ip2.easylend.controller.KnnController;
import br.ip2.easylend.model.Filme;
import br.ip2.easylend.model.GeneroFilme;
import br.ip2.easylend.view.Main;
import br.ip2.easylend.view.Scenes;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HomeController implements Initializable{


    @FXML
    public AnchorPane feedNoticias;

    public AnchorPane anchorHome;

    public AnchorPane anSugestoes;

    private Pane telaFilmes;
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

        showCatalogo();
    }



    private void setupWebview(Filme filme, double layoutX, double layoutY){


        stageCreator(filme , layoutX , layoutY , this.telaFilmes);

    }

    static void stageCreator(Filme filme , double layoutX , double layoutY , Pane telaFilmes) {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load(filme.getUrlMiniatura());
        webView.setPrefWidth(100);
        webView.setPrefHeight(150);

        webView.setLayoutX(layoutX);
        webView.setLayoutY(layoutY);
        webView.toFront();
        webView.setId(String.valueOf(filme.hashCode()));

        boolean add = telaFilmes.getChildren().add(webView);
    }

    private void showCatalogo(){


        this.anSugestoes.getChildren().remove(this.telaFilmes);
        this.telaFilmes = new Pane();


       GeneroFilme predGenero = KnnController.getInstance().getpredGenero();

        System.out.println(predGenero);
       ArrayList<Filme> arrayFilmes = CatalogoController.getInstance().getArrayFilmes(predGenero);

        double layoutX = 50;
        double layoutY = 50;

        int i = 0;

        for (Filme filme: arrayFilmes) {

            setupWebview(filme, layoutX, layoutY);

            if(++i < 2){
                layoutX += 150;
            }else {
                layoutY += 250;
                layoutX = 50;
            }

        }
        this.telaFilmes.setLayoutY(0);
        this.anSugestoes.getChildren().add(this.telaFilmes);

    }

    public void toPerfil(ActionEvent actionEvent) {
        Main.changeScreen(Scenes.Perfil);
    }


    public void sair(ActionEvent actionEvent) {
        System.exit(0);
    }
}
