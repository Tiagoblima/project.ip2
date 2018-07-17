package main.java.br.ip2.project.view.front_controllers;

import main.java.br.ip2.project.controller.ClienteController;
import main.java.br.ip2.project.view.Main;
import main.java.br.ip2.project.view.Scenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;


public class IndexController {

    @FXML
    public TextField loginField;
    @FXML
    public PasswordField passField;
    @FXML
    public javafx.scene.image.ImageView ImageView;
    @FXML
    public Label lblMsg;
    private ClienteController controllerCliente = new ClienteController();


    public  Image image;


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
