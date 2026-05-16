public class Compra {
    private int id;
    private int materialId;
    private double peso;
    private double valorTotal;
    private String status;

    public Compra() {
    }

    public Compra(int id, int materialId, double peso, double valorTotal, String status) {
        this.id = id;
        this.materialId = materialId;
        this.peso = peso;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
