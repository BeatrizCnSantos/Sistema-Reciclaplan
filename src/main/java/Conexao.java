import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    // 1. Preencha a URL com o nome do seu banco (ecocash_db)
    private static final String URL = "jdbc:postgresql://localhost:5432/n_ecocash";

    // 2. Preencha o usuário padrão do Postgres
    private static final String USUARIO = "postgres";

    // 3. Coloque a senha que você usa no pgAdmin
    private static final String SENHA = "07161828";

    public static Connection conectar() {
        try {
            // Essa linha é o "pedágio" que abre a estrada
            Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("✅ Conexão estabelecida com sucesso!");
            return conn;
        } catch (SQLException e) {
            System.out.println("❌ Erro ao conectar com o banco: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        conectar();
    }
}
