package main.java.br.ip2.project.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {


        public static Stage stage;
        private static Scene Index;
        private static Scene Form;
        private static Scene Home;
        private static Scene Perfil;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;

        URL teste = getClass().getResource("view/index.fxml");
        String url = "C:\\Users\\famil\\IdeaProjects\\easylend\\src\\main\\java\\br\\ip2\\project\\view\\index\\index.fxml";
        AnchorPane index = FXMLLoader.load(getClass().getResource("index/index.fxml"));
        Index = new Scene(index);

  /*      Parent home = FXMLLoader.load(getClass().getResource("home/home.fxml"));
        Home = new Scene(home,630,450);

        Parent form = FXMLLoader.load(getClass().getResource("form/form.fxml"));
        Form = new Scene(form,600,450);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("perfil/perfil.fxml"));
        Label label = new Label("Meu nome");
        loader.setController(new br.ip2.IndexController("tiago"));

        Parent perfil = loader.load();
        Perfil = new Scene(perfil,600,450);
        */
        primaryStage.setTitle("EasyFilms");

        primaryStage.setScene(Index);
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
