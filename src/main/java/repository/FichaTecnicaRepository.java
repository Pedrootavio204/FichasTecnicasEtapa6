
package repository;

import model.FichaTecnicaDetalhe;
import com.br.senac.util.Conexao;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FichaTecnicaRepository {

    public FichaTecnicaDetalhe buscarPorId(int idFicha)
            throws SQLException {

        String sql = """
            SELECT id_ficha_tecnica,
                   composicao_tecido,
                   tipo_costura,
                   processo_fabricacao
            FROM ficha_tecnica
            WHERE id_ficha_tecnica = ?
            """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idFicha);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    FichaTecnicaDetalhe ficha =
                            new FichaTecnicaDetalhe();

                    ficha.setIdFichaTecnica(
                        rs.getInt("id_ficha_tecnica")
                    );

                    ficha.setComposicaoTecido(
                        rs.getString("composicao_tecido")
                    );

                    ficha.setTipoCostura(
                        rs.getString("tipo_costura")
                    );

                    ficha.setProcessoFabricacao(
                        rs.getString("processo_fabricacao")
                    );

                    return ficha;
                }
            }
        }

        return null;
    }
    
    public int criarEVincularAoProduto(int idProduto)
            throws SQLException {

        String consultarProduto = """
            SELECT id_ficha_tecnica
            FROM produto
            WHERE id_produto = ?
            FOR UPDATE
            """;

        String inserirFicha = """
            INSERT INTO ficha_tecnica
            (composicao_tecido, tipo_costura, processo_fabricacao)
            VALUES ('', '', '')
            """;

        String atualizarProduto = """
            UPDATE produto
            SET id_ficha_tecnica = ?
            WHERE id_produto = ?
            """;

        try (Connection conn = Conexao.conectar()) {

            conn.setAutoCommit(false);

            try {
                try (PreparedStatement ps =
                        conn.prepareStatement(consultarProduto)) {

                    ps.setInt(1, idProduto);

                    try (ResultSet rs = ps.executeQuery()) {

                        if (!rs.next()) {
                            throw new SQLException(
                                "Produto não encontrado: " + idProduto
                            );
                        }

                        int idExistente = rs.getInt("id_ficha_tecnica");

                        if (!rs.wasNull()) {
                            conn.commit();
                            return idExistente;
                        }
                    }
                }

                int novoIdFicha;

                try (PreparedStatement ps =
                        conn.prepareStatement(
                            inserirFicha,
                            Statement.RETURN_GENERATED_KEYS)) {

                    ps.executeUpdate();

                    try (ResultSet rs = ps.getGeneratedKeys()) {

                        if (!rs.next()) {
                            throw new SQLException(
                                "Não foi possível obter o ID da ficha."
                            );
                        }

                        novoIdFicha = rs.getInt(1);
                    }
                }

                try (PreparedStatement ps =
                        conn.prepareStatement(atualizarProduto)) {

                    ps.setInt(1, novoIdFicha);
                    ps.setInt(2, idProduto);

                    if (ps.executeUpdate() != 1) {
                        throw new SQLException(
                            "Não foi possível vincular a ficha."
                        );
                    }
                }

                conn.commit();
                return novoIdFicha;

            } catch (SQLException | RuntimeException e) {
                conn.rollback();
                throw e;
            }
        }
    }
   
    public void atualizar(FichaTecnicaDetalhe ficha)
            throws SQLException {

        String sql = """
            UPDATE ficha_tecnica
            SET composicao_tecido = ?,
                tipo_costura = ?,
                processo_fabricacao = ?
            WHERE id_ficha_tecnica = ?
            """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, ficha.getComposicaoTecido());
            ps.setString(2, ficha.getTipoCostura());
            ps.setString(3, ficha.getProcessoFabricacao());
            ps.setInt(4, ficha.getIdFichaTecnica());

            int linhasAtualizadas = ps.executeUpdate();

            if (linhasAtualizadas == 0) {
                throw new SQLException(
                    "Ficha técnica não encontrada para atualização."
                );
            }
        }
    }
}
