package controler;;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.Main;

import java.nio.file.Paths;

public class ControllerMenuPrincipal {

    @FXML
    private ImageView imagemCadastrar, imagemListar, imagemSair;

    public void initialize(){
        imagemCadastrar.setImage(new Image(Paths.get("src/imagens/add.png").toUri().toString()));
        imagemListar.setImage(new Image(Paths.get("src/imagens/listar.png").toUri().toString()));
        imagemSair.setImage(new Image(Paths.get("src/imagens/sair.png").toUri().toString()));
    }

    //-----------Metodos Botões--------------
    public void trocarParaTelaCadastro() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/telas/Cadastro.fxml"));
        Main.stagePrincipal.setTitle("Cadastrar");
        Main.stagePrincipal.setScene(new Scene(root));
    }

    public void trocarParaTelaListar() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/telas/listar.fxml"));
        Main.stagePrincipal.setTitle("Listar");
        Main.stagePrincipal.setScene(new Scene(root));
    }

    public void desconectar() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/telas/login.fxml"));
        Main.stagePrincipal.setTitle("Login");
        Main.stagePrincipal.setScene(new Scene(root));
    }

    public void onMouseOver() {

    }
}
