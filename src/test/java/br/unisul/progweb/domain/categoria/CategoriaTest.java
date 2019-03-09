package br.unisul.progweb.domain.categoria;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CategoriaTest {

    @Test
    public void testCreate() {
        Categoria categoria = Categoria.builder()
                .id(1L)
                .nome("teste")
                .build();

        assertNotNull(categoria);
        assertEquals(1L, categoria.getId().longValue());
        assertEquals("teste", categoria.getNome());
    }

}