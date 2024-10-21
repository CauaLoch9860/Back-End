
package com.exemplo.jogador.controller;

import com.exemplo.jogador.dto.JogadorRequestDTO;
import com.exemplo.jogador.dto.JogadorResponseDTO;
import com.exemplo.jogador.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @PostMapping
    public JogadorResponseDTO criarJogador(@RequestBody JogadorRequestDTO jogadorRequestDTO) {
        return jogadorService.criarJogador(jogadorRequestDTO);
    }

    @GetMapping
    public List<JogadorResponseDTO> listarTodosJogadores() {
        return jogadorService.listarTodosJogadores();
    }
}
    