package services;

import java.util.ArrayList;
import java.util.List;

import entities.Produto;
import util.GerenciamentoDados;

public class Estoque implements GerenciamentoDados {

    private List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    public List<Produto> getProdutos() {
        if(produtos == null) {
            produtos = new ArrayList<>();
        }
        return produtos;
    }

    @Override
    public void adicionar(Object obj) {
        if (obj instanceof Produto) {
            produtos.add((Produto) obj);
        }
    }

    @Override
    public void remover(long id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }

    @Override
    public Object buscarPorId(long id) {
        for(Produto produto : produtos) {
            if(produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public List<Object> listarTodos() {
        return new ArrayList<>(produtos);
    }
    
}
