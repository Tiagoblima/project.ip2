package br.ip2.easylend.view.front_controllers;

import br.ip2.easylend.controller.CatalogoController;
import br.ip2.easylend.controller.FilmeController;
import br.ip2.easylend.model.Catalogo;
import br.ip2.easylend.model.Filme;
import br.ip2.easylend.model.GeneroFilme;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

import static br.ip2.easylend.model.GeneroFilme.*;
import static br.ip2.easylend.model.GeneroFilme.AVENTURA;
import static br.ip2.easylend.model.GeneroFilme.FAMILIA;

public class GaleriaController implements Initializable {

    @FXML
    public VBox anchorGaleria;

    @FXML
    public AnchorPane content;

    @FXML
    public Pane drama;

    @FXML
    public AnchorPane telaFilmes;

    @FXML
    public Label lblSinopse;

    @FXML
    public Label lblHoras;

    @FXML
    public Label lblMinutos;

    @FXML
    public AnchorPane pnDetalhes;

    @FXML
    public Label lblTitulo;

    @FXML
    public Label lblGenero;

    @FXML
    public Pane pnTrailer;

    @FXML
    public Pane pnMsg;

    private Stage stage;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        MenuBar menuBar;
        try {

            menuBar = FXMLLoader.load(getClass().getResource("../fxml/menu.fxml"));

            menuBar.setTranslateY(-770);
            anchorGaleria.getChildren().add(menuBar);

        } catch (IOException e) {
            e.printStackTrace();
        }

        pnDetalhes.setVisible(false);

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

    private void setupDetalhes(Filme filme){


        this.lblSinopse.setText(filme.getSinopse());
        this.lblHoras.setText(String.valueOf(filme.getDuracaoHora()));
        this.lblMinutos.setText(String.valueOf(filme.getDuracaoMinuto()));
        this.lblTitulo.setText(filme.getTitulo());
        this.lblGenero.setText(String.valueOf(filme.getGenero()));

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webView.setPrefWidth(450);
        webView.setPrefHeight(275);
        webView.setLayoutX(0);
        webView.setLayoutY(500);
        webEngine.loadContent(filme.getUrlTrailler());
        this.pnDetalhes.getChildren().add(webView);




    }
    private void setupButtons(Filme filme, double layoutX, double layoutY){

        ButtonBar buttonBar = new ButtonBar();

        Button btnDetalhe = new Button();
        btnDetalhe.setText("Detalhes");
        btnDetalhe.setId(String.valueOf(filme.hashCode()));
        btnDetalhe.setAlignment(Pos.CENTER);


        btnDetalhe.setOnAction(event -> {

            setupDetalhes(filme);
            pnDetalhes.setVisible(true);
        });

        Button btnAssistir = new Button();

        btnAssistir.setText("Assistir");
        btnAssistir.setId(String.valueOf(filme.hashCode()));
        btnAssistir.setAlignment(Pos.CENTER);


        btnAssistir.setOnAction(event -> {

            WebView webView = new WebView();
            WebEngine webEngine = webView.getEngine();

            stage = new Stage();

            webView.setPrefWidth(1382.0);
            webView.setPrefHeight(784.0);
            webEngine.loadContent(filme.getUrlFilme());
            stage.setScene(new Scene(webView));
            stage.setFullScreen(true);
            stage.show();


        });

        buttonBar.getButtons().add(btnDetalhe);
        buttonBar.getButtons().add(btnAssistir);

        buttonBar.setLayoutX(layoutX);
        buttonBar.setLayoutY(layoutY + 300);

        buttonBar.toFront();
        this.telaFilmes.getChildren().add(buttonBar);

    }

    private void showCatalogo(GeneroFilme generoFilme){



        CatalogoController Catalogocontroller = CatalogoController.getInstance();
        pnMsg.setVisible(false);
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
