package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import moduls.Produto;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public static Stage stagePrincipal;
    public static List<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Main.stagePrincipal = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/telas/login.fxml"));
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 600, 500));
        stage.show();

    }

}