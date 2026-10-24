
package model;

import java.util.ArrayList;
import java.util.List;

public class FichaTecnica {

    private int id;
    private String nome;
    private String descricao;
    private List<String> processos = new ArrayList<>();

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<String> getProcessos() {
        return new ArrayList<>(processos);
    }

    public void setProcessos(List<String> processos) {
        this.processos = processos == null
                ? new ArrayList<>()
                : new ArrayList<>(processos);
    }
}
