package br.ip2.easylend.view.front_controllers;


import br.ip2.easylend.view.Main;
import br.ip2.easylend.view.Scenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MenuController {


    public void toHome(ActionEvent actionEvent) { Main.changeScreen(Scenes.Home); }
    public void toPerfil(ActionEvent actionEvent) {

        BorderPane perfil = null;
        try {
            perfil = FXMLLoader.load(getClass().getResource("../fxml/perfil.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene Perfil = new Scene(perfil);
        Main.stage.setScene(Perfil);
    }
    public void toGaleria(ActionEvent actionEvent){ Main.changeScreen(Scenes.Galeria);}
    public void sair(ActionEvent actionEvent) {
        System.exit(0);
    }

}
