package br.ip2.easylend.view.front_controllers;


import br.ip2.easylend.controller.ClienteController;
import br.ip2.easylend.model.Cliente;
import br.ip2.easylend.model.ClienteComum;
import br.ip2.easylend.model.ClientePremium;
import br.ip2.easylend.model.Endereco;
import br.ip2.easylend.view.Main;
import br.ip2.easylend.view.Scenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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


        ClienteController clienteController = ClienteController.getInstance();

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
                     msg = "Uma ou mais informações\n estão ausentes.";
                     exception = false;
                 }



                 try{

                     clienteController.cadastrarCliente(this.cliente);


                     msg = "Cliente cadastrado\n com sucesso";

                 }catch (Exception e){

                     if (exception){
                         msg = "Cliente já cadastrado";
                     }
                 }

             }else {
                 msg = "Você deve concordar\n com os nossos termos";
             }

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
