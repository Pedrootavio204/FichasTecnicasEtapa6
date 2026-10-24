
package service;

import model.FichaTecnicaDetalhe;
import repository.FichaTecnicaRepository;
import java.sql.SQLException;
import model.FichaTecnicaDetalhe;
import java.sql.SQLException;

public class FichaTecnicaService {

    private final FichaTecnicaRepository repository;

    public FichaTecnicaService(
            FichaTecnicaRepository repository) {
        this.repository = repository;
    }

    public FichaTecnicaDetalhe buscarPorId(int idFicha)
            throws SQLException {

        if (idFicha <= 0) {
            throw new IllegalArgumentException(
                "O ID da ficha técnica deve ser positivo."
            );
        }

        return repository.buscarPorId(idFicha);
    }

    public int obterOuCriarFicha(int idProduto)
            throws SQLException {

        if (idProduto <= 0) {
            throw new IllegalArgumentException(
                "O ID do produto deve ser positivo."
            );
        }

        return repository.criarEVincularAoProduto(idProduto);
    }
     
    public void atualizar(FichaTecnicaDetalhe ficha)
            throws SQLException {

        if (ficha == null) {
            throw new IllegalArgumentException(
                "Os dados da ficha técnica são obrigatórios."
            );
        }

        if (ficha.getIdFichaTecnica() <= 0) {
            throw new IllegalArgumentException(
                "O ID da ficha técnica é inválido."
            );
        }

        if (ficha.getComposicaoTecido() == null
                || ficha.getComposicaoTecido().isBlank()) {
            throw new IllegalArgumentException(
                "A composição do tecido é obrigatória."
            );
        }

        if (ficha.getTipoCostura() == null
                || ficha.getTipoCostura().isBlank()) {
            throw new IllegalArgumentException(
                "O tipo de costura é obrigatório."
            );
        }

        if (ficha.getProcessoFabricacao() == null
                || ficha.getProcessoFabricacao().isBlank()) {
            throw new IllegalArgumentException(
                "O processo de fabricação é obrigatório."
            );
        }

        ficha.setComposicaoTecido(
            ficha.getComposicaoTecido().trim()
        );

        ficha.setTipoCostura(
            ficha.getTipoCostura().trim()
        );

        ficha.setProcessoFabricacao(
            ficha.getProcessoFabricacao().trim()
        );

        repository.atualizar(ficha);
    }
}
