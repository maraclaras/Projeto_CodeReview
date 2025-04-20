package DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import modal.ParqueEstacionamento;

public class ClienteDAO implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Veiculo> listaVeiculos;
    public static ArrayList<ClienteDAO> clientes = new ArrayList<>(); 

    public ClienteDAO(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.listaVeiculos = new ArrayList<>();
    }
    
    public static List<ClienteDAO> listarTodosOsClientes() {
        return new ArrayList<>(clientes);
    }

    private static ClienteDAO instancia;

    public void adicionarVeiculo(Veiculo veiculo) {
        listaVeiculos.add(veiculo);
    }

    public List<Veiculo> listarVeiculos() {
        return listaVeiculos;
    }

    public Veiculo buscarVeiculoPorPlaca(String placa) {
        for (Veiculo veiculo : listaVeiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;  // Retorna o veículo caso a placa seja encontrada
            }
        }
        return null;  // Retorna null caso o veículo não seja encontrado
    }

    public static ClienteDAO buscarClientePorCpf(String cpf) {
        for (ClienteDAO cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }   

    
    public ArrayList<ClienteDAO> listarClientes() {
        return new ArrayList<>(clientes);
    }

    public static boolean alterarNomeCliente(String cpf, String novoNome) {
        for (ClienteDAO cliente : listarTodosOsClientes()) {
            if (cliente.getCpf().equals(cpf)) {
                cliente.setNome(novoNome);
                return true; // Retorna verdadeiro se a alteração for feita
            }
        }
        return false; // Retorna falso se o CPF não for encontrado
    }

    public static boolean removerCliente(String cpf) {
        Iterator<ClienteDAO> iterator = clientes.iterator();
        while (iterator.hasNext()) {
            ClienteDAO cliente = iterator.next();
            if (cliente.getCpf().equals(cpf)) {
                iterator.remove(); // Remove o cliente da lista
                return true; // Retorna sucesso
            }
        }
        return false; // Cliente não encontrado
    }

    public static void adicionarCliente(ClienteDAO cliente) {
        clientes.add(cliente);
    }

    
}
