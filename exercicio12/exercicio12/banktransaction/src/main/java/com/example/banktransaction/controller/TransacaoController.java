package com.example.banktransaction.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.banktransaction.dto.TransacaoRequestDTO;
import com.example.banktransaction.dto.TransacaoResponseDTO;
import com.example.banktransaction.service.TransacoesService;
@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacoesService transacoesService;

    @PostMapping("/gerar")
    public TransacaoResponseDTO gerarTransacao(@RequestBody TransacaoRequestDTO request) {
        return transacoesService.realizarTransacao(request);
    }
}