import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicializa o estacionamento com capacidade para 10 vagas
        ParqueEstacionamento estacionamento = new ParqueEstacionamento(1, 10);
        Scanner leitor = new Scanner(System.in);

        int opcao = 0;
        do {
            System.out.println("=======================================");
            System.out.println("            SEJA BEM VINDO AO          ");
            System.out.println("          PARQUE ESTACIONAMENTO        ");
            System.out.println("=======================================");
            System.out.println("          Digite uma opção             ");
            System.out.println("(1) Área do Cliente");
            System.out.println("(2) Listar Clientes");
            System.out.println("(3) Listar Vagas");
            System.out.println("(4) Calcular Taxa");
            System.out.println("(4) SAIR");

            opcao = leitor.nextInt();

            switch (opcao) {
                case 1:
                    menuCliente(estacionamento, leitor); // Chama o menu do cliente
                    break;
                case 2:
                    estacionamento.listarClientes(); // Lista clientes registrados
                    break;
                case 3:
                    estacionamento.listarVagas(); // Lista as vagas do estacionamento
                    break;
                case 4:
                    Cobranca cobranca = new Cobranca();
                    cobranca.calcularTaxaCliente(estacionamento, leitor);  
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        } while (opcao != 4);

        leitor.close();
    }

    // Método para lidar com as operações relacionadas ao cliente
    public static void menuCliente(ParqueEstacionamento estacionamento, Scanner leitor) {
        System.out.println("Digite o nome do cliente:");
        String nome = leitor.next();
        System.out.println("Digite o CPF do cliente:");
        String cpf = leitor.next();

        Cliente cliente = new Cliente(nome, cpf);
        estacionamento.registrarCliente(cliente); // Registra o cliente no estacionamento

        System.out.println("Cliente registrado com sucesso.");

        System.out.println("Deseja estacionar um veículo para esse cliente? (s/n)");
        String resposta = leitor.next();

        if (resposta.equalsIgnoreCase("s")) {
            System.out.println("Digite a placa do veículo:");
            String placa = leitor.next();
            System.out.println("Digite o modelo do veículo:");
            String modelo = leitor.next();

            Veiculo veiculo = new Veiculo(placa, modelo);
            estacionamento.estacionarVeiculo(veiculo, cliente); // Estaciona o veículo
        } else {
            System.out.println("Voltando ao menu principal.");
        }
    }
}
