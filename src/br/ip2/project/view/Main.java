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

        primaryStage.setScene(Index);
        primaryStage.show();

        System.out.println("Width: " + primaryStage.getWidth());
        System.out.println("Height: " + primaryStage.getHeight());



    }

    private static void filme1(){


        FilmeController controller = FilmeController.getInstance();

        String titulo = "Real - O Plano Por Trás da História";
        String sinopse = "\nBrasília, maio de 1993. Após uma sequência de planos " +
                         "\neconômicos que não surtiram efeito, o país é levado à" +
                         "\nhiperinflação. Uma seleta equipe econômica, protegida" +
                         "\nem um bunker contra pressões políticas, mergulha" +
                          "\nna missão de reformar o Estado e criar o Plano Real.";
        int hora = 1;
        int minuto = 36;
        int lancamento = 2017;



        Filme filme = new Filme(titulo,hora,minuto,lancamento,sinopse,NACIONAIS);

        String urlT = "<iframe width=\"450\" height=\"275\" src=\"https://www.youtube.com/embed/CkdA23R6GYw\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        String urlM = "http://t2.gstatic.com/images?q=tbn:ANd9GcRnHPfS_YmkjpVypNKStikCgDTrZzCY-Z7zmGtmWXuYp3MP0mW4";
        String urlF = "<iframe width=\"1382\" height=\"784\" src=\"https://www.youtube.com/embed/CkdA23R6GYw\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";

        filme.setUrlFilme(urlF);
        filme.setUrlTrailler(urlT);
        filme.setUrlMiniatura(urlM);
        try {
            controller.removerFilme(controller.procurarFilme("Real - O Plano Por Trás da História"));
            controller.cadastrarFilme(filme);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




    private static void filme2(){


        FilmeController controller = FilmeController.getInstance();

        String titulo = "A Estrada 47";
        String sinopse = "Mais de 25 mil soldados da Força Expedicionária Brasileira" +
                         "\nlutaram na Segunda Guerra Mundial. Quase todos de origem" +
                         "\npobre e despreparados para o combate, os pracinhas tiveram" +
                         "\nque aprender a lutar pela sobrevivência. Depois de sofrerem" +
                          "\num ataque de pânico coletivo no sopé do Monte Castelo," +
                          "\nos soldados Guimarães, Tenente, Piauí e Laurindo se perdem" +
                          "\nuns dos outros. Desesperados, com frio, fome e sede, os " +
                          "\npracinhas têm de optar por enfrentar a Corte Marcial ou" +
                           "\nencarar novamente o inimigo.";
        int hora = 1;
        int minuto = 47;
        int lancamento = 2013;



        Filme filme = new Filme(titulo,hora,minuto,lancamento,sinopse,NACIONAIS);

        String urlT = "<iframe width=\"450\" height=\"275\" src=\"https://www.youtube.com/embed/O3m3bCVRWXI\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        String urlM = "http://t2.gstatic.com/images?q=tbn:ANd9GcTU3EqXs8IZAPpY1IlsWF6zPcn7fvHbWQEFJWdDqmK8AU-UQDYz";

        String urlF = "<iframe width=\"1382\" height=\"784\" src=\"https://www.youtube.com/embed/HiJxaJKkzLM\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";

        filme.setUrlFilme(urlF);
        filme.setUrlTrailler(urlT);
        filme.setUrlMiniatura(urlM);
        try {
            controller.removerFilme(controller.procurarFilme("A Estrada 47"));
         //   controller.cadastrarFilme(filme);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private static void filme3(){


        FilmeController controller = FilmeController.getInstance();

        String titulo = "O Candidato Honesto";
        String sinopse = "João Ernesto Praxedes conquistou grande popularidade" +
                         "\ncomo presidente do Sindicato dos Motoristas de Ônibus." +
                          "\nPolítico corrupto, ele se candidata à Presidência da " +
                          "\nRepública. À frente nas pesquisas, no segundo turno das " +
                          "\neleições, ele recebe uma mandinga da avó, fazendo com que " +
                          "\nele não possa mais mentir. Será que ele vai conseguir " +
                          "\nvencer as eleições falando somente a verdade?";
        int hora = 1;
        int minuto = 50;
        int lancamento = 2014;

        Filme filme = new Filme(titulo,hora,minuto,lancamento,sinopse,NACIONAIS);

        String urlT = "<iframe width=\"450\" height=\"275\" src=\"https://www.youtube.com/embed/bndlriD5Gek\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";
        String urlM = "http://br.web.img3.acsta.net/c_215_290/pictures/14/08/14/20/18/325650.jpg";

        String urlF = "<iframe width=\"1382\" height=\"784\" src=\"https://www.youtube.com/embed/bndlriD5Gek\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>";

        filme.setUrlFilme(urlF);
        filme.setUrlTrailler(urlT);
        filme.setUrlMiniatura(urlM);


        try {
            controller.removerFilme(controller.procurarFilme("O Candidato Honesto"));
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
                stage.setMaximized(true);
                stage.setScene(Home);
                break;
            case Perfil:

                stage.setScene(Perfil);
                break;
            case Galeria:
                stage.setMaximized(true);
                stage.setScene(Galeria);
                break;
        }

    }



    public static void main(String[] args) {
        launch(args);

    }
}
