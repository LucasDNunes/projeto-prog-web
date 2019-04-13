package br.unisul.progweb.domain.categoria;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CategoriaTest {

    @Test
    public void testCreate() {
        Categoria categoria = Categoria.builder()
                .nome("teste")
                .build();

        assertNotNull(categoria);
        assertEquals("teste", categoria.getNome());
    }

}