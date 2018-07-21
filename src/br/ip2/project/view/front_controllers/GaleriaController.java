package br.ip2.project.view.front_controllers;

import br.ip2.project.controller.CatalogoController;
import br.ip2.project.controller.FilmeController;
import br.ip2.project.model.Catalogo;
import br.ip2.project.model.Filme;
import br.ip2.project.model.GeneroFilme;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static br.ip2.project.model.GeneroFilme.*;
import static br.ip2.project.model.GeneroFilme.AVENTURA;
import static br.ip2.project.model.GeneroFilme.FAMILIA;

public class GaleriaController implements Initializable {

    @FXML
    public VBox anchorGaleria;

    @FXML
    public AnchorPane content;

    @FXML
    public Pane drama;

    @FXML
    public AnchorPane toWeb;
    @FXML
    public AnchorPane telaFilmes;


    private Stage stage;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        MenuBar menuBar;
        try {

            menuBar = FXMLLoader.load(getClass().getResource("../fxml/menu.fxml"));
            anchorGaleria.getChildren().add(menuBar);

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    private void setupWebview(Filme filme, double layoutX, double layoutY){


        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load(filme.getUrlMiniatura());
        webView.setPrefWidth(200);
        webView.setPrefHeight(300);

        webView.setLayoutX(layoutX);
        webView.setLayoutY(layoutY);
        webView.toFront();
        webView.setId(String.valueOf(filme.hashCode()));

        boolean add = this.telaFilmes.getChildren().add(webView);

    }


    private void setupButtons(Filme filme, double layoutX, double layoutY){

        ButtonBar buttonBar = new ButtonBar();

        Button detalhes = new Button();
        detalhes.setText("Detalhes");
        detalhes.setId(String.valueOf(filme.hashCode()));
        detalhes.setAlignment(Pos.CENTER);






        filme.setSinopse("https://www.imdb.com/title/tt0120815/plotsummary?ref_=ttpl_ql_3#synopsis");

        detalhes.setOnAction(event -> {

            WebView webView = new WebView();
            WebEngine webEngine = webView.getEngine();
            webView.setPrefWidth(400);
            webView.setPrefHeight(600);
            webView.setLayoutY(100);
            webView.setScaleZ(20);
            webEngine.load(filme.getSinopse());
            toWeb.getChildren().add(webView);
        });

        Button assistir = new Button();

        assistir.setText("Assistir");
        assistir.setId(String.valueOf(filme.hashCode()));
        assistir.setAlignment(Pos.CENTER);


        assistir.setOnAction(event -> {

            WebView webView = new WebView();
            WebEngine webEngine = webView.getEngine();

            stage = new Stage();
            filme.setUrlMidia("https://www.youtube.com/embed/7A18k0wFSK4");

            webView.setPrefWidth(1382.0);
            webView.setPrefHeight(784.0);
            webEngine.load(filme.getUrlMidia());
            stage.setScene(new Scene(webView));
            stage.setFullScreen(true);
            stage.show();

        });

        buttonBar.getButtons().add(detalhes);
        buttonBar.getButtons().add(assistir);

        buttonBar.setLayoutX(layoutX);
        buttonBar.setLayoutY(layoutY + 300);

        buttonBar.toFront();
        this.telaFilmes.getChildren().add(buttonBar);

    }

    private void showCatalogo(GeneroFilme generoFilme){


        CatalogoController Catalogocontroller = CatalogoController.getInstance();

        ArrayList<Filme> arrayFilme = Catalogocontroller.getArrayFilmes(generoFilme);

        double layoutX = 100;
        double layoutY = 200;

        int i = 0;
        for (Filme filme: arrayFilme) {


            setupWebview(filme, layoutX, layoutY);
            setupButtons(filme, layoutX, layoutY);


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
        showCatalogo(COMEDIA);
    }
    public void toNacionais(){
        showCatalogo(NACIONAIS);
    }

    public void toAventura(){
        showCatalogo(AVENTURA);
    }

    public void toFamilia(){
        showCatalogo(FAMILIA);
    }


}
