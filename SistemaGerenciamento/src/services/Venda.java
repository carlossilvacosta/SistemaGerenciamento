package services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Operacao;
import entities.Produto;

public class Venda extends Operacao{

    private List<Produto> produtos;

    public Venda(long id, String tipo, double valor, Date dataOperacao, String observavao, List<Produto> produtos) {
        super(id, tipo, valor, dataOperacao, observavao);
        this.produtos = produtos;
    }

    public List<Produto> getProdutos() {
        if(produtos == null) {
            produtos = new ArrayList<>();
        }
        return produtos;
    }
   
    @Override
    public void executarOperacao() {
        System.out.println("Operação realizada, obrigado pela venda!");
    }
    
}
