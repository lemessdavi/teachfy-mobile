package com.example.teachfy.deck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import com.example.teachfy.exceptions.DeckException;
import com.example.teachfy.models.Deck;

import org.junit.Test;

public class CreateDeckTest {

    @Test
    public void deveFalharAoInformarTituloInvalido() {
        String title = "";
        String description = "Geometria Analítica";
        int isPublic = 1;
        int isClonable = 1;

        Deck deck = new Deck();

        assertThrows(DeckException.class, () -> {
            deck.setName(title);
            deck.setDescription(description);
            deck.setPublicDeck(isPublic);
            deck.setClonable(isClonable);
        });
    }

    @Test
    public void deveFalharAoInformarDescricaoInvalida() {
        String title = "Estudos Matemática";
        String description = "";
        int isPublic = 1;
        int isClonable = 1;

        Deck deck = new Deck();

        assertThrows(DeckException.class, () -> {
            deck.setName(title);
            deck.setDescription(description);
            deck.setPublicDeck(isPublic);
            deck.setClonable(isClonable);
        });
    }

    @Test
    public void deveCriarDeck() {
        String title = "Estudos Matemática";
        String description = "Geometria Analítica";
        int isPublic = 1;
        int isClonable = 1;

        Deck deck = new Deck();

        try {
            deck.setName(title);
            deck.setDescription(description);
            deck.setPublicDeck(isPublic);
            deck.setClonable(isClonable);
        } catch(DeckException e) {
            fail("Falha na criação do Deck");
        }
    }
}
