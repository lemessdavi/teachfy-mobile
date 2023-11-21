package com.example.teachfy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import com.example.teachfy.exceptions.DeckException;
import com.example.teachfy.exceptions.UserException;
import com.example.teachfy.models.Deck;

import org.junit.Test;

public class DeckTest {

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

    @Test
    public void deveFalharAoInformarNovoTituloInvalido() throws DeckException {
        String title = "Estudos Matemática";
        String description = "Geometria Analítica";
        int isPublic = 1;
        int isClonable = 1;

        Deck deck = new Deck();
        deck.setName(title);
        deck.setDescription(description);
        deck.setPublicDeck(isPublic);
        deck.setClonable(isClonable);

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
    public void deveFalharAoInformarNovaDescricaoInvalida() throws DeckException {
        String title = "Estudos Matemática";
        String description = "Geometria Analítica";
        int isPublic = 1;
        int isClonable = 1;

        Deck deck = new Deck();
        deck.setName(title);
        deck.setDescription(description);
        deck.setPublicDeck(isPublic);
        deck.setClonable(isClonable);

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
    public void deveAtualizarDeck() throws DeckException {
        String title = "Estudos Matemática";
        String description = "Geometria Analítica";
        int isPublic = 1;
        int isClonable = 1;

        Deck deck = new Deck();
        deck.setName(title);
        deck.setDescription(description);
        deck.setPublicDeck(isPublic);
        deck.setClonable(isClonable);

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
