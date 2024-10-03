import java.util.ArrayList;
import java.util.List;

public class ParqueEstacionamento {
    private int id;
    private int vagasTotais;
    private List<Vaga> vagas; // Lista de vagas no estacionamento
    private List<Cliente> clientes; // Lista de clientes registrados

    // Construtor para inicializar o estacionamento
    public ParqueEstacionamento(int id, int vagasTotais) {
        this.id = id;
        this.vagasTotais = vagasTotais;
        this.vagas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    // Método para adicionar vagas ao estacionamento
    public void adicionarVaga(Vaga vaga) {
        if (vagas.size() < vagasTotais) {
            vagas.add(vaga);
            System.out.println("Vaga adicionada: " + vaga.getNumero());
        } else {
            System.out.println("Estacionamento cheio! Não é possível adicionar mais vagas.");
        }
    }

    // Método para registrar cliente
    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
        cliente.criarCliente();
    }

    // Método para listar clientes registrados no estacionamento
    public void listarClientes() {
        System.out.println("Clientes registrados:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    // Método para listar as vagas no estacionamento
    public void listarVagas() {
        System.out.println("Vagas no estacionamento:");
        for (Vaga vaga : vagas) {
            String status = vaga.getVeiculoNaVaga() ? "Ocupada" : "Livre";
            System.out.println("Vaga " + vaga.getNumero() + " - " + status);
        }
    }

    // Método para vincular um veículo a uma vaga
    public void estacionarVeiculo(Veiculo veiculo, Cliente cliente) {
        for (Vaga vaga : vagas) {
            if (!vaga.getVeiculoNaVaga()) { // Procura uma vaga livre
                vaga.vincularVeiculo(veiculo, cliente);
                cliente.adicionarVeiculo(veiculo); // Adiciona o veículo ao cliente
                System.out.println("Veículo estacionado na vaga " + vaga.getNumero());
                return;
            }
        }
        System.out.println("Não há vagas disponíveis.");
    }

    // Método para liberar uma vaga
    public void liberarVaga(int numeroVaga) {
        for (Vaga vaga : vagas) {
            if (vaga.getNumero() == numeroVaga && vaga.getVeiculoNaVaga()) {
                vaga.liberarVaga();
                System.out.println("Vaga " + numeroVaga + " liberada.");
                return;
            }
        }
        System.out.println("Vaga " + numeroVaga + " não está ocupada ou não existe.");
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVagasTotais() {
        return vagasTotais;
    }

    public void setVagasTotais(int vagasTotais) {
        this.vagasTotais = vagasTotais;
    }
}
