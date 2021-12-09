package controler;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.Main;
import moduls.Produto;

public class ControllerCadastro {

    @FXML
    public TextField txtDescricao, txtVarejo, txtAtacado, txtEstoque;

    @FXML
    public Label lblTitulo;

    @FXML
    public Button btnCadastrar;

    public boolean telaAtualizar = false;
    public int posicaoArray;

    public void salvar() throws Exception{

        //SALVAR
        if (!telaAtualizar) {
            // ::: OBJETO PRODUTO :::
            Produto produto = new Produto();

            // ::: OBTENDO AS INFORMAÇÕES QUE O USUARIO DIGITOU PARA O OBJETO PRODUTO :::
            produto.setDescricao(txtDescricao.getText());
            produto.setValorVarejo(Double.parseDouble(txtVarejo.getText()));
            produto.setValorAtacado(Double.parseDouble(txtAtacado.getText()));
            produto.setEstoque(Double.parseDouble(txtEstoque.getText()));

            // ::: GRAVANDO O PRODUTO NA LISTA :::
            Main.produtos.add(produto);

            // ::: LIMPANDO OS CAMPOS DA TELA :::
            txtDescricao.setText("");
            txtAtacado.setText("");
            txtVarejo.setText("");
            txtEstoque.setText("");

            // ::: COLOCA O PONTEIRO NO CAMPO DE DESCRIÇÃO
            txtDescricao.requestFocus();
        } else { //ATUALIZAR REGISTRO SELECIONADO
            Main.produtos.get(posicaoArray).setDescricao(txtDescricao.getText());
            Main.produtos.get(posicaoArray).setValorVarejo(Double.parseDouble(txtVarejo.getText()));
            Main.produtos.get(posicaoArray).setValorAtacado(Double.parseDouble(txtAtacado.getText()));
            Main.produtos.get(posicaoArray).setEstoque(Double.parseDouble(txtEstoque.getText()));

            Parent root = FXMLLoader.load(getClass().getResource("/telas/listar.fxml"));

            Main.stagePrincipal.setScene(new Scene(root));
        }

        // ::: EXIBIR A LISTA DE PRODUTOS NO CONSOLE :::
        System.out.println(Main.produtos.toString());

    }

    public void voltarMenu() throws Exception{
        Parent root;
        if (!telaAtualizar) {
            root = FXMLLoader.load(getClass().getResource("/telas/menuPrincipal.fxml"));
        } else {
            root = FXMLLoader.load(getClass().getResource("/telas/listar.fxml"));
        }
        Main.stagePrincipal.setScene(new Scene(root));
    }

    //------------Código para abrir uma nova tela separada-----------
    //Stage s = new Stage();
    //s.initOwner(Main.mainsStage);
    //s.setScene( new Scene(root));
    //s.setTitle("Menu");
    //s.show();


}
