package DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import modal.ParqueEstacionamento;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String cpf;
    private List<Veiculo> listaVeiculos;
    public static ArrayList<Cliente> clientes = new ArrayList<>(); 

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.listaVeiculos = new ArrayList<>();
    }
    
    public static List<Cliente> listarTodosOsClientes() {
        return new ArrayList<>(clientes);
    }

    private static Cliente instancia;

    public void adicionarVeiculo(Veiculo veiculo) {
        listaVeiculos.add(veiculo);
    }

    public List<Veiculo> listarVeiculos() {
        return listaVeiculos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Veiculo buscarVeiculoPorPlaca(String placa) {
        for (Veiculo veiculo : listaVeiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;  // Retorna o veículo caso a placa seja encontrada
            }
        }
        return null;  // Retorna null caso o veículo não seja encontrado
    }

    public static Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }   

    
    public ArrayList<Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }

    public static boolean alterarNomeCliente(String cpf, String novoNome) {
        for (Cliente cliente : listarTodosOsClientes()) {
            if (cliente.getCpf().equals(cpf)) {
                cliente.setNome(novoNome);
                return true; // Retorna verdadeiro se a alteração for feita
            }
        }
        return false; // Retorna falso se o CPF não for encontrado
    }

    public static boolean removerCliente(String cpf) {
        Iterator<Cliente> iterator = clientes.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getCpf().equals(cpf)) {
                iterator.remove(); // Remove o cliente da lista
                return true; // Retorna sucesso
            }
        }
        return false; // Cliente não encontrado
    }

    public static void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    
}
