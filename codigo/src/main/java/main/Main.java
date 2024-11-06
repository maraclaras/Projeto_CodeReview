import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParqueEstacionamento estacionamento = new ParqueEstacionamento(1, 10);
        Scanner leitor = new Scanner(System.in);
        ClienteController clienteController = new ClienteController(estacionamento, leitor);
        CobrancaController cobrancaController = new CobrancaController(estacionamento, leitor);
        ClienteView clienteView = new ClienteView(estacionamento, clienteController);

        int opcao = 0; // Inicializa a variável opcao

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
            System.out.println("(5) SAIR");

            try {
                opcao = leitor.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido.");
                leitor.next(); // Limpa o buffer
                continue; // Retorna ao início do loop
            }

            switch (opcao) {
                case 1:
                    clienteView.exibirMenu();
                    break;
                case 2:
                    estacionamento.listarClientes();
                    break;
                case 3:
                    estacionamento.listarVagas();
                    break;
                case 4:
                    cobrancaController.calcularTaxaCliente();
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        } while (opcao != 5);

        leitor.close();
    }
}
