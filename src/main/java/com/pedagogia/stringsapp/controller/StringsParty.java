package com.pedagogia.stringsapp.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class StringsParty {

    @GetMapping("/maiusculo")
    public String paraMaiusculo(String text) {
        return text.toUpperCase();
    }

    @GetMapping("/minusculo")
    public String paraMinusculo(String text) {
        return text.toLowerCase();
    }

    @GetMapping("/quantas-palavras")
    public int quantasPalavras(String text) {
        String[] s = text.split(" ");
        return s.length;
    }

    @GetMapping("/tras")
    public String deTrasPraFrente(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    @GetMapping("/template/{numero}")   //o que vem entre chaves é uma variável dinâmica
    public String  preencherTemplate(@PathVariable int numero, String text) {

        Map<Integer, String> template = new HashMap<>();
        template.put(1, "#, Parabéns pra você!");
        template.put(2, "#, Você é demais!");

        return template.get(numero).replaceAll("#", text);
    }

    @GetMapping("/exclui")
    public String excluirDuplicadas(String text) {

        String[] s = text.split(" ");
        String[] removeDuplicateStrings = StringUtils.removeDuplicateStrings(s);
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(removeDuplicateStrings)
                .forEach(s1 -> stringBuilder.append(s1).append(" "));

        return stringBuilder.toString().trim();
    }

}
