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
    public Button btnEntrar;
    public TextField passField;
    public javafx.scene.image.ImageView ImageView;
    public Label lblMsg;
    public ClienteComumController controllerCliente = new ClienteComumController();


    public  Image image;


    public indexController() {
        image = new Image(indexController.class.getResourceAsStream("img/action.pane.index.jpg"));
    }

    public void toLogin(ActionEvent actionEvent) {


        String msg = "Acesso liberado";


        String login = loginField.getText();
        String senha = passField.getText();

        if(login.isEmpty() || senha.isEmpty()){
            msg = "Um ou mais campos\n não estão preenchidos";
        }else{
            try{

                controllerCliente.login(login, senha);
            }catch (Exception e){
                msg = "Login ou senha incorretos";
            }
        }



        lblMsg.setText(msg);
    }

    public void toForm(ActionEvent actionEvent) {

        Main.changeScreen(Form);
    }


    public void changeImg(MouseEvent mouseEvent) {

        ImageView.setImage(this.image);
        ImageView.setVisible(true);
    }
}
