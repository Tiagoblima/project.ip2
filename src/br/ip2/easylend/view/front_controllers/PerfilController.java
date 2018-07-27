package br.ip2.easylend.view.front_controllers;

import br.ip2.easylend.controller.ClienteController;
import br.ip2.easylend.view.Main;
import br.ip2.easylend.view.Scenes;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.ip2.easylend.model.*;
import javafx.stage.Stage;

public class PerfilController implements Initializable {


    @FXML
    public Label lblNomeUsuario;

    @FXML
    public Label lblFilmes;

    @FXML
    public Label lblCreditos;

    @FXML
    public Label lblMsg;

    @FXML
    public Button btnMaisPerfil;

    @FXML
    public Label lblErro;
    @FXML
    public ImageView profile_img;
    @FXML
    public AnchorPane anchorPerfil;

    @FXML
    public  Label lblTipoCliente;

    @FXML
    public Button btnAlterarLogin;

    @FXML
    public Button btnAddFIlme;

    @FXML
    public Button btnMudarTipoCliente;

    @FXML
    public Button btnCompCredito;



    @Override
    public void initialize(URL location, ResourceBundle resources) {


        MenuBar menuBar = null;
        try {
            menuBar = FXMLLoader.load(getClass().getResource("../fxml/menu.fxml"));
            menuBar.setPrefWidth(800);
            anchorPerfil.getChildren().add(menuBar);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Cliente cliente = ClienteController.getInstance().getCliente();

        lblNomeUsuario.setText(cliente.getLogin());
        lblCreditos.setText(String.valueOf(cliente.getCredito()));
        lblFilmes.setText(String.valueOf(cliente.getQtdFilmes()));
        lblTipoCliente.setText(cliente.getTipoCliente());
        String msg = null;

    }


    private void criarStage(String msg){

        Stage stage = new Stage();
        AnchorPane pnMsg = new AnchorPane();

        pnMsg.setPrefWidth(100);
        pnMsg.setPrefHeight(50);



        Label label = new Label(msg);

        label.setLayoutX(0);
        label.setLayoutY(0);
        pnMsg.getChildren().add(label);

        Button btnOk = new Button("OK");
        btnOk.setOnAction(event -> stage.close());
        btnOk.setLayoutX(90);
        btnOk.setLayoutY(50);
        pnMsg.getChildren().add(btnOk);
        stage.setScene(new Scene(pnMsg));

        stage.show();

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
        String msg = null;
        if(tipoCliente.equals("Premium")) {
            msg = "Você deixou o plano premium";
        }else{
            msg = "Agora você é premium";
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



    public void altrarLogin(ActionEvent actionEvent) {
        alterarLogin();
    }

    public void addFilme(ActionEvent actionEvent) {
        Main.changeScreen(Scenes.Galeria);
    }

    public void compCredito(ActionEvent actionEvent) {
    }

    public void mudarTipo(ActionEvent actionEvent) {
        alterarTipoUsuario();
    }
}

