package br.ip2.project.view.front_controllers;

import br.ip2.project.controller.CatalogoController;
import br.ip2.project.controller.FilmeController;
import br.ip2.project.model.Catalogo;
import br.ip2.project.model.Filme;
import br.ip2.project.model.GeneroFilme;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TelaFilmesController implements Initializable{

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

    private GeneroFilme generoFilme;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        WebView[] webviews = new WebView[6];
        WebEngine[] engines = new WebEngine[6];


        FilmeController filmeController = new FilmeController();
        CatalogoController catalogoController = new CatalogoController(filmeController.getfHashmap());
        this.generoFilme =  GeneroFilme.ACAO;
        ArrayList<Filme> arrayFilme = catalogoController.getArrayFilmes(this.generoFilme);

        ArrayList<Pane> panes = new ArrayList<>();
        panes.add(pn1);
        panes.add(pn2);
        panes.add(pn3);
        panes.add(pn4);
        panes.add(pn5);
        panes.add(pn6);





       /* for (Filme filme: arrayFilme) {
            engines[i] = webview[i].getEngine();
            engines[i].load(filme.getUrlMiniatura());
            panes.get(i).getChildren().add(webview[i]);
            i++;
        }

        */
        int i = 0;
        for (WebView web: webviews) {
            webviews[i] = new WebView();
            webviews[i].setPrefWidth(200);
            webviews[i].setPrefHeight(300);
            i++;
        }
        i = 0;
        for (Filme filme: arrayFilme) {

            engines[i] = webviews[i].getEngine();
            engines[i].load(filme.getUrlMiniatura());
            panes.get(i).getChildren().add(webviews[i]);
            i++;
        }



    }


    public void setGenero(GeneroFilme genero){
        this.generoFilme =  GeneroFilme.DRAMA;
    }
}
