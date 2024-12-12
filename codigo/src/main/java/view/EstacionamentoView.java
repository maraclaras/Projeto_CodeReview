package view;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

import DAO.Cliente;
import DAO.Vaga;
import DAO.Veiculo;
import controller.ParqueEstacionamentoController;
import controller.ClienteController;
import exceptions.VagaInvalidaException;

public class EstacionamentoView {
    private Scanner scanner;
    private ParqueEstacionamentoController estacionamentoController;
    private ClienteController clienteController;

    // Construtor atualizado para receber ClienteController
    public EstacionamentoView(ParqueEstacionamentoController estacionamentoController, ClienteController clienteController) {
        this.estacionamentoController = estacionamentoController;
        this.clienteController = clienteController; // Inicialização correta
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("---- Menu de Estacionamento ----");
            System.out.println("1. Estacionar veículo");
            System.out.println("2. Registrar saída de veículo");
            System.out.println("3. Consultar vaga do veículo");
            System.out.println("4. Listar clientes e vagas");
            System.out.println("5. Salvar dados");
            System.out.println("6. Carregar dados");
            System.out.println("7. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    estacionarVeiculo();
                    break;
                case 2:
                    registrarSaidaVeiculo();
                    break;
                case 3:
                    consultarVagaVeiculo();
                    break;
                case 4:
                    listarClientesEVagas();
                    break;
                case 5:
                    salvarDados();
                    break;
                case 6:
                    carregarDados();
                    break;
                case 7:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 8);
    }

    private void estacionarVeiculo() {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        Cliente cliente = clienteController.buscarCliente(cpf);
        if (cliente != null) {
            System.out.print("Digite a placa do veículo: ");
            String placa = scanner.nextLine();
            Veiculo veiculo = new Veiculo(placa, cliente);
            System.out.print("Digite o identificador da vaga: ");
            String identificador = scanner.nextLine();
            try {
                estacionamentoController.estacionarClienteNaVaga(identificador, veiculo, LocalDateTime.now());
                System.out.println("Veículo estacionado com sucesso.");
            } catch (VagaInvalidaException e) {
                System.out.println("Erro ao estacionar veículo: " + e.getMessage());
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private void registrarSaidaVeiculo() {
        System.out.print("Digite o identificador da vaga: ");
        String identificador = scanner.nextLine();
        try {
            estacionamentoController.liberarVaga(identificador, LocalDateTime.now());
            System.out.println("Veículo saiu com sucesso.");
        } catch (VagaInvalidaException e) {
            System.out.println("Erro ao registrar saída do veículo: " + e.getMessage());
        }
    }

    private void consultarVagaVeiculo() {
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();
        Veiculo veiculo = new Veiculo(placa);
        Vaga vaga = estacionamentoController.obterVagaPorVeiculo(veiculo);
        if (vaga != null) {
            System.out.println("Veículo está estacionado na vaga: " + vaga.getIdentificador());
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    private void listarClientesEVagas() {
        System.out.println("Lista de clientes e suas vagas:");
        for (Cliente cliente : estacionamentoController.listarClientes()) {
            System.out.println("Cliente: " + cliente.getNome() + ", CPF: " + cliente.getCpf());
            for (Veiculo veiculo : cliente.listarVeiculos()) {
                Vaga vaga = estacionamentoController.obterVagaPorVeiculo(veiculo);
                if (vaga != null) {
                    System.out.println("  Veículo: " + veiculo.getPlaca() + ", Vaga: " + vaga.getIdentificador());
                } else {
                    System.out.println("  Veículo: " + veiculo.getPlaca() + ", Vaga: Não estacionado");
                }
            }
        }
    }

    private void salvarDados() {
        String caminhoArquivo = "turmamanha-g3-puc-lovers-master/codigo/src/main/java/data";
        try {
            estacionamentoController.salvarDados(caminhoArquivo);
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    private void carregarDados() {
        String caminhoArquivo = "turmamanha-g3-puc-lovers-master/codigo/src/main/java/data";
        try {
            estacionamentoController.carregarDados(caminhoArquivo);
            System.out.println("Dados carregados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }
    }
}
