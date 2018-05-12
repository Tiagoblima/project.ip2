package Interface;


import javafx.event.ActionEvent;
import javafx.scene.control.*;
public class Controller extends Dados {

    public TextField loginField;
    public Button btnsingUp;
    public PasswordField passwordField;


    public void login(ActionEvent actionEvent) {
        loginField.getText();
    }

    public void cadastrar(ActionEvent actionEvent) {
    }
}
