
package model;

public class Material {

    private int id;
    private String nome;
    private double quantidade;

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

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        if (!Double.isFinite(quantidade) || quantidade < 0) {
            throw new IllegalArgumentException(
                "A quantidade deve ser um número válido e não pode ser negativa."
            );
        }

        this.quantidade = quantidade;
    }
}
