package main.java.br.ip2.project.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
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

        AnchorPane index = FXMLLoader.load(getClass().getResource("fxml/index.fxml"));
        Index = new Scene(index);

       Parent home = FXMLLoader.load(getClass().getResource("fxml/home.fxml"));
        Home = new Scene(home,630,450);

        Parent form = FXMLLoader.load(getClass().getResource("fxml/form.fxml"));
        Form = new Scene(form,600,450);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/perfil.fxml"));


        Parent perfil = loader.load();
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
