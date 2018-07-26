package br.ip2.easylend.view.front_controllers;

import br.ip2.easylend.controller.ClienteController;
import br.ip2.easylend.repositorio.Repositorio;
import javafx.application.Platform;
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

import br.ip2.easylend.model.*;
import br.ip2.easylend.view.*;

import static br.ip2.easylend.controller.ClienteController.cliente;
import static br.ip2.easylend.controller.ClienteController.getInstance;

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


    public void toHome(ActionEvent actionEvent) { Main.changeScreen(Scenes.Home); }

    public void sair(ActionEvent actionEvent) {
        System.exit(0);
    }
}

