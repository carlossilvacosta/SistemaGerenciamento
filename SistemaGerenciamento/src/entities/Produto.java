package entities;

import java.util.Date;

public class Produto extends EntidadeBase{
    
    private double price;
    private int quantidadeEstoque;

    public Produto(long id, String nome, String descricao, 
    Date dataCriacao, boolean ativo, double price, int quantidadeEstoque) {
        super(id, nome, descricao, dataCriacao, ativo);
        this.price = price;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @Override
    public String toString() {
        return "Produto:" + "\n"
        + "Price: " + price + "\n"
        + "Quantidade em Estoque: " + quantidadeEstoque;
    }

    @Override
    public String getDetalhes() {
        return "\n" + "Detalhes do Produto:" + "\n"
        + "ID: " + getId() + "\n"
        + "Nome: " + getNome() + "\n"
        + "Descrição: " + getDescricao() + "\n"
        + "Data de Criação: " + getDataCriacao() + "\n"
        + "Ativo: " + (isAtivo() ? "Sim" : "Não");
    }
    
}
