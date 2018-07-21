package br.ip2.project.view.front_controllers;

import br.ip2.project.controller.CatalogoController;
import br.ip2.project.model.Filme;
import br.ip2.project.model.GeneroFilme;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static br.ip2.project.model.GeneroFilme.*;

public class TelaFilmesController implements Initializable{

    @FXML
    public Pane pn1;

    public AnchorPane telafilmes;

    private GeneroFilme generoFilme;

    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }


    private void showCatalogo(GeneroFilme generoFilme){


        CatalogoController Catalogocontroller = CatalogoController.getInstance();

        this.generoFilme =  generoFilme;
        ArrayList<Filme> arrayFilme = Catalogocontroller.getArrayFilmes(this.generoFilme);






        double layoutX = 100;
        double layoutY = 200;

        int i = 0;

        for (Filme filme: arrayFilme) {

            WebView webView = new WebView();
            WebEngine webEngine = webView.getEngine();
            webEngine.load(filme.getUrlMiniatura());
            webView.setPrefWidth(200);
            webView.setPrefHeight(300);

            webView.setLayoutX(layoutX);
            webView.setLayoutY(layoutY);
            webView.toFront();
            webView.setId(String.valueOf(filme.hashCode()));

            boolean add = telafilmes.getChildren().add(webView);


            if(++i < 3){
                layoutX += 300;
            }else {
                layoutY += 400;
                layoutX = 100;
            }


        }

    }
    public void toDrama(){

        showCatalogo(DRAMA);
    }
    public void toAcao(){
        showCatalogo(ACAO);
    }

    public void toComedia(){


    }
    public void toNacionais(){


    }
    public void setGenero(GeneroFilme genero){
        this.generoFilme =  DRAMA;
    }
}
