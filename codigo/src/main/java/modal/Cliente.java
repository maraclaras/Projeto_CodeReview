package modal;

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
                return veiculo;  // Retorna o veículo caso a placa seja encontrada
            }
        }
        return null;  // Retorna null caso o veículo não seja encontrado
    }
}
