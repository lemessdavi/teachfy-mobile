package com.example.teachfy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import com.example.teachfy.exceptions.CardException;
import com.example.teachfy.exceptions.UserException;
import com.example.teachfy.models.Card;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardTest {

    @Test
    public void deveFalharAoInformarPerguntaInvalida() throws CardException {
        int type = 1;
        String question = "";
        String answer = "49";
        List<String> cardOptions = new ArrayList<>(Arrays.asList("49", "8", "9", "4"));

        assertThrows(CardException.class, () -> {
            Card card = new Card(type, question, answer, cardOptions);
        });

    }

    @Test
    public void deveFalharAoInformarQuantidadeDeOpcoesDiferenteDeQuatro() throws CardException {
        int type = 1;
        String question = "Quanto é 7 x 7?";
        String answer = "49";
        List<String> cardOptions = new ArrayList<>(Arrays.asList("49", "8", "9"));

        assertThrows(CardException.class, () -> {
            Card card = new Card(type, question, answer, cardOptions);
        });
    }

    @Test
    public void deveFalharAoNaoInformarResposta() throws CardException {
        int type = 1;
        String question = "Quanto é 7 x 7?";
        String answer = "";
        List<String> cardOptions = new ArrayList<>(Arrays.asList("49", "8", "9", "4"));

        assertThrows(CardException.class, () -> {
            Card card = new Card(type, question, answer, cardOptions);
        });
    }

    @Test
    public void deveCriarCard() throws CardException {
        int type = 1;
        String question = "Quanto é 7 x 7?";
        String answer = "49";
        List<String> cardOptions = new ArrayList<>(Arrays.asList("49", "8", "9", "5"));

        try {
            Card card = new Card(type, question, answer, cardOptions);
        } catch(CardException e) {
            fail("Falha na criação do objeto Card");
        }
    }
}
