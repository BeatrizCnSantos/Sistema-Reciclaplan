import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AtendenteController {

    // Estas variáveis são conectadas magicamente com a tela FXML!
    @FXML private TextField txtMaterialId;
    @FXML private TextField txtPeso;
    @FXML private TextField txtTara;
    @FXML private Label lblMensagem;

    // Instanciamos o DAO que você criou
    private CompraDAO compraDAO = new CompraDAO();

    // Este método é chamado quando a atendente clica no botão "Registrar Compra"
    @FXML
    public void registrar() {
        int materialId = Integer.parseInt(txtMaterialId.getText());
        double peso = Double.parseDouble(txtPeso.getText());
        double tara = Double.parseDouble(txtTara.getText());

        MaterialDAO materialDAO = new MaterialDAO();

        Material materialSelecionado = materialDAO.buscarPorId(materialId);

        double precoReal = materialSelecionado.getPrecoQuilo();
        double pesoLiquido = peso - tara;
        double total = pesoLiquido * precoReal;

        Compra novaCompra = new Compra();

        novaCompra.setMaterialId(materialId);
        novaCompra.setPeso(pesoLiquido);
        novaCompra.setValorTotal(total);
        novaCompra.setStatus("PENDENTE");

        System.out.println("Enviando compra para o banco...");
        compraDAO.salvar(novaCompra);

        lblMensagem.setText("Compra registrada com sucesso!");

        txtMaterialId.clear();
        txtPeso.clear();
        txtTara.clear();
    }
}
