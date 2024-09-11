package com.entrega.Controllers;

import com.entrega.Services.NumeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/calc")
public class NumeroController {

    @Autowired
    private NumeroService numeroService;

    @GetMapping("/soma/{num1}/{num2}")
    public float soma(@PathVariable float num1, @PathVariable float num2) {
        return numeroService.soma(num1, num2);
    }

    @GetMapping("/sub/{num1}/{num2}")
    public float sub(@PathVariable float num1, @PathVariable float num2) {
        return numeroService.sub(num1, num2);
    }

    @GetMapping("/mul/{num1}/{num2}")
    public float mul(@PathVariable float num1, @PathVariable float num2) {
        return numeroService.mul(num1, num2);
    }

    @GetMapping("/div/{num1}/{num2}")
    public float div(@PathVariable float num1, @PathVariable float num2) {
        return numeroService.div(num1, num2);
    }

    @GetMapping("/pow/{num1}/{num2}")
    public float pow(@PathVariable float num1, @PathVariable float num2) {
        return numeroService.pow(num1, num2);
    }

    @GetMapping("/somaLista")
    public int somaLista(@RequestParam List<Integer> numeros) {
        return numeroService.somaLista(numeros);
    }

    @GetMapping("/maiorMenor")
    public int[] maiorMenor(@RequestParam List<Integer> numeros) {
        return numeroService.maiorMenor(numeros);
    }

    @GetMapping("/media")
    public double media(@RequestParam List<Integer> numeros) {
        return numeroService.media(numeros);
    }

    @GetMapping("/numerosRepetidos")
    public Map<Integer, Long> numerosRepetidos(@RequestParam List<Integer> numeros) {
        return numeroService.numerosRepetidos(numeros);
    }
}
