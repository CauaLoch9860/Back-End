package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        cinema.adicionarFilme(new Filme("Nada de novo no front", 15.0, 16));
        cinema.adicionarFilme(new Filme("O Rei Leão", 10.0, 6));
        cinema.adicionarFilme(new Filme("Vingadores", 20.0, 14));
        cinema.adicionarFilme(new Filme("Branca de neve e os sete anões", 12.0, 4));
        cinema.adicionarFilme(new Filme("Coringa", 18.0, 16));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Que filme você deseja assistir? ");
            String nomeFilme = scanner.nextLine();
            Filme filmeEscolhido = cinema.buscarFilme(nomeFilme);

            if (filmeEscolhido == null) {
                System.out.println("Filme não encontrado.");
                continue;
            }

            System.out.print("Qual o seu nome? ");
            String nomeCliente = scanner.nextLine();
            System.out.print("Qual a sua idade? ");
            int idadeCliente = scanner.nextInt();
            scanner.nextLine();

            Cliente cliente = new Cliente(nomeCliente, idadeCliente);

            if (cliente.getIdade() < filmeEscolhido.getIdadeMinima()) {
                System.out.println("O ingresso não pode ser vendido pois sua idade não permite!");
                continue;
            }

            System.out.print("Qual assento você deseja? ");
            String assento = scanner.nextLine();

            if (!cinema.assentoDisponivel(assento)) {
                System.out.println("O ingresso não pode ser vendido pois seu assento não está mais disponível!");
                continue;
            }

            Ingresso ingresso = new Ingresso(cliente, filmeEscolhido, assento);
            cinema.venderIngresso(ingresso);

            System.out.println("Ingresso vendido com sucesso! " + filmeEscolhido.getNome() + " - " + assento + " - " + cliente.getNome());
        }
    }
}
