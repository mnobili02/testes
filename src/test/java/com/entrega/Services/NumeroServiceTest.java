package com.entrega.Services;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class NumeroServiceTest {

    private final NumeroService numeroService = new NumeroService();

    @Test
    void testSomaLista() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        int resultado = numeroService.somaLista(numeros);
        assertEquals(15, resultado); // 1 + 2 + 3 + 4 + 5 = 15
    }

    @Test
    void testSomaListaVazia() {
        List<Integer> numeros = Arrays.asList();
        int resultado = numeroService.somaLista(numeros);
        assertEquals(0, resultado); // Lista vazia deve retornar 0
    }

    @Test
    void testMaiorMenor() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        int[] resultado = numeroService.maiorMenor(numeros);
        assertArrayEquals(new int[]{5, 1}, resultado); // Maior: 5, Menor: 1
    }

    @Test
    void testMedia() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        double resultado = numeroService.media(numeros);
        assertEquals(3.0, resultado); // Média: (1+2+3+4+5) / 5 = 3.0
    }

    @Test
    void testNumerosRepetidos() {
        List<Integer> numeros = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5);
        Map<Integer, Long> resultado = numeroService.numerosRepetidos(numeros);
        assertEquals(Optional.of(2), resultado.get(2)); // 2 aparece 2 vezes
        assertEquals(Optional.of(3), resultado.get(3)); // 3 aparece 3 vezes
    }
}
