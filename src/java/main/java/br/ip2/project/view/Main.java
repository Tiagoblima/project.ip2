package main.java.br.ip2.project.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.java.br.ip2.project.model.*;
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

         final Cliente cliente;

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

        primaryStage.setScene(Galeria);
        primaryStage.setMaximized(true);
        primaryStage.show();

        System.out.println("Width: " + primaryStage.getWidth());
        System.out.println("Height: " + primaryStage.getHeight());
    }



    public static void filmes(){



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
