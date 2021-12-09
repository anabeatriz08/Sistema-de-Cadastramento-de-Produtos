package controler;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.Main;
import java.nio.file.Paths;

public class ControllerLogin {


    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private ImageView imagemLogo, imagemCadeado, imagemInstagram;

    @FXML
    private Label lblErroLogin;

    public void initialize() {
        imagemLogo.setImage(new Image(Paths.get("src/imagens/logo.jpeg").toUri().toString()));
        imagemCadeado.setImage(new Image(Paths.get("src/imagens/cadeado.png").toUri().toString()));
        imagemInstagram.setImage(new Image(Paths.get("src/imagens/imagemInstagram.png").toUri().toString()));
    }

    // ----------MÉTODO - FAZER LOGIN----------
    public void fazerLogin() throws Exception{

        if ((txtUsuario.getText().equals("ana") && txtSenha.getText().equals("123")) ||
                (txtUsuario.getText().equals("gean") && txtSenha.getText().equals("1234"))
        ) {
            System.out.println("Bem vindo ao sistema!");
            Parent root = FXMLLoader.load(getClass().getResource("/telas/menuPrincipal.fxml"));

            Main.stagePrincipal.setTitle("Menu");
            Main.stagePrincipal.setScene(new Scene(root));
        } else {
            lblErroLogin.setText("Usuário ou senha inválida! Tente novamente!");
            lblErroLogin.setVisible(true);
            System.out.println(lblErroLogin.getText());
        }

    }
    // --------MÉTODO BOTÃO CANCELAR---------
    public void cancelar() throws Exception{
        Main.stagePrincipal.close();
    }

}


