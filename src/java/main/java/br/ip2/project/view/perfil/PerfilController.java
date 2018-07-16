package main.java.br.ip2.project.view.perfil;

import javafx.scene.image.Image;
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
import main.java.br.ip2.project.repositorio.Repositorio;
import main.java.br.ip2.project.view.Main;
import main.java.br.ip2.project.view.Scenes;

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
    public Button btnMaisPerfil;

    @FXML
    public Label lblErro;
    @FXML
    public ImageView profile_img;

    private Cliente cliente;

    @Override
    public void initialize(URL location, ResourceBundle resources) {




        String msg = null;
        Repositorio<Cliente> bufCliente = new Repositorio<>();
        try{
            this.cliente = bufCliente.ler("src\\java\\main\\java\\br\\ip2\\project\\repositorio\\files\\Bufcliente.txt");
        }catch (Exception e){
           msg = "Desculpe\nNão conseguimos carregar seu perfil";
        }

    try {
        this.lblNomeUsuario.setText(this.cliente.getLogin());
        this.lblFilmes.setText(String.valueOf(this.cliente.getQtdFilmes()));
        this.lblCreditos.setText(String.valueOf(this.cliente.getCredito()));

        if(this.cliente.getTipoCliente().equals("Comum")){
            this.lblMsg.setText("Você ainda não é Premium");
        }else{
            this.lblMsg.setText("Você já é Premium");
        }
    }catch ( Exception e){
       msg = "Desculpe\nNão conseguimos mostrar seu perfil";
    }

    lblErro.setText(msg);
    }

    public void toHome(ActionEvent actionEvent) {
        Main.changeScreen(Scenes.Home);
    }

    public void sair(ActionEvent actionEvent) {
        System.exit(0);
    }
}

