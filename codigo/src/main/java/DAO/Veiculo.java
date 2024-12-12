package DAO;

import java.io.Serializable;
import BancoDados.BancoDados;

public class Veiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String placa;
    private String modelo;
    private Cliente proprietario;

    // Construtor que inicializa a placa e o modelo
    public Veiculo(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
        this.proprietario = null; // Inicialmente, o veículo não tem proprietário
    }

    // Construtor que inicializa apenas a placa
    public Veiculo(String placa) {
        this.placa = placa;
    }

    // Novo construtor que inicializa a placa e o proprietário
    public Veiculo(String placa, Cliente proprietario) {
        this.placa = placa;
        this.proprietario = proprietario;
        proprietario.adicionarVeiculo(this); // Vincula o veículo ao cliente
    }

    // Getter para o modelo
    public String getModelo() {
        return modelo;
    }

    // Getter para a placa
    public String getPlaca() {
        return placa;
    }

    // Getter para o proprietário
    public Cliente getProprietario() {
        return proprietario;
    }

    // Método para vincular o cliente (proprietário) ao veículo
    public void vincularCliente(Cliente cliente) {
        this.proprietario = cliente;
        cliente.adicionarVeiculo(this); // Vincula o veículo ao cliente
    }

    @Override
    public String toString() {
        return "Veículo com placa: " + placa;
    }
}