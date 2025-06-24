
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
    private static final String URL = "jdbc:sqlite:pontuacoes.db";

    public static void conectar() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC"); // Carrega o driver JDBC do SQLite
            conn = DriverManager.getConnection(URL);
            if (conn != null) {
                System.out.println("Conexão com o banco de dados SQLite estabelecida.");
                criarTabela(conn);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC do SQLite não encontrado: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void criarTabela(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS pontuacoes (\n" +
                "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    nome_jogador VARCHAR(255) NOT NULL,\n" +
                "    pontuacao INTEGER NOT NULL,\n" +
                "    data DATETIME DEFAULT CURRENT_TIMESTAMP\n" +
                ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela 'pontuacoes' criada ou já existe.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void salvar(String nome, int pontos) {
        String sql = "INSERT INTO pontuacoes(nome_jogador, pontuacao) VALUES(?,?)";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setInt(2, pontos);
            pstmt.executeUpdate();
            System.out.println("Pontuação de " + nome + " salva: " + pontos);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<String> lerTop5Pontuacoes() {
        List<String> top5 = new ArrayList<>();
        String sql = "SELECT nome_jogador, pontuacao, data FROM pontuacoes ORDER BY pontuacao DESC LIMIT 5";
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                top5.add("Nome: " + rs.getString("nome_jogador") +
                        " | Pontos: " + rs.getInt("pontuacao") +
                        " | Data: " + rs.getString("data"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return top5;
    }


    public static void apagarTudo() {
        String sql = "DELETE FROM pontuacoes";
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Todas as pontuações foram apagadas.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

