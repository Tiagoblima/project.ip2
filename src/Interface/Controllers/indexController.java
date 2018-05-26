package Interface.Controllers;



import Interface.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.*;


public class indexController {

    public TextField loginField;
    public Button btnCadastro;
    public PasswordField passwordField;



    public void login(ActionEvent actionEvent) {
        loginField.getText();
    }

    public void cadastrar(ActionEvent actionEvent) {
            Main.changeScreen(Main.scenes.Form);
    }


}
