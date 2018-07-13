package br.ip2.project.view.index;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class IndexController {

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passField;

    @FXML
    private Button btnEntrar;

    @FXML
    private Button btnCadastro;

    @FXML
    private ImageView ImageView;

    @FXML
    private Label lblMsg;

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

public class Controller implements Initializable {

    @FXML
    public Circle circle;


    public Label tipoCliente;
    public Label lblFilmes;
    public Label lblNomeUsuario;
    public Label lblCreditos;
    public Button btnMaisPerfil;
    public Label lblMsg;
    private ClienteController cc;
    private HashMap<String, Cliente>  cHashMap;
    private Cliente cliente;


    public Controller(String login){
        this.cc = new ClienteController();
        this.cHashMap =   this.cc.getCCHashMap();
       this.cliente = this.cHashMap.get(login);
       }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.lblNomeUsuario.setText(this.cliente.getLogin());
        this.lblFilmes.setText(String.valueOf(this.cliente.getQtdFilmes()));
        this.lblCreditos.setText(String.valueOf(this.cliente.getCredito()));

        if(this.cliente.getTipoCliente().equals("Comum")){
            this.lblMsg.setText("Você ainda não é Premium");
        }else{
            this.lblMsg.setText("Você já é Premium");
        }
    }
}
*/