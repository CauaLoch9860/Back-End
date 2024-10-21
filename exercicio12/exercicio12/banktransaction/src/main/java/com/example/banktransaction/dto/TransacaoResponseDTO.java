package com.example.banktransaction.dto;

import com.example.banktransaction.Conta;

public class TransacaoResponseDTO {
    private Conta origem;
    private Conta destino;
    private double valor;

    public TransacaoResponseDTO(Conta origem, Conta destino, double valor) {
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
    }

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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}