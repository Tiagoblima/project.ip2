package br.ip2.easylend.view.front_controllers;

import br.ip2.easylend.controller.CatalogoController;
import br.ip2.easylend.controller.ClienteController;
import br.ip2.easylend.model.Cliente;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PerfilController implements Initializable {


    @FXML
    public Label lblNome;

    @FXML
    public Label lblCreditos;

    @FXML
    public  Label lblTipoCliente;

    @FXML
    public Button btnMudarLogin;

    @FXML
    public Button btnMais;

    @FXML
    public Button btnMudarPlano;

    @FXML
    public Button btnCompra;

    @FXML
    public BorderPane pnMain;

    @FXML
    public Label lblEmail;

    @FXML
    public Pane pnAvatar;

    @FXML
    public AnchorPane pnClienteFilmes;

    public Button btnDetalhes;

    private Pane telaFilmes;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        MenuBar menuBar = null;
        try {
            menuBar = FXMLLoader.load(getClass().getResource("../fxml/menu.fxml"));
            menuBar.setPrefWidth(800);
            pnMain.setTop(menuBar);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Cliente cliente = ClienteController.getInstance().getCliente();

        lblNome.setText(cliente.getNome());
        lblCreditos.setText(String.valueOf(cliente.getCredito()));
        lblTipoCliente.setText(cliente.getTipoCliente());
        lblEmail.setText(cliente.getEmail());

        showCatalogo();

    }

    private void setupButtons(Filme filme, double layoutX, double layoutY){

        ButtonBar buttonBar = new ButtonBar();


        Button btnAssistir = new Button();

        btnAssistir.setText("Assistir");
        btnAssistir.setId(String.valueOf(filme.hashCode()));
        btnAssistir.setAlignment(Pos.CENTER);

        Stage assistir = new Stage();

        btnAssistir.setOnAction(event -> {

            WebView webView = new WebView();
            WebEngine webEngine = webView.getEngine();



            webView.setPrefWidth(1382.0);
            webView.setPrefHeight(784.0);
            webEngine.loadContent(filme.getUrlFilme());


            assistir.setScene(new Scene(webView));

            assistir.setFullScreen(true);
            assistir.show();


        });

        assistir.setOnCloseRequest(event1 -> {
            assistir.close();
            Platform.exit();
        });

        btnAssistir.setAlignment(Pos.BASELINE_CENTER);

        buttonBar.getButtons().add(btnAssistir);

        buttonBar.setLayoutX(layoutX);
        buttonBar.setLayoutY(layoutY + 150);

        buttonBar.toFront();
        this.telaFilmes.getChildren().add(buttonBar);

    }

    private void setupWebview(Filme filme, double layoutX, double layoutY){


        HomeController.stageCreator(filme , layoutX , layoutY , this.telaFilmes);

    }

    private void showCatalogo(){


        this.pnClienteFilmes.getChildren().remove(this.telaFilmes);
        this.telaFilmes = new Pane();

       ClienteController  clienteController = ClienteController.getInstance();
        ArrayList<Filme> arrayFilme = clienteController.getFilmesClienteArray();


        double layoutX = 100;
        double layoutY = 50;

        int i = 0;

        for (Filme filme: arrayFilme) {

            setupWebview(filme, layoutX, layoutY);
            setupButtons(filme,layoutX,layoutY);
            if(++i < 3){
                layoutX += 150;
            }else {
                layoutY += 250;
                layoutX = 50;
            }

        }
        this.telaFilmes.setLayoutY(0);
        this.pnClienteFilmes.getChildren().add(this.telaFilmes);

    }
    private void criarStage(String msg){

        IndexController.exceptionMsg(msg);

    }
    private void login(String newLogin){

        String msg = null;
        try {
            ClienteController.getInstance().alterarLogin(newLogin);

            msg = "Login alterado com sucesso";
        } catch (Exception e) {
          msg = "O login não está disponível\nnDigite um novo login";
        }

        criarStage(msg);

    }
    private void confirmaNovoTipo(){
        String tipoCliente = ClienteController.getInstance().getCliente().getTipoCliente();
        String msg;
        if(tipoCliente.equals("Premium")) {
            msg = "Você deixou o plano premium";
            lblTipoCliente.setText("Comum");
        }else{
            msg = "Agora você é premium";
            lblTipoCliente.setText("Premium");
        }
        ClienteController.getInstance().getCliente().mudarTipoCliente();

        criarStage(msg);

    }
    private void alterarTipoUsuario(){
        Stage stage = new Stage();

        AnchorPane pnAlterar = new AnchorPane();

        pnAlterar.setPrefWidth(300);
        pnAlterar.setPrefHeight(200);



        Label label = new Label("Confirmar mudança de plano");
        label.setLayoutX(20);
        label.setLayoutY(50);
        pnAlterar.getChildren().add(label);


        ButtonBar btnBar = new ButtonBar();

        btnBar.setLayoutX(50);
        btnBar.setLayoutY(100);
        Button btnCancelar = new Button("Cancelar");
        btnCancelar.setCancelButton(true);

        btnCancelar.setOnAction(event -> stage.close());

        Button btnConfirmar = new Button("Confirmar");

        btnConfirmar.setOnAction(event -> confirmaNovoTipo());
        btnBar.getButtons().add(btnCancelar);
        btnBar.getButtons().add(btnConfirmar);
        pnAlterar.getChildren().add(btnBar);
        Scene scene = new Scene(pnAlterar);
        stage.setScene(scene);


        stage.show();

    }




    private void paypal(){


        criarWebStage("https://www.paypal.com/us/home");


    }
    private void alterarLogin(){

        Stage stage = new Stage();

        AnchorPane pnAlterar = new AnchorPane();

        pnAlterar.setPrefWidth(300);
        pnAlterar.setPrefHeight(200);



        Label label = new Label("Digite aqui: ");
        label.setLayoutX(20);
        label.setLayoutY(50);
        pnAlterar.getChildren().add(label);

        TextField textField = new TextField();

        textField.setLayoutX(100);
        textField.setLayoutY(50);
        pnAlterar.getChildren().add(textField);

        ButtonBar btnBar = new ButtonBar();

        btnBar.setLayoutX(50);
        btnBar.setLayoutY(100);
        Button btnCancelar = new Button("Cancelar");
        btnCancelar.setCancelButton(true);

        btnCancelar.setOnAction(event -> stage.close());

        Button btnConfirmar = new Button("Confirmar");

        btnConfirmar.setOnAction(event -> login(textField.getText()));
        btnBar.getButtons().add(btnCancelar);
        btnBar.getButtons().add(btnConfirmar);
        pnAlterar.getChildren().add(btnBar);
        Scene scene = new Scene(pnAlterar);
        stage.setScene(scene);


        stage.show();
    }


    private void criarWebStage(String url) {
        Stage webStage = new Stage();


        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        engine.load(url);
        webView.setPrefWidth(400);
        webView.setPrefHeight(400);

        webStage.setScene(new Scene(webView));

        webStage.show();

    }

    public void alterarLogin(ActionEvent actionEvent) {
        alterarLogin();
    }

    public void addFilme(ActionEvent actionEvent) {
        Main.changeScreen(Scenes.Galeria);
    }

    public void compCredito(ActionEvent actionEvent) {
        paypal();
    }

    public void mudarTipo(ActionEvent actionEvent) {
        alterarTipoUsuario();
    }

    public void toMais(ActionEvent actionEvent) {


        criarWebStage("http://localhost:8080/Details");
    }
}

