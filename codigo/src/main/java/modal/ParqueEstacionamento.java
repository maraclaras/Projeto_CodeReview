import java.util.ArrayList;
import java.util.HashMap;

public class ParqueEstacionamento {
    private ArrayList<Cliente> clientes;
    private HashMap<Veiculo, Cliente> veiculoClienteMap; // Mapeia veículos para seus respectivos clientes
    private HashMap<Veiculo, Vaga> vagasOcupadas; // Mapeia veículos para suas respectivas vagas
    private ArrayList<Vaga> vagas;

    public ParqueEstacionamento(int numFilas, int numVagasPorFila) {
        clientes = new ArrayList<>();
        vagas = new ArrayList<>();
        vagasOcupadas = new HashMap<>();
        veiculoClienteMap = new HashMap<>();  // Inicializa o veiculoClienteMap
    
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
        return null; // Retorna null se o cliente não for encontrado
    }

    public void estacionarVeiculo(Veiculo veiculo, Cliente cliente) {
        // Lógica para estacionar o veículo e associá-lo a uma vaga
        for (Vaga vaga : vagas) {
            if (!vaga.isOcupada()) {
                try {
                    vaga.ocupar(); // Tenta ocupar a vaga
                    vagasOcupadas.put(veiculo, vaga);
                    veiculoClienteMap.put(veiculo, cliente); // Associa o veículo ao cliente
                    System.out.println("Veículo " + veiculo.getPlaca() + " estacionado na vaga " + vaga.getIdentificador());
                    return;
                } catch (VagaInvalidaException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("Não há vagas disponíveis.");
    }

    public Vaga obterVagaPorVeiculo(Veiculo veiculo) {
        return vagasOcupadas.get(veiculo); // Retorna a vaga ocupada pelo veículo
    }

    // Método para buscar o veículo associado a um cliente
    public Veiculo buscarVeiculoPorCliente(Cliente cliente) {
        // Itera sobre o mapa de veículos e clientes
        for (Veiculo veiculo : veiculoClienteMap.keySet()) {
            // Verifica se o cliente associado ao veículo é o cliente buscado
            if (veiculoClienteMap.get(veiculo).equals(cliente)) {
                return veiculo;
            }
        }
        // Retorna null se nenhum veículo for encontrado para o cliente
        return null;
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
