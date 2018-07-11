package br.ip2.project.view.form;

import br.ip2.project.controller.ClienteController;
import br.ip2.project.model.Cliente;
import br.ip2.project.model.ClienteComum;
import br.ip2.project.model.ClientePremium;
import br.ip2.project.view.Main;
import br.ip2.project.view.Scenes;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class Controller {

    public TextField nomeField;
    public TextField emailField;
    public TextField loginField;
    public TextField passwordField;
    public PasswordField confPasswordField;
    public RadioButton rbtPremium;
    public DatePicker DatePick;
    public CheckBox agree;
    public Label lblMsg;

    private Cliente cliente;

    private ClienteController clienteController = new ClienteController();



    public void ConfirmaCliente(ActionEvent actionEvent) {

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

                     this.cliente = new ClienteComum(nome,email,dataAniv,login,senha,0,0);

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

                     this.cliente = new ClientePremium(nome,email,dataAniv,login,senha,0,0);


                 }catch (Exception e){
                     msg = "Uma ou mais informações estão ausentes.";
                     exception = false;
                 }


                 try{

                     this.clienteController.cadastrarCliente(this.cliente);

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
