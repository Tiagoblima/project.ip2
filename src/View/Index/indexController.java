package View.Index;

import Controller.ClienteComumController;
import View.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;

import static View.Scenes.*;


public class indexController {

    public TextField loginField;
    public Button btnCadastro;
    public PasswordField passwordField;
    public javafx.scene.image.ImageView ImageView;
    public Label lblMsg;
    public ClienteComumController controllerCliente = new ClienteComumController();


    public  Image image;

    public indexController() {
        image = new Image(indexController.class.getResourceAsStream("img/action.pane.index.jpg"));
    }

    public void toLogin(ActionEvent actionEvent) {



        System.out.println(this.controllerCliente.getCCHashMap().toString());
        String msg = "Acesso liberado";
        String login = loginField.getText();
        String senha = passwordField.getText();

        System.out.println(login);
        System.out.println(senha);
        try{

            controllerCliente.login(login, senha);
        }catch (Exception e){
            msg = "Login ou senha incorretos";
        }

        lblMsg.setText(msg);
    }

    public void cadastrar(ActionEvent actionEvent) {

        Main.changeScreen(Form);
    }


    public void changeImg(MouseEvent mouseEvent) {

        ImageView.setImage(this.image);
        ImageView.setVisible(true);
    }
}
