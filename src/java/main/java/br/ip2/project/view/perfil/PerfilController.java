package main.java.br.ip2.project.view.perfil;

import main.java.br.ip2.project.controller.ClienteController;
import main.java.br.ip2.project.model.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.java.br.ip2.project.controller.ClienteController;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

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
    public Button btnCadastro;

    @FXML
    public ImageView ImageView;

    @FXML
    public Button btnMaisPerfil;

    public Label tipoCliente;


    private ClienteController cc;
    private HashMap<String, Cliente> cHashMap;
    private Cliente cliente;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.cc = new ClienteController();
        this.cHashMap =   this.cc.getCCHashMap();
        this.cliente = this.cHashMap.get("tiago");

        this.lblNomeUsuario.setText(this.cliente.getLogin());
        this.lblFilmes.setText(String.valueOf(this.cliente.getQtdFilmes()));
        this.lblCreditos.setText(String.valueOf(this.cliente.getCredito()));

        if(this.cliente.getTipoCliente().equals("Comum")){
            this.lblMsg.setText("Você ainda não é Premium");
        }else{
            this.lblMsg.setText("Você já é Premium");
        }
    }

    @FXML
    void changeImg(MouseEvent event) {

    }

    @FXML
    void toForm(ActionEvent event) {

    }

    @FXML
    void toLogin(ActionEvent event) {

    }


}



/*package br.ip2.project.view.perfil;

import br.ip2.ClienteController;
import br.ip2.Cliente;
import br.ip2.ClienteComum;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class IndexController implements Initializable {

    @FXML
    public Circle circle;






    public IndexController(String login){

       }


}
*/