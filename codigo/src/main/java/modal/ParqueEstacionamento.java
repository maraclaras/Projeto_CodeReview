package modal;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import DAO.ClienteDAO;
import DAO.VagaDAO;
import DTO.VeiculoDTO;
import exceptions.VagaInvalidaException;

public class ParqueEstacionamento implements Serializable {
    private static final long serialVersionUID = 1L;
    
    // Tornar clientes estático para acesso global
    public static ArrayList<ClienteDAO> clientes = new ArrayList<>();  // Mudança para static

    private HashMap<Veiculo, ClienteDAO> veiculoClienteMap;
    private HashMap<Veiculo, VagaDAO> vagasOcupadas;
    private ArrayList<VagaDAO> vagas;

    // Instância estática única
    private static ParqueEstacionamento instancia;

    // Construtor privado para prevenir a criação de múltiplas instâncias
    private ParqueEstacionamento(int numFilas, int numVagasPorFila) {
        vagas = new ArrayList<>();
        vagasOcupadas = new HashMap<>();
        veiculoClienteMap = new HashMap<>();

        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numVagasPorFila; j++) {
                String identificador = String.format("%c%02d", 'A' + i, j + 1);
                try {
                    vagas.add(new VagaDAO(identificador, numFilas * numVagasPorFila));
                } catch (VagaInvalidaException e) {
                    System.out.println("Erro ao criar a vaga: " + e.getMessage());
                }
            }
        }
    }

    // Método para obter a instância única
    public static ParqueEstacionamento getInstancia(int numFilas, int numVagasPorFila) {
        if (instancia == null) {
            instancia = new ParqueEstacionamento(numFilas, numVagasPorFila);
        }
        return instancia;
    }

    public static void registrarCliente(ClienteDAO cliente) {
        clientes.add(cliente);  // Adiciona o cliente à lista estática
    }

    public static ClienteDAO buscarClientePorCpf(String cpf) {
        for (ClienteDAO cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public void estacionarVeiculo(VagaDAO vaga, Veiculo veiculo, LocalDateTime entrada) throws VagaInvalidaException {
        if (!vaga.isOcupada()) {
            vaga.ocupar();
            vagasOcupadas.put(veiculo, vaga);
            veiculoClienteMap.put(veiculo, veiculo.getProprietario());
        } else {
            throw new VagaInvalidaException("A vaga já está ocupada.");
        }
    }

    public void liberarVaga(VagaDAO vaga, LocalDateTime saida) {
        vaga.liberar();
        vagasOcupadas.remove(vaga);
    }

    public VagaDAO obterVagaPorIdentificador(String identificador) {
        for (VagaDAO vaga : vagas) {
            if (vaga.getIdentificador().equals(identificador)) {
                return vaga;
            }
        }
        return null;
    }

    public VagaDAO obterVagaPorVeiculo(Veiculo veiculo) {
        return vagasOcupadas.get(veiculo);
    }

    public Veiculo buscarVeiculoPorCliente(ClienteDAO cliente) {
        for (Veiculo veiculo : veiculoClienteMap.keySet()) {
            if (veiculoClienteMap.get(veiculo).equals(cliente)) {
                return veiculo;
            }
        }
        return null;
    }

    public ArrayList<ClienteDAO> listarClientes() {
        return new ArrayList<>(clientes);
    }

    public ArrayList<VagaDAO> listarVagas() {
        return new ArrayList<>(vagas);
    }

    public ArrayList<VagaDAO> getVagas() {
        return vagas;
    }
    
    // Métodos para salvar e carregar dados
    public void salvarDados(String caminhoArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminhoArquivo))) {
            oos.writeObject(this);
        }
    }

    public static ParqueEstacionamento carregarDados(String caminhoArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminhoArquivo))) {
            return (ParqueEstacionamento) ois.readObject();
        }
    }
}
