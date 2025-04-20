package view;

import java.util.Scanner;

import controller.ClienteController;
import DTO.VeiculoDTO;

public class ClienteView {
    private Scanner scanner;
    private ClienteController clienteController;

    // Construtor que recebe o ClienteController
    public ClienteView(ClienteController clienteController) {
        this.clienteController = clienteController;
        this.scanner = new Scanner(System.in);
    }

    // Exibe o menu de operações com o cliente
    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("---- Menu de Cadastro de Clientes ----");
            System.out.println("1. Criar cliente");
            System.out.println("2. Alterar cliente");
            System.out.println("3. Remover cliente");
            System.out.println("4. Adicionar veículo ao cliente");
            System.out.println("5. Listar veículos do cliente");
            System.out.println("6. Listar todos os clientes");
            System.out.println("7. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    criarCliente();
                    break;
                case 2:
                    alterarCliente();
                    break;
                case 3:
                    removerCliente();
                    break;
                case 4:
                    adicionarVeiculo();
                    break;
                case 5:
                    listarVeiculos();
                    break;
                case 6:
                    listarTodosClientes();
                    break;
                case 7:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 7);
    }

    // Cria um novo cliente
    private void criarCliente() {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        clienteController.criarCliente(nome, cpf);
    }

    // Altera os dados de um cliente
    private void alterarCliente() {
        System.out.print("Digite o CPF do cliente para alterar: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o novo nome do cliente: ");
        String novoNome = scanner.nextLine();
        clienteController.alterarCliente(cpf, novoNome);
    }

    // Remove um cliente
    private void removerCliente() {
        System.out.print("Digite o CPF do cliente para remover: ");
        String cpf = scanner.nextLine();
        clienteController.removerCliente(cpf);
    }

    // Adiciona um veículo ao cliente
    private void adicionarVeiculo() {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();
        System.out.print("Digite o modelo do veículo: ");
        String modelo = scanner.nextLine();
        clienteController.adicionarVeiculo(cpf, new VeiculoDTO(placa, modelo, null));
    }

    // Lista os veículos de um cliente
    private void listarVeiculos() {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        clienteController.listarVeiculos(cpf);
    }

    // Lista todos os clientes
    private void listarTodosClientes() {
        clienteController.listarTodosClientes();
    }
}