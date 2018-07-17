package main.java.br.ip2.project.view.front_controllers;

import javafx.event.ActionEvent;
import main.java.br.ip2.project.view.Main;
import main.java.br.ip2.project.view.Scenes;

public class MenuController {


    public void toHome(ActionEvent actionEvent) {
        Main.changeScreen(Scenes.Home);
    }
    public void toPerfil(ActionEvent actionEvent) {
        Main.changeScreen(Scenes.Perfil);
    }
    public void sair(ActionEvent actionEvent) {
        System.exit(0);
    }

}
