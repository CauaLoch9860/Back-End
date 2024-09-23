package com.exercicio.exercicio07.controller;

import com.exercicio.exercicio07.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/comprar-ingresso")
    public String comprarIngresso(
            @RequestParam String nomeCliente,
            @RequestParam int idadeCliente,
            @RequestParam String nomeFilme,
            @RequestParam String assento) {
        try {
            return cinemaService.venderIngresso(nomeCliente, idadeCliente, nomeFilme, assento);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
