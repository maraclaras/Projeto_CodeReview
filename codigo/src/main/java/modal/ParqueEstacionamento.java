package modal;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import exceptions.VagaInvalidaException;

public class ParqueEstacionamento implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Cliente> clientes;
    private HashMap<Veiculo, Cliente> veiculoClienteMap;
    private HashMap<Veiculo, Vaga> vagasOcupadas;
    private ArrayList<Vaga> vagas;

    public ParqueEstacionamento(int numFilas, int numVagasPorFila) {
        clientes = new ArrayList<>();
        vagas = new ArrayList<>();
        vagasOcupadas = new HashMap<>();
        veiculoClienteMap = new HashMap<>();

        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numVagasPorFila; j++) {
                String identificador = String.format("%c%02d", 'A' + i, j + 1);
                try {
                    vagas.add(new Vaga(identificador, numFilas * numVagasPorFila));
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
        return null;
    }

    public void estacionarVeiculo(Vaga vaga, Veiculo veiculo, LocalDateTime entrada) throws VagaInvalidaException {
        if (!vaga.isOcupada()) {
            vaga.ocupar();
            vagasOcupadas.put(veiculo, vaga);
            veiculoClienteMap.put(veiculo, veiculo.getProprietario());
        } else {
            throw new VagaInvalidaException("A vaga já está ocupada.");
        }
    }

    public void liberarVaga(Vaga vaga, LocalDateTime saida) {
        vaga.liberar();
        vagasOcupadas.remove(vaga);
    }

    public Vaga obterVagaPorIdentificador(String identificador) {
        for (Vaga vaga : vagas) {
            if (vaga.getIdentificador().equals(identificador)) {
                return vaga;
            }
        }
        return null;
    }

    public Vaga obterVagaPorVeiculo(Veiculo veiculo) {
        return vagasOcupadas.get(veiculo);
    }

    public Veiculo buscarVeiculoPorCliente(Cliente cliente) {
        for (Veiculo veiculo : veiculoClienteMap.keySet()) {
            if (veiculoClienteMap.get(veiculo).equals(cliente)) {
                return veiculo;
            }
        }
        return null;
    }

    public ArrayList<Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }

    public ArrayList<Vaga> listarVagas() {
        return new ArrayList<>(vagas);
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