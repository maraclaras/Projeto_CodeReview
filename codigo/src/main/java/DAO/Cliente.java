package DAO;

import exceptions.VeiculoNaoEncontradoException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String cpf;
    private List<Veiculo> listaVeiculos;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.listaVeiculos = new ArrayList<>();
    }

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
                return veiculo;
            }
        }
        // Lançando a exceção personalizada caso o veículo não seja encontrado
        throw new VeiculoNaoEncontradoException("Veículo com placa " + placa + " não encontrado.");
    }
<<<<<<< HEAD:codigo/src/main/java/modal/Cliente.java
}

=======
}
>>>>>>> ba7344d988a0f8b94ec8d5966a8aa1b5621ba9d4:codigo/src/main/java/DAO/Cliente.java
