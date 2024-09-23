package com.exercicio.exercicio07.service;

import com.exercicio.exercicio07.model.Cliente;
import com.exercicio.exercicio07.model.Filme;
import com.exercicio.exercicio07.model.Ingresso;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CinemaService {
    private List<Filme> filmesDisponiveis = new ArrayList<>();
    private List<Ingresso> ingressosVendidos = new ArrayList<>();
    private List<String> assentosDisponiveis = new ArrayList<>();

    public CinemaService() {
        filmesDisponiveis.add(new Filme("Nada de novo no front", 30.0, 16));
        filmesDisponiveis.add(new Filme("Vingadores", 40.0, 14));
        filmesDisponiveis.add(new Filme("Branca de neve e os sete anões", 20.0, 0));
        filmesDisponiveis.add(new Filme("Matrix", 35.0, 16));
        filmesDisponiveis.add(new Filme("Inception", 45.0, 16));

        for (char row = 'A'; row <= 'F'; row++) {
            for (int seat = 1; seat <= 5; seat++) {
                assentosDisponiveis.add("" + row + seat);
            }
        }
    }

    public String venderIngresso(String nomeCliente, int idadeCliente, String nomeFilme, String assento) throws Exception {
        Filme filmeEscolhido = null;
        for (Filme filme : filmesDisponiveis) {
            if (filme.getNome().equalsIgnoreCase(nomeFilme)) {
                filmeEscolhido = filme;
                break;
            }
        }

        if (filmeEscolhido == null) {
            throw new Exception("Filme não encontrado.");
        }

        if (idadeCliente < filmeEscolhido.getIdadeMinima()) {
            throw new Exception("Idade insuficiente para assistir ao filme.");
        }

        if (!assentosDisponiveis.contains(assento)) {
            throw new Exception("Assento não disponível.");
        }

        Cliente cliente = new Cliente(nomeCliente, idadeCliente);
        Ingresso ingresso = new Ingresso(cliente, filmeEscolhido, assento);
        ingressosVendidos.add(ingresso);
        assentosDisponiveis.remove(assento);

        return "Ingresso vendido com sucesso! " + filmeEscolhido.getNome() + " - " + assento + " - " + nomeCliente;
    }
}
