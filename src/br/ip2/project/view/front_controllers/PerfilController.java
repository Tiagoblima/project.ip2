package br.ip2.project.view.front_controllers;

import br.ip2.project.controller.ClienteController;
import br.ip2.project.repositorio.Repositorio;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.ip2.project.model.*;
import br.ip2.project.view.*;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        MenuBar menuBar = null;
        try {
            menuBar = FXMLLoader.load(getClass().getResource("../fxml/menu.fxml"));
            anchorPerfil.getChildren().add(menuBar);
        } catch (IOException e) {
            e.printStackTrace();
        }



        String msg = null;

        ClienteController clienteController = ClienteController.getInstance();
        Cliente cliente = clienteController.getCliente();

        try {
        this.lblNomeUsuario.setText(cliente.getLogin());
        this.lblFilmes.setText(String.valueOf(cliente.getQtdFilmes()));
        this.lblCreditos.setText(String.valueOf(cliente.getCredito()));

        if(cliente.getTipoCliente().equals("Comum")){
            this.lblMsg.setText("Você ainda não é Premium");
        }else{
            this.lblMsg.setText("Você já é Premium");
        }
    }catch ( Exception e){
       msg = "Desculpe\nNão conseguimos mostrar seu perfil";
    }

    lblErro.setText(msg);
    }

    public void toHome(ActionEvent actionEvent) { Main.changeScreen(Scenes.Home); }

    public void sair(ActionEvent actionEvent) {
        System.exit(0);
    }
}

