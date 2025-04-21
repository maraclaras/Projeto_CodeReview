package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BancoDados.BancoDados;
import DTO.ClienteDTO;
import DTO.ClientePCDDTO;
import DTO.ClienteVIPDTO;

public class ClienteController {

    // Adiciona um cliente no banco de dados
    public void adicionarCliente(ClienteDTO cliente) {
        String sql = "INSERT INTO Cliente (id, nome, email) VALUES (?, ?, ?)";

        try (Connection conexao = BancoDados.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setLong(1, cliente.getId());
            stmt.setString(2, cliente.getName());
            stmt.setString(3, cliente.getEmail());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Cliente adicionado com sucesso!");
            } else {
                System.out.println("Falha ao adicionar o cliente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao adicionar cliente: " + e.getMessage());
        }
    }

    // Busca um cliente no banco de dados pelo ID
    public ClienteDTO buscarCliente(Long id) {
        String sql = "SELECT * FROM Cliente WHERE id = ?";

        try (Connection conexao = BancoDados.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("nome");
                String email = rs.getString("email");
                return new ClienteVIPDTO(id, name, email); // Exemplo com ClienteVIPDTO
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar cliente: " + e.getMessage());
        }

        return null; // Retorna null se o cliente não for encontrado
    }

    // Altera um cliente existente no banco de dados
    public boolean alterarCliente(Long id, String novoNome) {
        String sql = "UPDATE Cliente SET nome = ? WHERE id = ?";

        try (Connection conexao = BancoDados.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, novoNome);
            stmt.setLong(2, id);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Cliente atualizado com sucesso!");
                return true;
            } else {
                System.out.println("Cliente não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao alterar cliente: " + e.getMessage());
        }

        return false;
    }

    // Remove um cliente do banco de dados pelo ID
    public boolean removerCliente(Long id) {
        String sql = "DELETE FROM Cliente WHERE id = ?";

        try (Connection conexao = BancoDados.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setLong(1, id);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Cliente removido com sucesso!");
                return true;
            } else {
                System.out.println("Cliente não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao remover cliente: " + e.getMessage());
        }

        return false;
    }

    // Lista todos os clientes no banco de dados
    public List<ClienteDTO> listarClientes() {
        List<ClienteDTO> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";

        try (Connection conexao = BancoDados.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("nome");
                String email = rs.getString("email");
                clientes.add(new ClientePCDDTO(id, name, email)); // Exemplo com ClientePCDDTO
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao listar clientes: " + e.getMessage());
        }

        return clientes;
    }
}