package Interface;



import javafx.event.ActionEvent;

import javafx.scene.control.*;


public class indexController {

    public TextField loginField;
    public Button btnsingUp;
    public PasswordField passwordField;
    public Label label;


    public void login(ActionEvent actionEvent) {
        loginField.getText();
    }

    public void cadastrar(ActionEvent actionEvent) {
            Main.changeScreen(Main.scenes.Form);
    }


}
