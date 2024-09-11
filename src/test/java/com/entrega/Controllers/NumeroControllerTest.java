package com.entrega.Controllers;

import com.entrega.Services.NumeroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NumeroController.class)
class NumeroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NumeroService numeroService;

    @Test
    void testSomaListaEndpoint() throws Exception {
        when(numeroService.somaLista(Arrays.asList(1, 2, 3))).thenReturn(6);

        mockMvc.perform(get("/calc/somaLista")
                        .param("numeros", "1", "2", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("6")); // 1 + 2 + 3 = 6
    }

    @Test
    void testMaiorMenorEndpoint() throws Exception {
        when(numeroService.maiorMenor(Arrays.asList(1, 2, 3, 4, 5))).thenReturn(new int[]{5, 1});

        mockMvc.perform(get("/calc/maiorMenor").param("numeros", "1", "2", "3", "4", "5"))
                .andExpect(status().isOk())
                .andExpect(content().json("[5, 1]")); // Maior: 5, Menor: 1
    }

    @Test
    void testMediaEndpoint() throws Exception {
        when(numeroService.media(Arrays.asList(1, 2, 3, 4, 5))).thenReturn(3.0);

        mockMvc.perform(get("/calc/media").param("numeros", "1", "2", "3", "4", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("3.0")); // Média: 3.0
    }

    @Test
    void testNumerosRepetidosEndpoint() throws Exception {
        Map<Integer, Long> repetidos = new HashMap<>();
        repetidos.put(2, 2L);
        repetidos.put(3, 3L);

        when(numeroService.numerosRepetidos(Arrays.asList(1, 2, 2, 3, 3, 3))).thenReturn(repetidos);

        mockMvc.perform(get("/calc/numerosRepetidos").param("numeros", "1", "2", "2", "3", "3", "3"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"2\":2,\"3\":3}"));
    }
}
