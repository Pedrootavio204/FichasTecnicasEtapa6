
package repository;

import model.Produto;
import com.br.senac.util.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {

    public List<Produto> listarTodos() throws SQLException {
        List<Produto> produtos = new ArrayList<>();

        String sql = "SELECT * FROM produto";

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                produtos.add(converterProduto(rs));
            }
        }

        return produtos;
    }

    public List<Produto> buscar(String texto) throws SQLException {
        List<Produto> produtos = new ArrayList<>();

        String sql = """
            SELECT * FROM produto
            WHERE nome LIKE ?
               OR categoria LIKE ?
               OR tipo_tecido LIKE ?
               OR observacoes LIKE ?
            """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            String filtro = "%" + texto + "%";

            for (int i = 1; i <= 4; i++) {
                ps.setString(i, filtro);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    produtos.add(converterProduto(rs));
                }
            }
        }

        return produtos;
    }

    public void salvar(Produto produto) throws SQLException {

        String sql = """
            INSERT INTO produto
            (nome, categoria, tipo_tecido,
             id_ficha_tecnica, data_fechamento, observacoes)
            VALUES (?, ?, ?, ?, ?, ?)
            """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getCategoria());
            ps.setString(3, produto.getTipoTecido());

            if (produto.getIdFichaTecnica() == null) {
                ps.setNull(4, Types.INTEGER);
            } else {
                ps.setInt(4, produto.getIdFichaTecnica());
            }

            if (produto.getDataFechamento() == null) {
                ps.setNull(5, Types.DATE);
            } else {
                ps.setDate(5, Date.valueOf(produto.getDataFechamento()));
            }

            ps.setString(6, produto.getObservacoes());

            ps.executeUpdate();
        }
    }

    private Produto converterProduto(ResultSet rs)
            throws SQLException {

        Produto produto = new Produto();

        produto.setIdProduto(rs.getInt("id_produto"));
        produto.setNome(rs.getString("nome"));
        produto.setCategoria(rs.getString("categoria"));
        produto.setTipoTecido(rs.getString("tipo_tecido"));

        int idFicha = rs.getInt("id_ficha_tecnica");
        produto.setIdFichaTecnica(
            rs.wasNull() ? null : idFicha
        );

        Date data = rs.getDate("data_fechamento");

        if (data != null) {
            produto.setDataFechamento(data.toLocalDate());
        }

        produto.setObservacoes(rs.getString("observacoes"));

        return produto;
    }
    
    
public Produto buscarPorId(int id) throws SQLException {

    String sql = "SELECT * FROM produto WHERE id_produto = ?";

    try (Connection conn = Conexao.conectar();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, id);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return converterProduto(rs);
            }
        }
    }

    return null;
}

}
