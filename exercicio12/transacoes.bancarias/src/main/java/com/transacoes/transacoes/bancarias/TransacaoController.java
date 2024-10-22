package com.transacoes.transacoes.bancarias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class TransacaoController {
    @Autowired
    private TransacoesService transacoesService;
    @PostMapping("/transacoes")
    public ResponseEntity<TransacaoResponseDTO> gerarTransacao(@RequestBody TransacaoRequestDTO request) {
        try {
            TransacaoResponseDTO response = transacoesService.gerarTransacao(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @PostMapping("/contas")
    public ResponseEntity<Void> adicionarConta(@RequestBody Conta conta) {
        transacoesService.addConta(conta);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
