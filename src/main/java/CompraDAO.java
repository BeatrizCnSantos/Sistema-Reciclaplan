import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompraDAO {

    public void salvar(Compra compra) {
        // O comando SQL com 4 interrogações (uma para cada valor que vamos inserir)
        String sql = "INSERT INTO compras (material_id, peso, valor_total, status) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, compra.getMaterialId());
            stmt.setDouble(2, compra.getPeso());
            stmt.setDouble(3, compra.getValorTotal());
            stmt.setString(4, compra.getStatus());

            stmt.executeUpdate();

            // Fechando as portas
            stmt.close();
            conn.close();
            System.out.println("✅ Compra salva no banco com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao salvar compra: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        // 1. Criamos um objeto DAO
        CompraDAO dao = new CompraDAO();

        // 2. Criamos uma compra "falsa" para testar
        Compra novaCompra = new Compra();
        novaCompra.setMaterialId(1); // O ID 1 é a Latinha que tá no seu banco
        novaCompra.setPeso(10.5);    // 10 quilos e meio
        novaCompra.setValorTotal(68.25); // 10.5 * 6.50
        novaCompra.setStatus("PENDENTE");

        // 3. Mandamos salvar!
        System.out.println("Enviando compra para o banco...");
        dao.salvar(novaCompra);
    }
}
