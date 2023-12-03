package entities;

import java.util.Date;

public abstract class Operacao {
    
    private long id;
    private String tipo;
    private double valor;
    private Date dataOperacao;
    private String observavao;

    public Operacao(long id, String tipo, double valor, Date dataOperacao, String observavao) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.dataOperacao = dataOperacao;
        this.observavao = observavao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(Date dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public String getObservavao() {
        return observavao;
    }

    public void setObservavao(String observavao) {
        this.observavao = observavao;
    }

    public abstract void executarOperacao();

}
