
package com.br.senac.service;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import service.ProdutoService;

public class ProdutoServiceTest {

    @Test
    public void deveConverterDataValida() {

        ProdutoService service = new ProdutoService(null);

        LocalDate resultado =
                service.converterData("24/10/2026");

        LocalDate esperado = LocalDate.of(2026, 10, 24);

        assertEquals(esperado, resultado);
    }

    @Test
    public void deveRejeitarDataInvalida() {

        ProdutoService service = new ProdutoService(null);

        assertThrows(
                IllegalArgumentException.class,
                () -> service.converterData("31/02/2026")
        );
    }
}
