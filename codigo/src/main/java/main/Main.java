package main;

import java.util.Scanner;

import controller.ClienteController;
import controller.CobrancaController;
import controller.ParqueEstacionamentoController;
import view.ClienteView;
import view.EstacionamentoView;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        // Inicializa o Parque de Estacionamento e Controladores
        ParqueEstacionamentoController estacionamentoController = new ParqueEstacionamentoController(1, 10);
        ClienteController clienteController = new ClienteController(estacionamentoController.getParqueEstacionamento(), leitor);
        CobrancaController cobrancaController = new CobrancaController(estacionamentoController.getParqueEstacionamento(), leitor);

        // Inicializa as views
        ClienteView clienteView = new ClienteView(estacionamentoController.getParqueEstacionamento(), clienteController);
        EstacionamentoView estacionamentoView = new EstacionamentoView(estacionamentoController);

        int opcao = 0; // Inicializa a variável opcao
        do {
            System.out.println("=======================================");
            System.out.println("            SEJA BEM VINDO AO          ");
            System.out.println("          PARQUE ESTACIONAMENTO        ");
            System.out.println("=======================================");
            System.out.println("          Digite uma opção             ");
            System.out.println("(1) Área do Cliente");
            System.out.println("(2) Área do Estacionamento");
            System.out.println("(3) Sair");
            System.out.print("Escolha uma opção: ");
            opcao = leitor.nextInt();
            leitor.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    clienteView.exibirMenu();
                    break;
                case 2:
                    estacionamentoView.exibirMenu();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);
    }
}