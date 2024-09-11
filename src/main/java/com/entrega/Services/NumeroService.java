package com.entrega.Services;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NumeroService {

    public float soma(float numUm, float numDois) {
        return numUm + numDois;
    }

    public float sub(float numUm, float numDois) {
        return numUm - numDois;
    }

    public float mul(float numUm, float numDois) {
        return numUm * numDois;
    }

    public float div(float numUm, float numDois) {
        if (numUm == 0 || numDois == 0) {
            return 0;
        } else {
            return numUm / numDois;
        }
    }

    public float pow(float numUm, float numDois) {
        return (float) Math.pow(numUm, numDois);
    }

    public int somaLista(List<Integer> numeros) {
        return numeros.stream().mapToInt(Integer::intValue).sum();
    }

    public int[] maiorMenor(List<Integer> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            throw new IllegalArgumentException("A lista não pode ser vazia");
        }
        int maior = Collections.max(numeros);
        int menor = Collections.min(numeros);
        return new int[]{maior, menor};
    }

    public double media(List<Integer> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            throw new IllegalArgumentException("A lista não pode ser vazia");
        }
        return numeros.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public Map<Integer, Long> numerosRepetidos(List<Integer> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            throw new IllegalArgumentException("A lista não pode ser vazia");
        }
        Map<Integer, Long> repetidos = new HashMap<>();
        numeros.stream()
                .filter(n -> numeros.stream().filter(x -> x.equals(n)).count() > 1)
                .forEach(n -> repetidos.put(n, numeros.stream().filter(x -> x.equals(n)).count()));
        return repetidos;
    }

}