import java.util.Scanner;

public class ClienteView {
    private Scanner scanner = new Scanner(System.in);

    // Exibe o menu de operações com o cliente
    public int exibirMenu() {
        System.out.println("---- Menu de Cadastro de Clientes ----");
        System.out.println("1. Criar cliente");
        System.out.println("2. Alterar cliente");
        System.out.println("3. Remover cliente");
        System.out.println("4. Adicionar veículo ao cliente");
        System.out.println("5. Listar veículos do cliente");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    // Solicita o nome do cliente
    public String solicitarNomeCliente() {
        System.out.print("Digite o nome do cliente: ");
        scanner.nextLine(); // Consumir quebra de linha
        return scanner.nextLine();
    }

    // Solicita o CPF do cliente
    public String solicitarCpfCliente() {
        System.out.print("Digite o CPF do cliente: ");
        return scanner.nextLine();
    }

    // Solicita a placa do veículo
    public String solicitarPlacaVeiculo() {
        System.out.print("Digite a placa do veículo: ");
        return scanner.nextLine();
    }

    // Exibe uma mensagem de retorno para o usuário
    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    // Lista os veículos associados ao cliente
    public void listarVeiculos(Cliente cliente) {
        System.out.println("Veículos do cliente " + cliente.getNome() + ":");
        for (Veiculo veiculo : cliente.listarVeiculos()) {
            System.out.println("Placa: " + veiculo.getPlaca());
        }
    }
}
