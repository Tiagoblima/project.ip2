package br.ip2.project.view;

import br.ip2.project.controller.FilmeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import br.ip2.project.model.*;
import br.ip2.project.model.GeneroFilme.*;

import static br.ip2.project.model.GeneroFilme.*;

public class Main extends Application {



        private static Stage stage;
        public static Stage popUp;

        private static Scene Index;
        private static Scene Form;
        private static Scene Home;
        private static Scene Perfil;
        private static Scene Galeria;



    @Override
    public void start(Stage primaryStage) throws Exception{

         final Cliente cliente = null;

        stage = primaryStage;

        AnchorPane index = FXMLLoader.load(getClass().getResource("fxml/index.fxml"));
        Index = new Scene(index);

        AnchorPane home = FXMLLoader.load(getClass().getResource("fxml/home.fxml"));
        Home = new Scene(home);

        AnchorPane form = FXMLLoader.load(getClass().getResource("fxml/form.fxml"));
        Form = new Scene(form);

        AnchorPane perfil = FXMLLoader.load(getClass().getResource("fxml/perfil.fxml"));



        Perfil = new Scene(perfil);


        VBox galeria = FXMLLoader.load(getClass().getResource("fxml/galeria.fxml"));
        Galeria = new Scene(galeria);

        primaryStage.setTitle("EasyFilms");

        primaryStage.setScene(Home);
        primaryStage.setMaximized(true);
        primaryStage.show();

        System.out.println("Width: " + primaryStage.getWidth());
        System.out.println("Height: " + primaryStage.getHeight());



    }



    private static void filme1(){


        FilmeController controller = FilmeController.getInstance();

        String titulo = "Cavalo de Guerra";
        String sinopse = "A história da amizade entre Albert e seu cavalo Joey.\n" +
                         "Depois de ser vendido para a cavalaria inglesa durante a\n" +
                         "Primeira Guerra Mundial, o corcel emociona ambos os lados " +
                         "\ncom sua bravura. Albert se alista para recuperar seu amigo e " +
                         "\ntrazer Joey de volta para casa.";
        int hora = 2;
        int minuto = 36;
        int lancamento = 2011;



        Filme filme = new Filme(titulo,hora,minuto,lancamento,sinopse,DRAMA);

        String urlT = "<iframe width=\"450\" height=\"275\" src=\"https://www.youtube.com/embed/CSOjiqy0Q4g\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        String urlM = "https://img.wook.pt/images/cavalo-de-guerra-michael-morpurgo/MXwxMzk5ODUwN3w5NTcyNDUwfDEzODM1MjMyMDAwMDA=/500x";

        String urlF = "<iframe width=\"1382\" height=\"784\" src=\"https://www.youtube.com/embed/CSOjiqy0Q4g\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";

        filme.setUrlFilme(urlF);
        filme.setUrlTrailler(urlT);
        filme.setUrlMiniatura(urlM);
        try {
            controller.cadastrarFilme(filme);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private static void filme2(){


        FilmeController controller = FilmeController.getInstance();

        String titulo = "À Procura da Felicidade";
        String sinopse = "Chris Gardner enfrenta uma vida difícil. " +
                         "\nDespejado de seu apartamento, este pai solteiro" +
                         "\ne seu filho não têm onde morar. Chris consegue um" +
                         "\nestágio não remunerado em uma firma de prestígio." +
                         "\nSem dinheiro, os dois são obrigados a viver em abrigos, " +
                         "\nmas Chris está determinado a criar um vida melhor para" +
                         "\nele e seu filho.";
        int hora = 2;
        int minuto = 25;
        int lancamento = 206;

        Filme filme = new Filme(titulo,hora,minuto,lancamento,sinopse,DRAMA);

        String urlT = "<iframe width=\"450\" height=\"275\" src=\"https://www.youtube.com/embed/00uTFVnWJMw?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        String urlM = "https://upload.wikimedia.org/wikipedia/pt/thumb/1/1e/The_Pursuit_of_Happyness.jpg/200px-The_Pursuit_of_Happyness.jpg";

        String urlF = "<iframe width=\"1382\" height=\"784\" src=\"https://www.youtube.com/embed/00uTFVnWJMw?rel=0\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";

        filme.setUrlFilme(urlF);
        filme.setUrlTrailler(urlT);
        filme.setUrlMiniatura(urlM);
        try {
            controller.cadastrarFilme(filme);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public  static void changeScreen(Scenes name){

        switch (name){
            case Index:
                stage.setScene(Index);
                break;
            case Form:
                stage.setScene(Form);
                break;
            case Home:
                stage.setScene(Home);
                break;
            case Perfil:
                stage.setScene(Perfil);
                break;
            case Galeria:
                stage.setScene(Galeria);
                break;
        }
        stage.setMaximized(true);
    }



    public static void main(String[] args) {
        launch(args);

    }
}
