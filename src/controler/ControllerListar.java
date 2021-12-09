package controler;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.Main;
import moduls.Produto;


public class ControllerListar {

    @FXML
    private VBox vBoxTela;

    public void initialize(){

        for (int i = 0; i < Main.produtos.size(); i++) {
            int posicao = i;

            // :::: CRIA A TABELA COM OS REGISTROS ADICIONADO ::::
            HBox hboxDaTela = new HBox();
            hboxDaTela.getChildren().add(new TextField(Main.produtos.get(i).getDescricao()));
            hboxDaTela.getChildren().add(new TextField(Double.toString(Main.produtos.get(i).getValorVarejo())));
            hboxDaTela.getChildren().add(new TextField(Double.toString(Main.produtos.get(i).getValorAtacado())));
            hboxDaTela.getChildren().add(new TextField(Double.toString(Main.produtos.get(i).getEstoque())));

            // :::: CRIA O BOTÃO ATUALIZAR ::::
            Button botaoAtualizar = new Button("Atualizar");
            botaoAtualizar.setPrefWidth(80);
            botaoAtualizar.setCursor(Cursor.HAND);

            botaoAtualizar.setOnAction(actionEvent -> {
                try {
                    editar(Main.produtos.get(posicao), posicao);
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro no botão de atualizar produtos");
                    e.printStackTrace();
                }
            });
            hboxDaTela.getChildren().add(botaoAtualizar);

            // :::: CRIA O BOTÃO DELETAR ::::
            Button botaoDeletar = new Button("Deletar");
            botaoDeletar.setPrefWidth(80);
            botaoDeletar.setCursor(Cursor.HAND);

            botaoDeletar.setOnAction(actionEvent -> {
                try {
                    detelar(Main.produtos.get(posicao));
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro no botão de deletar produtos");
                    e.printStackTrace();
                }
            });
            hboxDaTela.getChildren().add(botaoDeletar);

            // :::: ADICIONA A TABELA NO VBOX ::::
            vBoxTela.getChildren().add(hboxDaTela);
        }
    }

    public void editar(Produto produto, int posicao) throws Exception {
        Main.stagePrincipal.setTitle("Atualizar");

        FXMLLoader floater = new FXMLLoader(getClass().getResource("/telas/Cadastro.fxml"));
        Parent root = floater.load();

        //Utiliza o controlador da tela de Cadastro
        ControllerCadastro controllerCadastro = floater.<ControllerCadastro>getController();
        controllerCadastro.lblTitulo.setText("Alterar Produto");
        controllerCadastro.btnCadastrar.setText("Alterar");
        controllerCadastro.posicaoArray = posicao;

        //PREENCHENDO CAMPOS DA TELA COM AS INFORMAÇÕES DO PRODUTO SELECIONADO
        controllerCadastro.txtDescricao.setText(produto.getDescricao());
        controllerCadastro.txtVarejo.setText(String.valueOf(produto.getValorVarejo()));
        controllerCadastro.txtAtacado.setText(String.valueOf(produto.getValorAtacado()));
        controllerCadastro.txtEstoque.setText(String.valueOf(produto.getEstoque()));
        controllerCadastro.telaAtualizar = true;

        // -------EXIBI A TELA DE ATUALIZAR------
        Main.stagePrincipal.setScene(new Scene(root));
    }

    public void detelar(Produto produto) throws Exception{
        Main.produtos.remove(produto);
        Parent root = FXMLLoader.load(getClass().getResource("/telas/listar.fxml"));

        Main.stagePrincipal.setScene(new Scene(root));
    }

    public void voltarMenu() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/telas/menuPrincipal.fxml"));

        Main.stagePrincipal.setScene(new Scene(root));
    }
}
