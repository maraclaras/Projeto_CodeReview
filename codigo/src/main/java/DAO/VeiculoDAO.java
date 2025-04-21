package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BancoDados.BancoDados;
import DTO.VeiculoDTO;

public class VeiculoDAO {

    // Adiciona um veículo ao banco de dados
    public boolean adicionarVeiculo(VeiculoDTO veiculo, String cpfProprietario) {
        String sql = "INSERT INTO Veiculo (placa, modelo, cliente_cpf) VALUES (?, ?, ?)";

        try (Connection conexao = BancoDados.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setString(3, cpfProprietario);

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao adicionar veículo: " + e.getMessage());
        }

        return false;
    }

    // Busca um veículo pelo número da placa
    public VeiculoDTO buscarVeiculo(String placa) {
        String sql = "SELECT v.placa, v.modelo, c.nome AS proprietario_nome FROM Veiculo v " +
                     "JOIN Cliente c ON v.cliente_cpf = c.cpf WHERE v.placa = ?";

        try (Connection conexao = BancoDados.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String modelo = rs.getString("modelo");
                String proprietarioNome = rs.getString("proprietario_nome");
                return new VeiculoDTO(placa, modelo, proprietarioNome);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar veículo: " + e.getMessage());
        }

        return null;
    }

    // Atualiza as informações de um veículo
    public boolean alterarVeiculo(String placa, String novoModelo) {
        String sql = "UPDATE Veiculo SET modelo = ? WHERE placa = ?";

        try (Connection conexao = BancoDados.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, novoModelo);
            stmt.setString(2, placa);

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao alterar veículo: " + e.getMessage());
        }

        return false;
    }

    // Remove um veículo do banco de dados pela placa
    public boolean removerVeiculo(String placa) {
        String sql = "DELETE FROM Veiculo WHERE placa = ?";

        try (Connection conexao = BancoDados.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, placa);

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao remover veículo: " + e.getMessage());
        }

        return false;
    }

    // Lista todos os veículos no banco de dados
    public List<VeiculoDTO> listarVeiculos() {
        List<VeiculoDTO> veiculos = new ArrayList<>();
        String sql = "SELECT v.placa, v.modelo, c.nome AS proprietario_nome FROM Veiculo v " +
                     "JOIN Cliente c ON v.cliente_cpf = c.cpf";

        try (Connection conexao = BancoDados.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String placa = rs.getString("placa");
                String modelo = rs.getString("modelo");
                String proprietarioNome = rs.getString("proprietario_nome");

                veiculos.add(new VeiculoDTO(placa, modelo, proprietarioNome));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao listar veículos: " + e.getMessage());
        }

        return veiculos;
    }
}