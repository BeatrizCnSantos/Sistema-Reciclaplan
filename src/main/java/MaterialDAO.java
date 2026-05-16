import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO {

    public List<Material> listarTodos() {

        List<Material> lista = new ArrayList<>();
        String sql = "SELECT * FROM materiais";

        try {
            Connection conn = Conexao.conectar();

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco_quilo");

                Material material = new Material(id, preco, nome);

                // Colocamos o objeto pronto dentro da nossa lista
                lista.add(material);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erro ao buscar materiais: " + e.getMessage());
        }

        return lista;
    }

    // Método novo dentro do MaterialDAO!
    public Material buscarPorId(int idBusca) {
        Material materialEncontrado = null;

        // O SQL agora filtra pelo ID!
        String sql = "SELECT * FROM materiais WHERE id = ?";

        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idBusca);


            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco_quilo");

                materialEncontrado = new Material(id, preco, nome);

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erro ao buscar material por ID: " + e.getMessage());
        }

        return materialEncontrado; // Retorna o material pronto (ou null se não achar nada)
    }

    // Coloque isso antes do último '}' da classe MaterialDAO
    public static void main(String[] args) {
        MaterialDAO dao = new MaterialDAO();
        List<Material> meusMateriais = dao.listarTodos();

        System.out.println("Materiais encontrados no banco:");
        for (Material m : meusMateriais) {
            System.out.println(m.getId() + " - " + m.getNome() + " - R$ " + m.getPrecoQuilo());
        }
    }
}