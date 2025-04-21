package controller;

import java.util.List;

import DAO.VeiculoDAO;
import DTO.VeiculoDTO;

public class VeiculoController {

    private VeiculoDAO veiculoDAO;

    // Construtor que inicializa o DAO
    public VeiculoController() {
        this.veiculoDAO = new VeiculoDAO();
    }

    // Adiciona um veículo
    public boolean adicionarVeiculo(VeiculoDTO veiculo, String cpfProprietario) {
        if (veiculo.getPlaca() == null || veiculo.getPlaca().isEmpty()) {
            System.out.println("Erro: A placa do veículo não pode ser vazia.");
            return false;
        }
        if (cpfProprietario == null || cpfProprietario.isEmpty()) {
            System.out.println("Erro: O CPF do proprietário não pode ser vazio.");
            return false;
        }
        return veiculoDAO.adicionarVeiculo(veiculo, cpfProprietario);
    }

    // Busca um veículo pelo número da placa
    public VeiculoDTO buscarVeiculo(String placa) {
        if (placa == null || placa.isEmpty()) {
            System.out.println("Erro: A placa do veículo não pode ser vazia.");
            return null;
        }
        return veiculoDAO.buscarVeiculo(placa);
    }

    // Atualiza as informações de um veículo
    public boolean alterarVeiculo(String placa, String novoModelo) {
        if (placa == null || placa.isEmpty()) {
            System.out.println("Erro: A placa do veículo não pode ser vazia.");
            return false;
        }
        if (novoModelo == null || novoModelo.isEmpty()) {
            System.out.println("Erro: O novo modelo do veículo não pode ser vazio.");
            return false;
        }
        return veiculoDAO.alterarVeiculo(placa, novoModelo);
    }

    // Remove um veículo do banco de dados pela placa
    public boolean removerVeiculo(String placa) {
        if (placa == null || placa.isEmpty()) {
            System.out.println("Erro: A placa do veículo não pode ser vazia.");
            return false;
        }
        return veiculoDAO.removerVeiculo(placa);
    }

    // Lista todos os veículos
    public List<VeiculoDTO> listarVeiculos() {
        return veiculoDAO.listarVeiculos();
    }
}