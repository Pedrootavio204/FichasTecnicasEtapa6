
package model;

public class FichaTecnicaDetalhe {

    private int idFichaTecnica;
    private String composicaoTecido;
    private String tipoCostura;
    private String processoFabricacao;

    public int getIdFichaTecnica() {
        return idFichaTecnica;
    }

    public void setIdFichaTecnica(int idFichaTecnica) {
        this.idFichaTecnica = idFichaTecnica;
    }

    public String getComposicaoTecido() {
        return composicaoTecido;
    }

    public void setComposicaoTecido(String composicaoTecido) {
        this.composicaoTecido = composicaoTecido;
    }

    public String getTipoCostura() {
        return tipoCostura;
    }

    public void setTipoCostura(String tipoCostura) {
        this.tipoCostura = tipoCostura;
    }

    public String getProcessoFabricacao() {
        return processoFabricacao;
    }

    public void setProcessoFabricacao(String processoFabricacao) {
        this.processoFabricacao = processoFabricacao;
    }
}
