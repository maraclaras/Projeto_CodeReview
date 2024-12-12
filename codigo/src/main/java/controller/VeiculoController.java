package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BancoDados.BancoDados;
import DAO.Cliente;
import DAO.Veiculo;

public class VeiculoController {

    // Adiciona um veículo ao banco de dados
    public boolean adicionarVeiculo(Veiculo veiculo) {
        String sql = "INSERT INTO Veiculo (placa, cliente_cpf) VALUES (?, ?, ?)";

        try (Connection conexao = BancoDados.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, veiculo.getPlaca());
            stmt.setInt(2, veiculo.getProprietario().getcpf());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Veículo adicionado com sucesso!");
                return true;
            } else {
                System.out.println("Falha ao adicionar o veículo.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao adicionar veículo: " + e.getMessage());
        }

        return false;
    }

    // Busca um veículo pelo número da placa
    public Veiculo buscarVeiculo(String placa) {
        String sql = "SELECT v.placa, v.modelo, c.id AS cliente_id, c.nome, c.cpf FROM Veiculo v 
                      JOIN Cliente c ON v.cliente_id = c.id WHERE v.placa = ?";

        try (Connection conexao = BancoDados.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String modelo = rs.getString("modelo");
                int clienteId = rs.getInt("cliente_id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");

                Cliente proprietario = new Cliente(clienteId, nome, cpf);
                return new Veiculo(placa, modelo, proprietario);
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

            if (rowsAffected > 0) {
                System.out.println("Veículo atualizado com sucesso!");
                return true;
            } else {
                System.out.println("Veículo não encontrado.");
            }
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

            if (rowsAffected > 0) {
                System.out.println("Veículo removido com sucesso!");
                return true;
            } else {
                System.out.println("Veículo não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao remover veículo: " + e.getMessage());
        }

        return false;
    }

    // Lista todos os veículos no banco de dados
    public List<Veiculo> listarVeiculos() {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT v.placa, v.modelo, c.id AS cliente_id, c.nome, c.cpf FROM Veiculo v
                      JOIN Cliente c ON v.cliente_id = c.id";

        try (Connection conexao = BancoDados.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String placa = rs.getString("placa");
                String modelo = rs.getString("modelo");
                int clienteId = rs.getInt("cliente_id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");

                Cliente proprietario = new Cliente(clienteId, nome, cpf);
                veiculos.add(new Veiculo(placa, modelo, proprietario));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao listar veículos: " + e.getMessage());
        }

        return veiculos;
    }
}
