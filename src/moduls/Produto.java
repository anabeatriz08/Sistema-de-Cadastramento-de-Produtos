package moduls;

import java.util.List;

public class Produto {

    private String descricao;
    private double valorVarejo;
    private double valorAtacado;
    private double estoque;

    public Produto(String descricao, double varejo, double atacado, double estoque) {
        this.descricao = descricao;
        this.valorVarejo = varejo;
        this.valorAtacado = atacado;
        this.estoque = estoque;
    }

    public Produto() {

    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorVarejo() {
        return valorVarejo;
    }

    public void setValorVarejo(double valorVarejo) {
        this.valorVarejo = valorVarejo;
    }

    public double getValorAtacado() {
        return valorAtacado;
    }

    public void setValorAtacado(double valorAtacado) {
        this.valorAtacado = valorAtacado;
    }

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "descricao='" + descricao + '\'' +
                ", valorVarejo=" + valorVarejo +
                ", valorAtacado=" + valorAtacado +
                ", estoque=" + estoque +
                '}';
    }
}
