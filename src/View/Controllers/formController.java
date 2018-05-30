package View.Controllers;

import Controller.ClienteComumController;
import Model.ClienteComum;
import Model.Interface.Cliente;
import View.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import static View.Scenes.Index;
import java.util.Date;

public class formController {

    public TextField nomeField;
    public TextField emailField;
    public TextField loginField;
    public TextField passwordField;
    public PasswordField confPasswordField;
    public RadioButton rbtPremium;
    public DatePicker DatePick;
    public Label erroLabel;
    public CheckBox agree;
    public Cliente cliente;
    public ClienteComumController controllerClienteComum = new ClienteComumController();


    public void setCliente(){

        String[] info = new String[5];

        info[0] = nomeField.getText();
        info[1] =  emailField.getText();
        info[2] = loginField.getText();
        info[3] = passwordField.getText();
        info[4] = confPasswordField.getText();
        Date date = (Date) DatePick.getUserData();


        if(info[3]!=info[4]){
            erroLabel.setText("As senha digitadas não conferem");
        }

        for (String el:info) {
            if((el == null) || (date == null)){
                erroLabel.setText("Erro: Falta informações");
            }
        }
        cliente = new ClienteComum(info[0],info[1],date,info[2],info[3],0,0);
    }


    public void ConfirmaCliente(ActionEvent actionEvent) {

        setCliente();
        Date date = (Date) DatePick.getUserData();
        if (!rbtPremium.isSelected())
            if (this.agree.isSelected()) {

                controllerClienteComum.setCliente(this.cliente);
                boolean cadastro = controllerClienteComum.cadastrarCliente();
                if (cadastro) {
                    erroLabel.setText("Cliente já cadastrado");
                }
                erroLabel.setText("Cliente cadastrado com sucesso");
            }



    }

    public void toIndex(ActionEvent actionEvent) { Main.changeScreen(Index); }
}
