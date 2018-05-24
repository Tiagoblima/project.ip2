package Interface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.text.Normalizer;


public class Main extends Application {


        public static Stage stage;
        private static Scene Index;
        private static Scene Form;

       public enum scenes{
            Index,
            Form,
        }
    @Override
    public void start(Stage primaryStage) throws Exception{



        stage = primaryStage;

        Parent index = FXMLLoader.load(getClass().getResource("Index.fxml"));
        Index = new Scene(index,600,450);

        Index.getStylesheets().add("@background.css");

        Parent form = FXMLLoader.load(getClass().getResource("Form.fxml"));
        Form = new Scene(form,600,450);
        primaryStage.setTitle("EasyFilms");

        primaryStage.setScene(Index);
        primaryStage.show();

    }

    public  static void changeScreen(scenes name){

        switch (name){
            case Index:
                stage.setScene(Index);
                break;
            case Form:
                stage.setScene(Form);
                break;
        }

    }



    public static void main(String[] args) {
        launch(args);

    }
}
