package br.ip2.project.view.home;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import br.ip2.project.view.Main;
import br.ip2.project.view.Scenes;
public class Controller {

    public Pane action;
    public Pane adventure;
    public Pane drama;
    public Pane funny;
    public Pane family;
    public Pane nacional;
    public Image image;
    public VBox vbox;

    public Controller() {

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load("https://www.imdb.com/");
        this.vbox = new VBox();
        this.vbox.getChildren().addAll(webView);
        this.vbox.setVisible(true);
    }


    public void toPerfil(ActionEvent actionEvent) {
        Main.changeScreen(Scenes.Perfil);
    }
}
