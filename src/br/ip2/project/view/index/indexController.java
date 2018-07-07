package br.ip2.project.view.index;

import br.ip2.project.controller.ClienteComumController;
import br.ip2.project.view.Main;
import br.ip2.project.view.Scenes;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;


public class indexController {

    public TextField loginField;
    public Button btnCadastro;
    public Button btnEntrar;
    public PasswordField passField;
    public javafx.scene.image.ImageView ImageView;
    public Label lblMsg;
    public ClienteComumController controllerCliente = new ClienteComumController();


    public  Image image;


    public indexController() {
        image = new Image(indexController.class.getResourceAsStream("../img/action.pane.index.jpg"));
    }

    public void toLogin(ActionEvent actionEvent) {


        String msg = "Acesso liberado";

        boolean acess = true;

        String login = loginField.getText();
        String senha = passField.getText();

        if(login.isEmpty() || senha.isEmpty()){
            msg = "Um ou mais campos\n não estão preenchidos";
            acess = false;
        }else{
            try{

                controllerCliente.login(login, senha);
            }catch (Exception e){
                msg = "Login ou senha incorretos";
                acess = false;
            }
        }

        if(acess){
            toHome(actionEvent);
        }

        lblMsg.setText(msg);
    }

    public void toForm(ActionEvent actionEvent) {

        Main.changeScreen(Scenes.Form);
    }

    public void toHome(ActionEvent actionEvent){

        Main.changeScreen(Scenes.Home);

    }
    public void changeImg(MouseEvent mouseEvent) {

        ImageView.setImage(this.image);
        ImageView.setVisible(true);
    }
}
