import java.util.ArrayList;
import java.util.HashMap;

public class ParqueEstacionamento {
    private ArrayList<Cliente> clientes;
    private HashMap<Veiculo, Vaga> vagasOcupadas; // Mapeia veículos para suas respectivas vagas
    private ArrayList<Vaga> vagas;

    public ParqueEstacionamento(int numFilas, int numVagasPorFila) {
        clientes = new ArrayList<>();
        vagas = new ArrayList<>();
        vagasOcupadas = new HashMap<>();
    
        // Inicializar as vagas
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numVagasPorFila; j++) {
                String identificador = String.format("%c%02d", 'A' + i, j + 1); // Ex: A01, A02, ...
                try {
                    vagas.add(new Vaga(identificador, numFilas * numVagasPorFila)); // Lida com a exceção aqui
                } catch (VagaInvalidaException e) {
                    System.out.println("Erro ao criar a vaga: " + e.getMessage());
                }
            }
        }
    }
    

    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null; // Cliente não encontrado
    }
public void ocupar() {
    if (ocupada) {
        System.out.println("A vaga " + identificador + " já está ocupada.");
        return; // Ou você pode lançar uma exceção aqui se preferir.
    }
    this.ocupada = true; // Marca a vaga como ocupada.
}
    public void estacionarVeiculo(Veiculo veiculo, Cliente cliente) {
        // Lógica para estacionar o veículo e associá-lo a uma vaga
        for (Vaga vaga : vagas) {
            if (!vaga.isOcupada()) {
                vaga.ocupar(); // Chama o método ocupar, assumindo que não lançará exceção
                vagasOcupadas.put(veiculo, vaga);
                System.out.println("Veículo " + veiculo.getPlaca() + " estacionado na vaga " + vaga.getIdentificador());
                return;
            }
        }
        System.out.println("Não há vagas disponíveis.");
    }

    public Veiculo buscarVeiculoPorCliente(Cliente cliente) {
        for (HashMap.Entry<Veiculo, Vaga> entry : vagasOcupadas.entrySet()) {
            if (entry.getKey().getCliente().equals(cliente)) {
                return entry.getKey(); // Retorna o veículo associado ao cliente
            }
        }
        return null; // Veículo não encontrado
    }

    public Vaga obterVagaPorVeiculo(Veiculo veiculo) {
        return vagasOcupadas.get(veiculo); // Retorna a vaga ocupada pelo veículo
    }

    public void listarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void listarVagas() {
        for (Vaga vaga : vagas) {
            System.out.println(vaga);
        }
    }
}
