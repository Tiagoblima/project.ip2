package Interface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


        public static Stage stage;
        private static Scene Index;
        private static Scene Form;

    @Override
    public void start(Stage primaryStage) throws Exception{

        stage = primaryStage;

        Parent index = FXMLLoader.load(getClass().getResource("View/Index.fxml"));
        Index = new Scene(index,600,450);


        Parent form = FXMLLoader.load(getClass().getResource("View/Form.fxml"));
        Form = new Scene(form,600,450);
        primaryStage.setTitle("EasyFilms");

        primaryStage.setScene(Index);
        primaryStage.show();

    }

    public  static void changeScreen(int i){

        switch (i){
            case 1:
                stage.setScene(Index);
                break;
            case 2:
                stage.setScene(Form);
                break;
        }

    }



    public static void main(String[] args) {
        launch(args);

    }
}
