import java.util.Scanner;

public class ClienteView {
    private Scanner scanner = new Scanner(System.in);
    private ClienteController clienteController = new ClienteController(); // Adicione o controller
    private ParqueEstacionamento parqueEstacionamento;

    public ClienteView(ParqueEstacionamento parqueEstacionamento) {
        this.parqueEstacionamento = parqueEstacionamento;
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
            System.out.println("7. Sair");
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
                    System.out.println("Saindo...");
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
        Cliente novoCliente = new Cliente(nome, cpf);
        clienteController.adicionarCliente(novoCliente);
        System.out.println("Cliente cadastrado com sucesso.");
    }

    // Altera os dados de um cliente
    private void alterarCliente() {
        System.out.print("Digite o CPF do cliente para alterar: ");
        String cpf = scanner.nextLine();
        Cliente cliente = clienteController.buscarCliente(cpf);
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
        clienteController.removerCliente(cpf);
        System.out.println("Cliente removido com sucesso.");
    }

    // Adiciona um veículo ao cliente
    private void adicionarVeiculo() {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        Cliente cliente = clienteController.buscarCliente(cpf);
        if (cliente != null) {
            System.out.print("Digite a placa do veículo: ");
            String placa = scanner.nextLine();
            Veiculo veiculo = new Veiculo(placa);
            cliente.adicionarVeiculo(veiculo);
            System.out.println("Veículo adicionado com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    // Lista os veículos de um cliente
    private void listarVeiculos() {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        Cliente cliente = clienteController.buscarCliente(cpf);
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
        for (Cliente cliente : clienteController.listarClientes()) {
            System.out.println("Nome: " + cliente.getNome() + ", CPF: " + cliente.getCpf());
        }
    }
    public void calcularCobrancaCliente() {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
    
        Cliente cliente = parqueEstacionamento.buscarClientePorCpf(cpf);
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

