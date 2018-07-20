package br.ip2.project.view.front_controllers;


import br.ip2.project.view.Scenes;
import javafx.event.ActionEvent;
import br.ip2.project.view.*;
public class MenuController {


    public void toHome(ActionEvent actionEvent) { Main.changeScreen(Scenes.Home); }
    public void toPerfil(ActionEvent actionEvent) {
        Main.changeScreen(Scenes.Perfil);
    }
    public void toGaleria(ActionEvent actionEvent){ Main.changeScreen(Scenes.Galeria);}
    public void sair(ActionEvent actionEvent) {
        System.exit(0);
    }

}
