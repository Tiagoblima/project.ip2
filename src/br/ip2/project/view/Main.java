package br.ip2.project.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


        public static Stage stage;
        private static Scene Index;
        private static Scene Form;
        private static Scene Home;
        private static Scene Perfil;

    @Override
    public void start(Stage primaryStage) throws Exception{



        stage = primaryStage;

        Parent index = FXMLLoader.load(getClass().getResource("index/index.fxml"));
        Index = new Scene(index,600,450);

        Parent home = FXMLLoader.load(getClass().getResource("home/home.fxml"));
        Home = new Scene(home,600,450);

        Parent form = FXMLLoader.load(getClass().getResource("form/form.fxml"));
        Form = new Scene(form,600,450);

        Parent perfil = FXMLLoader.load(getClass().getResource("perfil/perfil.fxml"));
        Perfil = new Scene(perfil,600,450);
        primaryStage.setTitle("EasyFilms");

        primaryStage.setScene(Home);
        primaryStage.show();

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
        }

    }




    public static void main(String[] args) {
        launch(args);

    }
}
