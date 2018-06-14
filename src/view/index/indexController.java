package view.index;

import Controller.ClienteComumController;
import view.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;

import static view.Scenes.*;


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
        image = new Image(indexController.class.getResourceAsStream("img/action.pane.index.jpg"));
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

        Main.changeScreen(Form);
    }

    public void toHome(ActionEvent actionEvent){

        Main.changeScreen(Home);

    }
    public void changeImg(MouseEvent mouseEvent) {

        ImageView.setImage(this.image);
        ImageView.setVisible(true);
    }
}
