
package com.exemplo.jogador.service;

import com.exemplo.jogador.dto.JogadorRequestDTO;
import com.exemplo.jogador.dto.JogadorResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class JogadorService {

    private final List<JogadorResponseDTO> jogadores = new ArrayList<>();
    private final Random random = new Random();

    public JogadorResponseDTO criarJogador(JogadorRequestDTO jogadorRequestDTO) {
        int habilidade = random.nextInt(101);  // Gera número entre 0 e 100
        String statusMessage = "Jogador criado com sucesso!";
        
        JogadorResponseDTO jogadorResponseDTO = new JogadorResponseDTO(
                jogadorRequestDTO.nome(),
                jogadorRequestDTO.apelido(),
                habilidade,
                statusMessage
        );
        jogadores.add(jogadorResponseDTO);
        return jogadorResponseDTO;
    }

    public List<JogadorResponseDTO> listarTodosJogadores() {
        return jogadores;
    }
}
    