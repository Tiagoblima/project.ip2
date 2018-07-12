package br.ip2.project.view.home;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import br.ip2.project.view.Main;
import br.ip2.project.view.Scenes;
import javax.swing.text.Document;
import org.w3c.dom.*;
import com.sun.org.apache.xerces.internal.dom.DocumentImpl;

import java.io.IOException;

public class Controller {


    public AnchorPane feedNoticias;

    public Controller() {




    }


    public void toPerfil(ActionEvent actionEvent) {
        Main.changeScreen(Scenes.Perfil);
    }
}
