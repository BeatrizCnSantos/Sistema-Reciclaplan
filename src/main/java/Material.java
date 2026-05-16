public class Material {
    private int id;
    private String nome;
    private double precoQuilo;

    public Material() {
    }

    public Material(int id, double precoQuilo, String nome) {
        this.id = id;
        this.precoQuilo = precoQuilo;
        this.nome = nome;
    }

    public double getPrecoQuilo() {
        return precoQuilo;
    }

    public void setPrecoQuilo(double precoQuilo) {
        this.precoQuilo = precoQuilo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

