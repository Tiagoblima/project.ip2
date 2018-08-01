package br.ip2.easylend.view;

import br.ip2.easylend.controller.ClienteController;
import br.ip2.easylend.view.front_controllers.FilmeDataBase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {



        public static Stage stage;
        public static Stage popUp;

        private static Scene Index;
        private static Scene Form;
        private static Scene Home;
        private static Scene Perfil;
        private static Scene Galeria;



    @Override
    public void start(Stage primaryStage) throws Exception{

        stage = primaryStage;

        AnchorPane index = FXMLLoader.load(getClass().getResource("fxml/index.fxml"));
        Index = new Scene(index);

        AnchorPane home = FXMLLoader.load(getClass().getResource("fxml/home.fxml"));
        Home = new Scene(home);

        AnchorPane form = FXMLLoader.load(getClass().getResource("fxml/form.fxml"));
        Form = new Scene(form);


        BorderPane galeria = FXMLLoader.load(getClass().getResource("fxml/galeria.fxml"));
        Galeria = new Scene(galeria);

        primaryStage.setTitle("EasyFilms");

        primaryStage.setScene(Index);
        primaryStage.show();

        System.out.println("Width: " + primaryStage.getWidth());
        System.out.println("Height: " + primaryStage.getHeight());



        String[] args = new String[]{"application"};
        br.ip2.easylend.view.front_controllers.Application.Main(args);

        stage.setResizable(false);

    }


    public  static void changeScreen(Scenes name){



        stage.setHeight(600);
        stage.setWidth(800);
        switch (name){
            case Index:
                stage.setHeight(400);
                stage.setWidth(600);
                stage.setScene(Index);
                break;
            case Form:
                stage.setHeight(400);
                stage.setWidth(600);
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

    }



    public static void main(String[] args) {
        launch(args);

    }
}
