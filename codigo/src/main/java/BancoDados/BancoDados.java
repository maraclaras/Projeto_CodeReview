import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDados {
    private static String usuario = "root";
    
    // atributo para setar a senha do usuário definido pelo atributo anterior:
    private static String senha = "root";
    
    // atributo que especifica o endereço do servidor do banco.
    // se for um servidor remoto, o localhost deve ser substituído pelo
    // endereço IP do servidor do banco
    private static String url = "jdbc:postgresql://localhost:5432/your_database_name";
    
    // atributo que garante uma única conexão com o banco
    // padrão de projeto Singleton:
    private static BancoDados instancia = null;
    
    // atributo que realiza a conexão com o banco:
    private static Connection conexao = null;
    
    // construtor vazio e privado da Classe BancoDados
    // para nao permitir a instancia de multiplos objetos
    // faz parte do padrão Singleton
    private BancoDados() {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static BancoDados getInstancia() {
        if (instancia == null) {
            instancia = new BancoDados();
        }
        return instancia;
    }
    
    public Connection getConexao() {
        return conexao;
    }
}