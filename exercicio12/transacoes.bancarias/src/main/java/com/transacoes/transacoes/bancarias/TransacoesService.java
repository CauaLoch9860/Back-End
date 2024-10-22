package com.transacoes.transacoes.bancarias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class TransacoesService {

    @Autowired
    private ContaMapper contaMapper;
    private List<Conta> contas = new ArrayList<>();
    public TransacaoResponseDTO gerarTransacao(TransacaoRequestDTO request) {
        Conta contaOrigem = contas.stream()
                .filter(conta -> conta.getCodigo().equals(request.getOrigem()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Conta de origem não encontrada"));

        Conta contaDestino = contas.stream()
                .filter(conta -> conta.getCodigo().equals(request.getDestino()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Conta de destino não encontrada"));

        if (contaOrigem.getSaldo() < request.getValor()) {
            throw new RuntimeException("Saldo insuficiente");
        }

        contaOrigem.setSaldo(contaOrigem.getSaldo() - request.getValor());
        contaDestino.setSaldo(contaDestino.getSaldo() + request.getValor());

        TransacaoResponseDTO response = new TransacaoResponseDTO();
        response.setOrigem(contaMapper.toDTO(contaOrigem));
        response.setDestino(contaMapper.toDTO(contaDestino));
        response.setValor(request.getValor());

        return response;
    }
    public void addConta(Conta conta) {
        contas.add(conta);
    }
}
