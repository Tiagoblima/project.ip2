package br.ip2.easylend.view.front_controllers;

import br.ip2.easylend.controller.CatalogoController;
import br.ip2.easylend.controller.ClienteController;
import br.ip2.easylend.model.Cliente;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static br.ip2.easylend.model.GeneroFilme.*;

public class GaleriaController implements Initializable {


    @FXML
    public Pane drama;

    @FXML
    private Pane telaCatalogo;

    @FXML
    public BorderPane pnMain;

    @FXML
    public Label lblMsg;

    public AnchorPane pnDetalhes;

    @FXML
    public Label lblTitulo;

    @FXML
    public TextArea txtaSinopse;

    @FXML
    public Label lblHoras;

    @FXML
    public Label lblMinutos;

    @FXML
    public Label lblGenero;

    @FXML
    public Label lblPreco;

    @FXML
    public Button btnAdquirir;

    @FXML
    public Button btnTrailler;
    @FXML
    public Pane nacionais;

    @FXML
    public AnchorPane anchorCatalogo;

    @FXML
    private Stage stage;

    private ArrayList<WebView> webViewArrayList = new ArrayList <>();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        MenuBar menuBar = null;
        try {
            menuBar = FXMLLoader.load(getClass().getResource("/fxml/menu.fxml"));
            pnMain.setTop(menuBar);
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
        webViewArrayList.add(webView);
        boolean add = this.telaCatalogo.getChildren().add(webView);

    }

    private void setupDetalhes(Filme filme){



        this.txtaSinopse.setText(filme.getSinopse());
        this.lblHoras.setText(String.valueOf(filme.getDuracaoHora()));
        this.lblMinutos.setText(String.valueOf(filme.getDuracaoMinuto()));
        this.lblTitulo.setText(filme.getTitulo());
        this.lblGenero.setText(String.valueOf(filme.getGenero()));
        this.lblPreco.setText(String.valueOf(filme.getPreco()));


        btnTrailler.setOnAction(event -> {


            WebView webView = new WebView();
            WebEngine webEngine = webView.getEngine();

           Stage stTrailler = new Stage();

            webView.setPrefWidth(450);
            webView.setPrefHeight(275);
            webEngine.loadContent(filme.getUrlTrailler());
            stTrailler.setScene(new Scene(webView));

            stTrailler.show();

        });

        btnAdquirir.setOnAction(event -> {

            Stage comprar = new Stage();


            AnchorPane anchorPane = new AnchorPane();

            Cliente cliente = ClienteController.getInstance().getCliente();

            String msg = "Você possui " + cliente.getCredito() + "\n"
                         + "Confirmar compra? ";

            anchorPane.getChildren().add(new Label(msg));

            ButtonBar btnBar = new ButtonBar();

            btnBar.setLayoutX(50);
            btnBar.setLayoutY(100);
            Button btnCancelar = new Button("Cancelar");
            btnCancelar.setCancelButton(true);

            btnCancelar.setOnAction(new EventHandler <ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                      comprar.close();
                }
            });

            Button btnConfirmar = new Button("Confirmar");



            btnConfirmar.setOnAction(new EventHandler <ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {


                    Stage confirmado = new Stage();

                    String msg = "Compra confirmada";

                    try {

                        cliente.adicionarFilme(filme);

                    } catch (Exception e) {
                        msg = "Você já possui esse filme\n" +
                                "ou não possui crédito suficiente";

                    }

                    AnchorPane pnMsg = new AnchorPane();

                    pnMsg.setPrefWidth(100);
                    pnMsg.setPrefHeight(50);

                    Label label = new Label(msg);

                    label.setLayoutX(0);
                    label.setLayoutY(0);
                    pnMsg.getChildren().add(label);

                    Button btnOk = new Button("OK");
                    btnOk.setOnAction(new EventHandler <ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            confirmado.close();
                        }
                    });

                    btnOk.setLayoutX(90);
                    btnOk.setLayoutY(50);
                    pnMsg.getChildren().add(btnOk);
                    confirmado.setScene(new Scene(pnMsg));

                    confirmado.show();
                }
            });


            btnBar.getButtons().add(btnCancelar);
            btnBar.getButtons().add(btnConfirmar);
            anchorPane.getChildren().add(btnBar);
            Scene scene = new Scene(anchorPane);
            comprar.setScene(scene);

            comprar.show();


        });

        pnDetalhes.setVisible(true);

    }
    private void setupButtons(Filme filme, double layoutX, double layoutY){
//
        ButtonBar buttonBar = new ButtonBar();

        Button btnDetalhe = new Button();
        btnDetalhe.setText("Detalhes");
        btnDetalhe.setId(String.valueOf(filme.hashCode()));
        btnDetalhe.setAlignment(Pos.CENTER);


        btnDetalhe.setOnAction(event -> { setupDetalhes(filme); });


        buttonBar.getButtons().add(btnDetalhe);


        buttonBar.setLayoutX(layoutX);
        buttonBar.setLayoutY(layoutY + 300);

        buttonBar.toFront();
        this.telaCatalogo.getChildren().add(buttonBar);

    }

    private void showCatalogo(GeneroFilme generoFilme){


        this.anchorCatalogo.getChildren().remove(this.telaCatalogo);
        this.telaCatalogo = new Pane();
        CatalogoController Catalogocontroller = CatalogoController.getInstance();
        lblMsg.setVisible(false);

        ArrayList<Filme> arrayFilme = Catalogocontroller.getArrayFilmes(generoFilme);

        double layoutX = 50;
        double layoutY = 100;

        int i = 0;
        for (Filme filme: arrayFilme) {
            
            setupWebview(filme, layoutX, layoutY);
            setupButtons(filme, layoutX, layoutY);
            
            if(++i < 2){
                layoutX += 250;
            }else {
                layoutY += 400;
                layoutX = 50;
            }
        }
        this.telaCatalogo.setLayoutY(100);
        this.anchorCatalogo.getChildren().add(this.telaCatalogo);
    }
    public void toDrama(){ showCatalogo(DRAMA); }
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
