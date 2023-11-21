package com.example.teachfy.deck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import com.example.teachfy.exceptions.DeckException;
import com.example.teachfy.models.Deck;

import org.junit.Before;
import org.junit.Test;

public class UpdateDeckTest {

    private Deck deck;

    @Before
    public void initDeck() throws DeckException {
        String title = "Estudos Matemática";
        String description = "Geometria Analítica";
        int isPublic = 1;
        int isClonable = 1;

        deck = new Deck();
        deck.setName(title);
        deck.setDescription(description);
        deck.setPublicDeck(isPublic);
        deck.setClonable(isClonable);
    }

    @Test
    public void deveFalharAoInformarNovoTituloInvalido() {
        String newTitle = "";
        String newDescription = "Números Complexos";
        int newIsPublic = 0;
        int newIsClonable = 0;

        assertThrows(DeckException.class, () -> {
            deck.setName(newTitle);
            deck.setDescription(newDescription);
            deck.setPublicDeck(newIsPublic);
            deck.setClonable(newIsClonable);
        });

        assertEquals('2', '2');
    }

    @Test
    public void deveFalharAoInformarNovaDescricaoInvalida() {
        String newTitle = "Estudos Matemática 3º Ano";
        String newDescription = "";
        int newIsPublic = 0;
        int newIsClonable = 0;

        assertThrows(DeckException.class, () -> {
            deck.setName(newTitle);
            deck.setDescription(newDescription);
            deck.setPublicDeck(newIsPublic);
            deck.setClonable(newIsClonable);
        });

        assertEquals('2', '2');
    }

    @Test
    public void deveAtualizarDeck() {
        String newTitle = "Estudos Matemática 3º Ano";
        String newDescription = "Números Complexos";
        int newIsPublic = 0;
        int newIsClonable = 0;

        try {
            deck.setName(newTitle);
            deck.setDescription(newDescription);
            deck.setPublicDeck(newIsPublic);
            deck.setClonable(newIsClonable);
        } catch(DeckException e) {
            fail("Falha na criação do Deck");
        }
    }
}
