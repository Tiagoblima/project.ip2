package br.ip2.project.view.form;

import br.ip2.project.controller.ClienteComumController;
import br.ip2.project.controller.ClientePremiumController;
import br.ip2.project.model.ClienteComum;
import br.ip2.project.model.ClientePremium;
import br.ip2.project.view.Main;
import br.ip2.project.view.Scenes;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class formController {

    public TextField nomeField;
    public TextField emailField;
    public TextField loginField;
    public TextField passwordField;
    public PasswordField confPasswordField;
    public RadioButton rbtPremium;
    public DatePicker DatePick;
    public CheckBox agree;
    public Label lblMsg;

    private ClienteComum clienteComum;
    private ClientePremium clientePremium;
    private ClientePremiumController clientePremiumController;
    private ClienteComumController controllerClienteComum = new ClienteComumController();



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

                     this.clienteComum = new ClienteComum(nome,email,dataAniv,login,senha,0,0);
                     controllerClienteComum.setCliente(this.clienteComum);

                 }catch (Exception e){
                     msg = "Uma ou mais informações estão ausentes.";
                     exception = false;
                 }


                 try{

                     controllerClienteComum.cadastrarCliente();

                     System.out.println(controllerClienteComum.getCCHashMap().toString());
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

                     this.clienteComum = new ClienteComum(nome,email,dataAniv,login,senha,0,0);
                     this.controllerClienteComum.setCliente(this.clienteComum);

                 }catch (Exception e){
                     msg = "Uma ou mais informações estão ausentes.";
                     exception = false;
                 }


                 try{

                     this.controllerClienteComum.cadastrarCliente();

                     System.out.println(controllerClienteComum.getCCHashMap().toString());
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
