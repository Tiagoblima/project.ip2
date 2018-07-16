package main.java.br.ip2.project.view.form;

import javafx.fxml.FXML;
import main.java.br.ip2.project.controller.*;
import main.java.br.ip2.project.model.*;
import main.java.br.ip2.project.repositorio.Repositorio;
import main.java.br.ip2.project.view.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.File;

public class FormController {

    @FXML
    public TextField nomeField;
    @FXML
    public TextField emailField;
    @FXML
    public TextField loginField;
    @FXML
    public TextField passwordField;
    @FXML
    public PasswordField confPasswordField;
    @FXML
    public RadioButton rbtPremium;
    @FXML
    public DatePicker DatePick;
    @FXML
    public CheckBox agree;
    @FXML
    public Label lblMsg;

    private Cliente cliente;
    private Endereco endereco;


    public void ConfirmaCliente(ActionEvent actionEvent) {


        ClienteController clienteController = new ClienteController();

        String nome = this.nomeField.getText();
        String email = this.emailField.getText();
        String dataAniv = this.DatePick.getEditor().getText();
        String login = this.loginField.getText();
        String senha = this.confPasswordField.getText();

        String msg = null;
        boolean exception = true;

         if(!rbtPremium.isSelected()){

             if (this.agree.isSelected()){

                 try{

                     this.cliente = new ClienteComum(nome,email,dataAniv,login,senha,this.endereco);

                 }catch (Exception e){
                     msg = "Uma ou mais informações estão ausentes.";
                     exception = false;
                 }



                 try{

                     clienteController.cadastrarCliente(this.cliente);

                     System.out.println(clienteController.getCCHashMap().toString());
                     msg = "Cliente cadastrado com sucesso";

                 }catch (Exception e){

                     if (exception){
                         msg = "Cliente já cadastrado";
                     }
                 }

             }else {
                 msg = "Você deve concordar com os nossos termos";
             }

             lblMsg.setText(msg);

        }else{

             if (this.agree.isSelected()){

                 try{

                     this.cliente = new ClientePremium(nome,email,dataAniv,login,senha,this.endereco);


                 }catch (Exception e){
                     msg = "Uma ou mais informações estão ausentes.";
                     exception = false;
                 }


                 try{

                     clienteController.cadastrarCliente(this.cliente);

                     System.out.println(clienteController.getCCHashMap().toString());
                     msg = "Cliente cadastrado com sucesso";


                 }catch (Exception e){

                     if (exception){
                         msg = "Cliente já cadastrado";
                     }
                 }

             }else {
                 msg = "Você deve concordar com os nossos termos";
             }

             lblMsg.setText(msg);
         }




    }

    private void clearFields(){
        this.nomeField.clear();
        this.emailField.clear();
        this.loginField.clear();
        this.passwordField.clear();
        this.confPasswordField.clear();
        this.DatePick.getEditor().clear();
        this.lblMsg.setText("");
        this.agree.setSelected(false);

    }
    public void toIndex(ActionEvent actionEvent) {


        clearFields();
        Main.changeScreen(Scenes.Index);


    }
}
