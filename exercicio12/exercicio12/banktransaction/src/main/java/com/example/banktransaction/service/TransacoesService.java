package com.example.banktransaction.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.banktransaction.Conta;
import com.example.banktransaction.dto.TransacaoRequestDTO;
import com.example.banktransaction.dto.TransacaoResponseDTO;

@Service
public class TransacoesService {
    private List<Conta> contas;
    public TransacoesService() {
        contas = new ArrayList<>();
        contas.add(new Conta("111-2", "cliente1"));
        contas.add(new Conta("222-3", "cliente2"));
    }
    public List<Conta> getContas() {
        return contas;
    }
    public TransacaoResponseDTO realizarTransacao(TransacaoRequestDTO request) {
        Conta origem = contas.stream()
                .filter(conta -> conta.getCodigo().equals(request.getOrigem()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Conta origem não encontrada"));
        Conta destino = contas.stream()
                .filter(conta -> conta.getCodigo().equals(request.getDestino()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Conta destino não encontrada"));
        double valor = request.getValor();
        return new TransacaoResponseDTO(origem, destino, valor);
    }
}