package br.ip2.easylend.view.front_controllers;


import br.ip2.easylend.controller.ClienteController;
import br.ip2.easylend.view.Main;
import br.ip2.easylend.view.Scenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuController {


    public void toHome(ActionEvent actionEvent) { Main.changeScreen(Scenes.Home); }
    public void toPerfil(ActionEvent actionEvent) {

        BorderPane perfil;

        try{
            perfil = FXMLLoader.load(getClass().getResource("/fxml/perfil.fxml"));
            Main.stage.setScene(new Scene(perfil));
        }catch (Exception e){

            Label label = new Label("O perfil não pode ser carregado\nTente Mais Tarde");
            Stage stage = new Stage();
            stage.setScene(new Scene(label));
            stage.show();
            e.printStackTrace();
        }

    }
    public void toGaleria(ActionEvent actionEvent){ Main.changeScreen(Scenes.Galeria);}
    public void sair(ActionEvent actionEvent) {
        ClienteController controller = ClienteController.getInstance();
        controller.updateCliente();
        System.exit(0);
    }

}
