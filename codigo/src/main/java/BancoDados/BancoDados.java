package BancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BancoDados {
    // Atributos para configuração do banco
    private static final String BANCO = "estacionamento";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";
    private static final String URL = "jdbc:mariadb://localhost:3306/" + BANCO;

    // Construtor privado para impedir instâncias externas
    private BancoDados() {}

    // Método para criar e retornar uma nova conexão
    public static Connection getConexao() {
        try {
            // Retorna uma nova conexão para cada chamada
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, "Erro ao conectar ao banco de dados!", ex);
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + ex.getMessage());
        }
    }

    // Método para encerrar uma conexão específica
    public static void desconectar(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Conexão encerrada com sucesso!");
            } catch (SQLException ex) {
                Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, "Erro ao fechar a conexão!", ex);
            }
        }
    }

    
}
    
