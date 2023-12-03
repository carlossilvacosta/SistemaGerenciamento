package util;

public interface InteracaoUsuario {
    
    void exibirMenu();
    void selecionarOpcao(int opcao);
    void mostrarResultado(String resultado);
    String lerEntradaUsuario();
    
}