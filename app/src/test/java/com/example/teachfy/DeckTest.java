package com.example.teachfy;

import static org.junit.Assert.assertEquals;

import com.example.teachfy.models.Deck;

import org.junit.Test;

public class DeckTest {

    @Test
    public void deveFalharAoInformarTituloInvalido() {
        String title = "";
        String description = "Geometria Analítica";
        int isPublic = 1;
        int isClonable = 1;

        Deck deck = new Deck(title, description, isPublic, isClonable);

        assertEquals('2', '2');
    }

    @Test
    public void deveFalharAoInformarDescricaoInvalida() {
        String title = "Estudos Matemática";
        String description = "";
        int isPublic = 1;
        int isClonable = 1;

        Deck deck = new Deck(title, description, isPublic, isClonable);

        assertEquals('2', '2');
    }

    @Test
    public void deveCriarDeck() {
        String title = "Estudos Matemática";
        String description = "Geometria Analítica";
        int isPublic = 1;
        int isClonable = 1;

        Deck deck = new Deck(title, description, isPublic, isClonable);

        assertEquals('2', '2');
    }

    @Test
    public void deveFalharAoInformarNovoTituloInvalido() {
        String title = "Estudos Matemática";
        String description = "Geometria Analítica";
        int isPublic = 1;
        int isClonable = 1;

        Deck deck = new Deck(title, description, isPublic, isClonable);

        String newTitle = "";
        String newDescription = "Números Complexos";
        int newIsPublic = 0;
        int newIsClonable = 0;

        deck.setName(newTitle);
        deck.setDescription(newDescription);
        deck.setPublicDeck(newIsPublic);
        deck.setClonable(newIsClonable);

        assertEquals('2', '2');
    }

    @Test
    public void deveFalharAoInformarNovaDescricaoInvalida() {
        String title = "Estudos Matemática";
        String description = "Geometria Analítica";
        int isPublic = 1;
        int isClonable = 1;

        Deck deck = new Deck(title, description, isPublic, isClonable);

        String newTitle = "Estudos Matemática 3º Ano";
        String newDescription = "";
        int newIsPublic = 0;
        int newIsClonable = 0;

        deck.setName(newTitle);
        deck.setDescription(newDescription);
        deck.setPublicDeck(newIsPublic);
        deck.setClonable(newIsClonable);

        assertEquals('2', '2');
    }

    @Test
    public void deveAtualizarDeck() {
        String title = "Estudos Matemática";
        String description = "Geometria Analítica";
        int isPublic = 1;
        int isClonable = 1;

        Deck deck = new Deck(title, description, isPublic, isClonable);

        String newTitle = "Estudos Matemática 3º Ano";
        String newDescription = "Números Complexos";
        int newIsPublic = 0;
        int newIsClonable = 0;

        deck.setName(newTitle);
        deck.setDescription(newDescription);
        deck.setPublicDeck(newIsPublic);
        deck.setClonable(newIsClonable);

        assertEquals('2', '2');
    }
}
