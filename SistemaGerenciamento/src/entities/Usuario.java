package entities;

import java.util.Date;

public class Usuario extends EntidadeBase {

    private String email;
    private String senha;

    public Usuario(long id, String nome, String descricao, 
    Date dataCriacao, boolean ativo, String email, String senha) {
        super(id, nome, descricao, dataCriacao, ativo);
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String getDetalhes() {
        return "\n" + "Detalhes do Usuário: " + "\n"
        + "ID: " + getId() + "\n"
        + "Nome: " + getNome() + "\n"
        + "Descrição: " + getDescricao() + "\n"
        + "Data de Criação: " + getDataCriacao() + "\n"
        + "Ativo: " + (isAtivo() ? "Sim" : "Não");
    }

    @Override
    public String toString() {
        return "Usuario:" + "\n"
        + "Email: " + email + "\n"
        + "Senha: " + senha;
    }
    
}
