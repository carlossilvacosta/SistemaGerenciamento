package util;

import java.util.List;

public interface GerenciamentoDados {

    void adicionar(Object obj);
    void remover(long id);
    Object buscarPorId(long id);
    List<Object> listarTodos();
    
}