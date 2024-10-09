import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteController {
    private List<Cliente> clientes;
    private ParqueEstacionamento estacionamento;
    private Scanner leitor;

    // Construtor que recebe ParqueEstacionamento e Scanner
    public ClienteController(ParqueEstacionamento estacionamento, Scanner leitor) {
        this.clientes = new ArrayList<>();
        this.estacionamento = estacionamento; // Armazena a referência do estacionamento
        this.leitor = leitor; // Armazena a referência do scanner
    }

    // Busca um cliente pelo CPF
    public Cliente buscarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente; // Retorna o cliente encontrado
            }
        }
        return null; // Retorna null se o cliente não for encontrado
    }

    // Altera um cliente existente
    public boolean alterarCliente(String cpf, String novoNome) {
        Cliente cliente = buscarCliente(cpf);
        if (cliente != null) {
            cliente.setNome(novoNome); // Altera o nome do cliente
            return true; // Retorna true se a alteração for bem-sucedida
        }
        return false; // Retorna false se o cliente não for encontrado
    }

    // Remove um cliente e retorna se foi bem-sucedido
    public boolean removerCliente(String cpf) {
        Cliente cliente = buscarCliente(cpf);
        if (cliente != null) {
            clientes.remove(cliente); // Remove o cliente da lista
            return true; // Retorna true se a remoção for bem-sucedida
        }
        return false; // Retorna false se o cliente não for encontrado
    }

    // Adiciona um cliente
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente); // Adiciona um novo cliente à lista
    }

    // Lista todos os clientes
    public List<Cliente> listarClientes() {
        return clientes; // Retorna a lista de clientes
    }

    // Adiciona um veículo ao cliente
    public boolean adicionarVeiculo(String cpf, Veiculo veiculo) {
        Cliente cliente = buscarCliente(cpf); // Busca o cliente pelo CPF
        if (cliente != null) {
            cliente.adicionarVeiculo(veiculo); // Adiciona o veículo ao cliente
            return true; // Retorna true se a adição for bem-sucedida
        }
        return false; // Retorna false se o cliente não for encontrado
    }
}
