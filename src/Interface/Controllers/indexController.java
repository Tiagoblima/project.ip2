package Interface.Controllers;



import Interface.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import sun.reflect.CallerSensitive;

import javax.swing.text.html.ImageView;


public class indexController {

    public TextField loginField;
    public Button btnCadastro;
    public PasswordField passwordField;
    public javafx.scene.image.ImageView ImageView;

    public  Image image;

    public indexController() {
        image = new Image(indexController.class.getResourceAsStream("../CSS/img/action.pane.index.jpg"));
    }

    public void login(ActionEvent actionEvent) {
        String login = loginField.getText();
        String senha = passwordField.getText();
    }

    public void cadastrar(ActionEvent actionEvent) {
            Main.changeScreen(Main.scenes.Form);
    }


    public void changeImg(MouseEvent mouseEvent) {

        ImageView.setImage(this.image);
        ImageView.setVisible(true);
    }
}
