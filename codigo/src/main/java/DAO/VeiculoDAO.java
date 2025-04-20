package DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VeiculoDAO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String placa;
    private String modelo;
    private String proprietarioCpf; // CPF do proprietário do veículo
    private static final List<VeiculoDAO> veiculos = new ArrayList<>();

    // Construtor
    public VeiculoDAO(String placa, String modelo, String proprietarioCpf) {
        this.placa = placa;
        this.modelo = modelo;
        this.proprietarioCpf = proprietarioCpf;
    }

    // Adiciona um veículo à lista
    public static void adicionarVeiculo(VeiculoDAO veiculo) {
        veiculos.add(veiculo);
    }

    // Lista todos os veículos
    public static List<VeiculoDAO> listarTodosOsVeiculos() {
        return new ArrayList<>(veiculos);
    }

    // Busca um veículo pela placa
    public static VeiculoDAO buscarVeiculoPorPlaca(String placa) {
        for (VeiculoDAO veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    // Altera o modelo de um veículo pela placa
    public static boolean alterarModeloVeiculo(String placa, String novoModelo) {
        VeiculoDAO veiculo = buscarVeiculoPorPlaca(placa);
        if (veiculo != null) {
            veiculo.setModelo(novoModelo);
            return true;
        }
        return false;
    }

    // Remove um veículo pela placa
    public static boolean removerVeiculo(String placa) {
        Iterator<VeiculoDAO> iterator = veiculos.iterator();
        while (iterator.hasNext()) {
            VeiculoDAO veiculo = iterator.next();
            if (veiculo.getPlaca().equals(placa)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    // Getters e Setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getProprietarioCpf() {
        return proprietarioCpf;
    }

    public void setProprietarioCpf(String proprietarioCpf) {
        this.proprietarioCpf = proprietarioCpf;
    }

    @Override
    public String toString() {
        return "VeiculoDAO{" +
                "placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", proprietarioCpf='" + proprietarioCpf + '\'' +
                '}';
    }
}