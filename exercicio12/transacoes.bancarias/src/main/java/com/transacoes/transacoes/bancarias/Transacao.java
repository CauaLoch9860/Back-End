package com.transacoes.transacoes.bancarias;
public class Transacao {
    private Conta origem;
    private Conta destino;
    private Double valor;
    // Getters e Setters
    public Conta getOrigem() {
        return origem;
    }
    public void setOrigem(Conta origem) {
        this.origem = origem;
    }
    public Conta getDestino() {
        return destino;
    }
    public void setDestino(Conta destino) {
        this.destino = destino;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
}
