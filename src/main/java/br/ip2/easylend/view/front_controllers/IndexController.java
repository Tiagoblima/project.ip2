package br.ip2.easylend.view.front_controllers;


import br.ip2.easylend.controller.ClienteController;
import br.ip2.easylend.model.Cliente;
import br.ip2.easylend.view.Main;
import br.ip2.easylend.view.Scenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class IndexController {

    @FXML
    public TextField loginField;
    @FXML
    public PasswordField passField;
    @FXML
    public javafx.scene.image.ImageView ImageView;
    @FXML
    public Label lblMsg;


    private Cliente cliente;
    public  Image image;

    public IndexController(){


    }

    private void criarStage(String msg){

        exceptionMsg(msg);

    }

    static void exceptionMsg(String msg) {
        Stage stage = new Stage();
        AnchorPane pnMsg = new AnchorPane();

        pnMsg.setPrefWidth(100);
        pnMsg.setPrefHeight(50);


        Label label = new Label(msg);

        label.setLayoutX(0);
        label.setLayoutY(0);
        pnMsg.getChildren().add(label);

        Button btnOk = new Button("OK");
        btnOk.setOnAction(event -> stage.close());
        btnOk.setLayoutX(90);
        btnOk.setLayoutY(50);
        pnMsg.getChildren().add(btnOk);
        stage.setScene(new Scene(pnMsg));

        stage.show();
    }

    public void toLogin(ActionEvent actionEvent) {


        String msg;

        boolean acess = true;

        String login = loginField.getText();
        String senha = passField.getText();

        if(login.isEmpty() || senha.isEmpty()){
            msg = "Um ou mais campos\n não estão preenchidos";
            acess = false;
            criarStage(msg);
        }else{

            ClienteController clienteController =  ClienteController.getInstance();
            try{

             clienteController.login(login, senha);

            }catch (Exception e){
                System.out.println(senha);
                msg = "Login ou senha incorretos";
                acess = false;
                criarStage(msg);
            }
        }

        if(acess){

            toHome(actionEvent);
        }


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
