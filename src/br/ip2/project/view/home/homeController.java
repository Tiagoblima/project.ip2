package br.ip2.project.view.home;

import br.ip2.project.view.index.indexController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.awt.event.MouseEvent;

public class homeController {

    public AnchorPane archo;
    public Pane action;
    public Pane adventure;
    public Pane drama;
    public Pane funny;
    public Pane family;
    public Pane nacional;
    public Image image;
    public homeController() {
    }

    public void Webview(MouseEvent mouseEvent){

       WebView webView = new WebView();

        WebEngine webEngine = webView.getEngine();

        webEngine.load("https://www.imdb.com/");
        archo.getChildren().addAll(webView);

    //    webView.getChildrenUnmodifiable().addAll(webView);


    }


}
