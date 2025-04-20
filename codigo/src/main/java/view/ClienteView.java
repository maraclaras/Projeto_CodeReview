package view;
import java.util.Scanner;

import BancoDados.BancoDados;
import DAO.ClienteDAO;
import DAO.Cobranca;
import DAO.Vaga;
import DAO.Veiculo;
import controller.ClienteController;
import modal.ParqueEstacionamento;

public class ClienteView {
    private Scanner scanner;
    private ClienteController clienteController;
    private ParqueEstacionamento parqueEstacionamento;

    // Construtor que recebe o ParqueEstacionamento e o ClienteController
    public ClienteView(ParqueEstacionamento parqueEstacionamento, ClienteController clienteController) {
        this.parqueEstacionamento = parqueEstacionamento;
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
            System.out.println("7. Calcular cobrança de cliente");
            System.out.println("8. Voltar");
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
                    calcularCobrancaCliente();
                    break;
                case 8:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 8);
    }

    // Cria um novo cliente
    private void criarCliente() {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        ClienteDAO novoCliente = new ClienteDAO(nome, cpf);
        clienteController.adicionarCliente(novoCliente);
        System.out.println("Cliente cadastrado com sucesso.");
    }

    // Altera os dados de um cliente
    private void alterarCliente() {
        System.out.print("Digite o CPF do cliente para alterar: ");
        String cpf = scanner.nextLine();
        ClienteDAO cliente = clienteController.buscarCliente(cpf);
        if (cliente != null) {
            System.out.print("Digite o novo nome do cliente: ");
            String novoNome = scanner.nextLine();
            cliente.setNome(novoNome);
            System.out.println("Dados do cliente alterados com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    // Remove um cliente
    private void removerCliente() {
        System.out.print("Digite o CPF do cliente para remover: ");
        String cpf = scanner.nextLine();
        if (clienteController.removerCliente(cpf)) {
            System.out.println("Cliente removido com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    // Adiciona um veículo ao cliente
    private void adicionarVeiculo() {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        ClienteDAO cliente = clienteController.buscarCliente(cpf);
        if (cliente != null) {
            System.out.print("Digite a placa do veículo: ");
            String placa = scanner.nextLine();
            Veiculo veiculo = new Veiculo(placa);
            clienteController.adicionarVeiculo(cpf, veiculo);
            System.out.println("Veículo adicionado com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    // Lista os veículos de um cliente
    private void listarVeiculos() {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        ClienteDAO cliente = clienteController.buscarCliente(cpf);
        if (cliente != null) {
            System.out.println("Veículos do cliente " + cliente.getNome() + ":");
            for (Veiculo veiculo : cliente.listarVeiculos()) {
                System.out.println("Placa: " + veiculo.getPlaca());
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    // Lista todos os clientes
    private void listarTodosClientes() {
        System.out.println("Lista de todos os clientes:");
        for (ClienteDAO cliente : clienteController.listarClientes()) {
            System.out.println("Nome: " + cliente.getNome() + ", CPF: " + cliente.getCpf());
        }
    }

    // Calcula a cobrança de um cliente
    private void calcularCobrancaCliente() {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        ClienteDAO cliente = parqueEstacionamento.buscarClientePorCpf(cpf);
        if (cliente != null) {
            Veiculo veiculo = parqueEstacionamento.buscarVeiculoPorCliente(cliente);
            if (veiculo != null) {
                Vaga vaga = parqueEstacionamento.obterVagaPorVeiculo(veiculo);
                if (vaga != null) {
                    System.out.print("Digite o tempo (em minutos) que o veículo ficou estacionado: ");
                    int minutos = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha

                    Cobranca cobranca = new Cobranca();
                    double valor = cobranca.calcularValor(minutos, vaga);
                    System.out.println("Valor total da cobrança: R$ " + valor);

                    // Cobrar o cliente
                    cobranca.cobrarCliente(cpf, valor);
                } else {
                    System.out.println("Vaga não encontrada para o veículo.");
                }
            } else {
                System.out.println("Veículo não encontrado para o cliente.");
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}