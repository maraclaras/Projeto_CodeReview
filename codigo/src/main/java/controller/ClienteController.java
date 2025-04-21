package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BancoDados.BancoDados;
import DAO.ClienteDAO;
import DTO.ParqueEstacionamentoDAO;
import DTO.VeiculoDTO;

public class ClienteController {

    private ParqueEstacionamentoDAO estacionamento;
    private Scanner leitor;

    // Construtor que recebe ParqueEstacionamento e Scanner
    public ClienteController(ParqueEstacionamentoDAO estacionamento, Scanner leitor) {
        this.estacionamento = estacionamento;
        this.leitor = leitor;
    }

    // Adiciona um cliente no banco de dados
    public void adicionarCliente(ClienteDAO cliente) {
        String sql = "INSERT INTO Cliente (nome, cpf) VALUES (?, ?)";
    
        try (Connection conexao = BancoDados.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
    
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
    
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

    // Busca um cliente no banco de dados pelo CPF
    public ClienteDAO buscarCliente(String cpf) {
        String sql = "SELECT * FROM Cliente WHERE cpf = ?";

        try (Connection conexao = BancoDados.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                return new ClienteDAO(nome, cpf);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar cliente: " + e.getMessage());
        }

        return null; // Retorna null se o cliente não for encontrado
    }

    // Altera um cliente existente no banco de dados
    public boolean alterarCliente(String cpf, String novoNome) {
        String sql = "UPDATE Cliente SET nome = ? WHERE cpf = ?";

        try (Connection conexao = BancoDados.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, novoNome);
            stmt.setString(2, cpf);

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

    // Remove um cliente do banco de dados pelo CPF
    public boolean removerCliente(String cpf) {
        String sql = "DELETE FROM Cliente WHERE cpf = ?";

        try (Connection conexao = BancoDados.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cpf);

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
    public List<ClienteDAO> listarClientes() {
        List<ClienteDAO> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";

        try (Connection conexao = BancoDados.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                clientes.add(new ClienteDAO(nome, cpf));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao listar clientes: " + e.getMessage());
        }

        return clientes;
    }

    // Adiciona um veículo ao cliente no banco de dados
    public boolean adicionarVeiculo(String cpf, Veiculo veiculo) {
        String sql = "INSERT INTO Veiculo (placa, modelo, cpf_cliente) VALUES (?, ?, ?)";

        try (Connection conexao = BancoDados.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setString(3, cpf);

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
}
