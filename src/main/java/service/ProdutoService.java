package service;

import model.Produto;
import repository.ProdutoRepository;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.List;

public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listarTodos() throws SQLException {
        return repository.listarTodos();
    }

    public List<Produto> buscar(String texto) throws SQLException {
        if (texto == null || texto.isBlank()) {
            return repository.listarTodos();
        }

        return repository.buscar(texto.trim());
    }

    public void salvar(Produto produto) throws SQLException {

        if (produto == null) {
            throw new IllegalArgumentException(
                "O produto não pode ser nulo."
            );
        }

        validarTexto(produto.getNome(), "Nome", true);
        validarTexto(produto.getCategoria(), "Categoria", true);
        validarTexto(produto.getTipoTecido(), "Tipo de tecido", true);
        validarTexto(produto.getObservacoes(), "Observações", false);

        if (produto.getIdFichaTecnica() != null
                && produto.getIdFichaTecnica() <= 0) {
            throw new IllegalArgumentException(
                "O ID da ficha técnica deve ser positivo."
            );
        }

        repository.salvar(produto);
    }

    private void validarTexto(
            String valor, String campo, boolean obrigatorio) {

        if (valor == null || valor.isBlank()) {
            if (obrigatorio) {
                throw new IllegalArgumentException(
                    campo + " é obrigatório."
                );
            }
            return;
        }

        if (valor.trim().length() > 45) {
            throw new IllegalArgumentException(
                campo + " deve ter no máximo 45 caracteres."
            );
        }
    }

    public LocalDate converterData(String dataTexto) {

        if (dataTexto == null || dataTexto.isBlank()) {
            return null;
        }

        try {
            DateTimeFormatter formato =
                DateTimeFormatter.ofPattern("dd/MM/uuuu")
                    .withResolverStyle(ResolverStyle.STRICT);

            return LocalDate.parse(dataTexto.trim(), formato);

        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(
                "Data inválida. Utilize o formato dd/MM/aaaa."
            );
        }
    }
    
    public Produto buscarPorId(int id) throws SQLException {

        if (id <= 0) {
            throw new IllegalArgumentException(
                "O ID do produto deve ser positivo."
            );
        }

        return repository.buscarPorId(id);
    }
}
