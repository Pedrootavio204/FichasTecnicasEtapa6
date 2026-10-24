
package model;

public class Processo {

    private int id;
    private String nome;
    private double tempo;

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

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        if (!Double.isFinite(tempo) || tempo < 0) {
            throw new IllegalArgumentException(
                "O tempo do processo deve ser válido e não pode ser negativo."
            );
        }

        this.tempo = tempo;
    }
}
