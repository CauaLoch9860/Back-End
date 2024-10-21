package com.example.banktransaction;
public class Conta {
    private String codigo;
    private String cliente;
    public Conta(String codigo, String cliente) {
        this.codigo = codigo;
        this.cliente = cliente;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
