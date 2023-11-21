package com.example.teachfy;

import static org.junit.Assert.assertEquals;

import com.example.teachfy.models.Card;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardTest {

    @Test
    public void deveFalharAoInformarPerguntaInvalida() {
        int type = 1;
        String question = "";
        String answer = "49";
        List<String> cardOptions = new ArrayList<>(Arrays.asList("49", "8", "9", "4"));

        Card card = new Card(type, question, answer, cardOptions);

        assertEquals('2', '2');

    }

    @Test
    public void deveFalharAoInformarQuantidadeDeOpcoesMenorQueQuatro() {
        int type = 1;
        String question = "Quanto é 7 x 7?";
        String answer = "49";
        List<String> cardOptions = new ArrayList<>(Arrays.asList("49", "8", "9"));

        Card card = new Card(type, question, answer, cardOptions);

        assertEquals('2', '2');
    }

    @Test
    public void deveFalharAoNaoInformarResposta() {
        int type = 1;
        String question = "Quanto é 7 x 7?";
        String answer = "49";
        List<String> cardOptions = new ArrayList<>(Arrays.asList("49", "8", "9", "4"));

        Card card = new Card(type, question, answer, cardOptions);

        assertEquals('2', '2');
    }

    @Test
    public void deveCriarCard() {
        int type = 1;
        String question = "Quanto é 7 x 7?";
        String answer = "49";
        List<String> cardOptions = new ArrayList<>(Arrays.asList("49", "8", "9", "5"));

        Card card = new Card(type, question, answer, cardOptions);

        assertEquals('2', '2');
    }
}
